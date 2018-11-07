package Customer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import Admin.Person;

public class CustomerAccessBase {
	static String filename = "./CustomerInformation";
	static Map<Object,Integer> AccountHolderInfo = new HashMap<Object, Integer>();
	static Map<Object, Integer> holder = new HashMap<Object, Integer>();
	static Map<Object,Integer> replaceFile = new HashMap<Object, Integer>();
	private static String url="jdbc:oracle:thin:@revature.cakynjhhcvux.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username= "BankFountain";
	private static String password= "p4ssw0rd";
	
	static Logger log = Logger.getLogger(CustomerAccessBase.class);
	
	
	protected static Integer withdraw(Integer WithdrawAmount, Integer val) {
		
		val -= WithdrawAmount;
		if (val<0) {
			System.out.println("Insufficient Funds");
			val += WithdrawAmount;
		}
		return val;
	}
	Integer Deposit(Integer DepositAmount, Integer AmountLeft) {
		return AmountLeft += DepositAmount;
	}
	Integer Transfer() {
		return null;
	}
	
	protected static Integer Balance(Person person) throws ClassNotFoundException, IOException {
		PropertyConfigurator.configure("log4j.properties");
		
		Integer num = null;
		readObject(filename, person);
		//System.out.println("first read obj: "+replaceFile);
		for (Entry<Object, Integer> entry : AccountHolderInfo.entrySet()) {
			num = entry.getValue();
			//System.out.println("value to replace: "+ num);
		}
		System.out.println("Balance: "+num);
		log.info("Balance for: "+person + num);
		return num;
	}
	
	//protected static Integer
	
	
	public static void preparedStatementCustomerAccess(Person person, Integer number2, int i)
	{
		try(Connection conn=DriverManager.getConnection(url, username, password)){
			String sql= "INSERT INTO CUSTOMER(CUSTOMER_ACCOUNT,NAME,PIN,BALANCE,ACCESS_LEVEL) "+"VALUES(?,?,?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1, person.toString());
			ps.setString(2,person.getName());
			ps.setInt(3, person.getPin()+person.getSsn());
			//ps.setInt(4, person.getSsn());
			ps.setInt(4, number2);
			ps.setInt(5, 1);

			ps.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				}
		}
	
	
	public static void updateSQLCustomer(Integer number, Person person){
			try(Connection conn=DriverManager.getConnection(url, username, password)){
				String sql= "UPDATE CUSTOMER SET BALANCE = ? WHERE CUSTOMER_ACCOUNT = ? ";
				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setString(1,number + "");
				//ps.setInt(4, number);
				ps.setString(2, person.toString());

				ps.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
					}
		
	}
	
	//public static Integer viewAccount(Person person) throws ClassNotFoundException, IOException {
		//readObject(filename, person);
		//replaceFile.get(person)
		//return null;
		
	//}
	protected static void updateObject(Integer number,Person person) throws IOException{
		//preparedStatementCustomerAccess(person, number, 1);
		updateSQLCustomer(number, person);
		for (Entry<Object, Integer> entry : replaceFile.entrySet()) {
		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    if(entry.getKey().toString().equals(person.toString())) {
		    	entry.setValue(number);
		    	System.out.println("Match found: "+ entry.getValue());
		    }
		}
		System.out.println("Writing new information");
		FileOutputStream fout = new FileOutputStream(filename);
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(replaceFile);
		System.out.println(replaceFile);
	}
	@SuppressWarnings("unchecked")
	protected static void readObject(String filename, Person person) throws ClassNotFoundException, IOException {
		FileInputStream f = new FileInputStream(filename);
		Map<Object,Integer> map = new HashMap<Object, Integer>();
		holder.put(person, 0);
	    try {
	        while (true) {	            
	        	ObjectInputStream ois = new ObjectInputStream(f);
	            Object obj = ois.readObject();
	            
	            map = (Map<Object, Integer>) obj;
	            replaceFile.putAll(map);
	            Object j = holder.keySet();
	            Object k = map.keySet();
	            //System.out.println("j and k: "+j + k);
	            for (Entry<Object, Integer> entry : map.entrySet()) {
	    		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	    		    if(entry.getKey().toString().equals(person.toString())) {
	    		    	AccountHolderInfo.put(entry.getKey(), entry.getValue());
	    		    	//System.out.println("Match found: "+ AccountHolderInfo);
	    		    }
 	            }
	           }
	        }catch(EOFException ignored){}
	    finally{
	    	if (f != null){
	    		f.close();
	    		}
	    	}
	    }
	
	protected static void writeObject(String filename, Person person) {
		System.out.println("Writing new information");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(filename,true))){
			Object obj = holder;
			oos.reset();
			oos.writeObject(obj); //serialization
			oos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	
	}
}
