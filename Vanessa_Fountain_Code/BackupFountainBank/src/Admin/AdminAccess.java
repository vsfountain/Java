package Admin;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
import java.util.Set;
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
	System.out.println((char)27 + "[35mEnter: \n  1 to view New Account applications \n  2 to add new Account \n  3 to View a Customer's Account \n  4 to view All Accounts \n  5 to exit");
	Integer N = Integer.parseInt(scanner.nextLine());
	CustomerAccessBase customer = new CustomerAccessBase();
		//PropertyConfigurator.configure("log4j.properties");
		//public Integer AmountLeft = 300;
		//Object key;
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
				readObject("./CustomerInformation", person2);
				writeObject("./CustomerInformation");
				Customer.CustomerAccessBase.preparedStatementCustomerAccess(person2, 0, 1);
				System.out.println("New Customer Account: " + person2);
				break;
				
			case 3:
				System.out.println("Enter the Information of the Customer Account you would like to view");
				System.out.println((char)27 + "[35mEnter User Name");
				String name3 = scanner.nextLine();
				
				System.out.println((char)27 + "[35mEnter User Pin");
				Integer pin3 = Integer.parseInt(scanner.nextLine());
				
				System.out.println((char)27 + "[35mEnter the Last Four of Social Security Number");
				Integer ssn3 = Integer.parseInt(scanner.nextLine());
				log.info("Admin is viewing a customer");
				Person person3 = new Person(name3, pin3, ssn3, 1);
				
				log.info("Customer Account" + person3 + "accessLevel" + 1);
				person3.setAccessLevel(1);
				
				readObject("./CustomerInformation", person3);
				System.out.println(AccountHolderInfo);
			
				break;
			case 6:
				
				System.out.println("Enter the Account Information you would like to Close");
				System.out.println((char)27 + "[35mEnter User Name");
				String name4 = scanner.nextLine();
				
				System.out.println((char)27 + "[35mEnter User Pin");
				Integer pin4 = Integer.parseInt(scanner.nextLine());
				
				System.out.println((char)27 + "[35mEnter the Last Four of Your Social Security Number");
				Integer ssn4 = Integer.parseInt(scanner.nextLine());
				
				Person person4 = new Person(name4, pin4, ssn4, 1);
				log.info("Deleting Account: " + person4 + "accessLevel" + 1);
				readObject("./CustomerInformation", person4);
				
				for (Entry<Object, Integer> entry : replaceFile.entrySet()) {
					//Object key = null ;
				    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				    if(entry.getKey().toString().equals(person4.toString())) {
				    	System.out.println("Closing the account: "+person4);
				    	replaceFile.remove(entry);
				    	overWriteObject("./CustomerInformation");
				    	break;
				    	//replaceFile.remove(entry.getKey());
				    	//System.out.println("Match found: "+ entry.getValue());
				    }
				    //replaceFile.remove(key);
				    System.out.println(replaceFile);
				}
				
				//overWriteObject("./CustomerInformation");
				preparedStatementDelete(person4);
				System.out.println(replaceFile);	
				break;
				
			case 4:
				readObject("./CustomerInformation",person);
				System.out.println(replaceFile);
				break;
			case 5:
				System.out.println("Goodbye "+person.getName());
				
				System.exit(0);
				//return null;
		}
		return AdminAccess.main(person, acess);
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
		
		protected static void writeObject(String filename) {
			System.out.println("Writing new information");
			
			try(ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(filename))){
				Object obj = holder;
				oos.reset();
				oos.writeObject(obj); //serialization
				oos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		
		}
		
		protected static void overWriteObject(String filename) throws IOException {
			System.out.println("Writing new information");
			FileOutputStream fout = new FileOutputStream("./CustomerInformation");
			@SuppressWarnings("resource")
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(replaceFile);
			System.out.println(replaceFile);
		}
		
		protected static void updateObject(Integer number,Person person) throws IOException{
			//preparedStatementCustomerAccess(person, number, 1);
			//updateSQLCustomer(number, person);
			for (Entry<Object, Integer> entry : replaceFile.entrySet()) {
			    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			    if(entry.getKey().toString().equals(person.toString())) {
			    	entry.setValue(number);
			    	//System.out.println("Match found: "+ entry.getValue());
			    }
			}
			System.out.println("Writing new information");
			FileOutputStream fout = new FileOutputStream("./CustomerInformation");
			@SuppressWarnings("resource")
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(replaceFile);
			System.out.println(replaceFile);
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
		
		public static void preparedStatementDelete(Person personToDelete)
		{
			try(Connection conn=DriverManager.getConnection(url, username, password)){
				String sql= "DELETE FROM CUSTOMER WHERE CUSTOMER_ACCOUNT = ?";
				PreparedStatement ps= conn.prepareStatement(sql);
				
				ps.setString(1, personToDelete.toString());

				ps.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
					}
			}
		
		
}
