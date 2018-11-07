package Admin;

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
import java.util.Scanner;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import Customer.CustomerAccess;
import Customer.CustomerAccessBase;

public class AdminAccess {
	static Map<Object,Integer> AccountHolderInfo = new HashMap<Object, Integer>();
	static Map<Object, Integer> holder = new HashMap<Object, Integer>();
	static Map<Object,Integer> replaceFile = new HashMap<Object, Integer>();
	private static String url="jdbc:oracle:thin:@revature.cakynjhhcvux.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username= "BankFountain";
	private static String password= "p4ssw0rd";
	static Logger log = Logger.getLogger(CustomerAccess.class);
	
	
	public static Integer main(Person person, Integer acess) throws ClassNotFoundException, IOException {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	System.out.println((char)27 + "[35mEnter: \n  1 to view New Account applications \n  2 to add new Account \n  3 to View a Customer's Account \n  4 to Transfer \n  5 to exit");
	Integer N = Integer.parseInt(scanner.nextLine());
	CustomerAccessBase customer = new CustomerAccessBase();
		//PropertyConfigurator.configure("log4j.properties");
		//public Integer AmountLeft = 300;
		switch(N) {

			case 1:
				//preparedStatementNewUser(person, person.getPin(), person.getSsn(), 3);
				readObject("./NewUserInformation", person);
				System.out.println(replaceFile);
				break;
			case 2:
				
				System.out.println("Enter the Information of the Customer Account you would like to create");
				System.out.println((char)27 + "[35mEnter User Name");
				String name = scanner.nextLine();
				
				System.out.println((char)27 + "[35mEnter User Pin");
				Integer pin = Integer.parseInt(scanner.nextLine());
				
				System.out.println((char)27 + "[35mEnter the Last Four of Social Security Number");
				Integer ssn = Integer.parseInt(scanner.nextLine());
				log.info("New Customer Account Created");
				Person person2 = new Person(name, pin, ssn, 1);
				log.info("Person" + person + "accessLevel" + 1);
				person2.setAccessLevel(1);
				writeObject("./CustomerInformation",person2);
				Customer.CustomerAccessBase.preparedStatementCustomerAccess(person2, 0, 1);
				System.out.println("New Customer Account: " + person2);
				break;
			case 3:
				
				//Integer bal = CustomerAccessBase.Balance(person);
				//System.out.println(bal);
				break;
			case 4:
//				System.out.println("Enter the amount you would like to transfer");
//				Integer TransferAmount = Integer.parseInt(scanner.nextLine());
//				Integer BalanceT = CustomerAccessBase.Balance(person);
//				Integer Transfer = CustomerAccessBase.withdraw(TransferAmount, BalanceT);
//				CustomerAccessBase.updateObject(Transfer, person);
//				
//				System.out.println(Transfer);
//				System.out.println("Enter the Information of the Person you would like to tranfer to");
//				System.out.println((char)27 + "[35mEnter User Name");
//				String name = scanner.nextLine();
//				
//				System.out.println((char)27 + "[35mEnter User Pin");
//				Integer pin = Integer.parseInt(scanner.nextLine());
//				
//				System.out.println((char)27 + "[35mEnter the Last Four of Your Social Security Number");
//				Integer ssn = Integer.parseInt(scanner.nextLine());
//				log.info("person");
//				Person person2 = new Person(name, pin, ssn, 1);
//				log.info("Person" + person + "accessLevel" + 1);
//				
				//Integer DepositAmount2 = Integer.parseInt(scanner.nextLine());
//				Integer BalanceD2 = CustomerAccessBase.Balance(person2);
//				Integer AmountAdded2 = customer.Deposit(TransferAmount, BalanceD2);
//				
//				System.out.println(AmountAdded2);
//				CustomerAccessBase.updateObject(AmountAdded2, person2);
//				
//				Admin.Main.main(null);
//				//Customer.CustomerAccessBase
//				break;
				
			case 5:
				System.out.println("Goodbye "+person.getName());
				System.exit(0);
				//return null;
		}
		return null;
		}
		
		public static void readObject(String filename, Person person) throws ClassNotFoundException, IOException {
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
		public static void preparedStatementNewUser(Person person, Integer pin, Integer ssn,
				Integer accessLevel)
		{
			try(Connection conn=DriverManager.getConnection(url, username, password)){
				String sql= "INSERT INTO EMPLOYEE(NAME,PIN,EMPLOYEE_ACCOUNT,BALANCE ,ACCESS_LEVEL) "+"VALUES(?,?,?,?,?)";
				PreparedStatement ps= conn.prepareStatement(sql);
				ps.setString(1, person.getName());
				ps.setInt(2, pin+ssn);
				ps.setString(3, person.toString());
				ps.setInt(4, 0);
				ps.setInt(5, 3);

				ps.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
					}
			}
		
}
