package Admin;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import Customer.CustomerAccess;

public class Bank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1704823035222108376L;
	/**
	 * 
	 */
	static String filename;
	static Map<Object,Integer> AccountHolderInfo = new HashMap<Object, Integer>();
	static Map<Object, Integer> holder = new HashMap<Object, Integer>();
	static Map<Object,Integer> replaceFile = new HashMap<Object, Integer>();
	
	public static void Bank(Integer accessLevel, Person person) throws ClassNotFoundException, IOException{
		person.setAccessLevel(accessLevel);
		System.out.println("change the access level"+person);
		holder.put(person, 0);
		if(accessLevel == 1) {
			filename = "./CustomerInformation";
			readObject(filename, person);
			UsersAccessIsCustomer(accessLevel,person);
		}
		if(accessLevel == 2) {
			filename = "./EmployeeInformation";
			readObject(filename, person);
		}
		if(accessLevel == 3) {
			filename = "./AdminInformation";
			readObject(filename, person);
		}
		else if(accessLevel == 4){
			filename = "./NewUserInformation";
			readObject(filename, person);
			//writeObject(filename, person);
		}
	}
		
	private static void UsersAccessIsCustomer(Integer accessLevel, Person person) throws IOException {
		//String val = AccountHolderInfo.values();
		//Integer num = Integer.parseInt(val.subSequence(1, val.length()-1).toString());
		//CharSequence num1 = val.subSequence(1, val.length()-1);
		//Integer num = Integer.parseInt(num1.toString());
		//Integer num =
		//Set<Entry<Object, Integer>> num = AccountHolderInfo.entrySet();
		//num = CustomerAccess.main(person, num);
		//holder.replace(person, num);
		Integer num = null;
		for (Entry<Object, Integer> entry : replaceFile.entrySet()) {
			num = entry.getValue();
			//CustomerAccess.main(person, num);
		}
		num = CustomerAccess.main(person, num);
			
		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    //if(entry.getKey().toString().equals(person.toString())) {
		    	//entry.setValue(num);
		    	//System.out.println("Match found: ");
		//CustomerAccess.main(person, num);
		updateObject(num, person);
		//System.out.println(holder);
		
	}

	private static void updateObject(Integer number,Person person) throws IOException{
		for (Entry<Object, Integer> entry : replaceFile.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    if(entry.getKey().toString().equals(person.toString())) {
		    	entry.setValue(number);
		    	System.out.println("Match found: ");
		    }
		    System.out.println(replaceFile);
		}
		System.out.println("Writing new information");
		FileOutputStream fout = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(replaceFile);
	}

	@SuppressWarnings("unchecked")
	protected static void readObject(String filename, Person person) throws ClassNotFoundException, IOException {
		FileInputStream f = new FileInputStream(filename);
		Map<Object,Integer> map = new HashMap<Object, Integer>();
	    try {
	        while (true) {	            
	        	ObjectInputStream ois = new ObjectInputStream(f);
	            Object obj = ois.readObject();
	            
	            map = (Map<Object, Integer>) obj;
	            replaceFile.putAll(map);
	            Object j = holder.keySet();
	            Object k = map.keySet();
	            
	            if(j.toString().equals(k.toString())) {
	            	System.out.println("Hello "+person.getName());
	            	AccountHolderInfo = map;
	            	System.out.println("Account found: "+map);
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
				new FileOutputStream(filename,true)))
		
		{
			Object obj = holder;
			oos.reset();
			oos.writeObject(obj); //serialization
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
}

//	public static void UsersAccessIsCustomer(Integer access, Person person){
//		Object user = compare.get(0);
//		//results.
//		System.out.println("user from resulting map "+ results.get(user));
////		for (int i = 0;i<results.size();i++) {
////			Object user = compare.get(0);
////			//Object compare = results.get(i);
////			System.out.println("user from resulting map "+ results.get(user));
////			if(results.get(user) != null) {
////				System.out.println("Hello "+person.getName());
////			}
////			Object user = compare.get(0);
////			System.out.println(user);
////			Object compare = results.get(i);
////			System.out.println(compare);
////			if (compare.toString().equals(user.toString())) {
////				System.out.println("Hello "+ person.getName());
////				Customer.CustomerAccess.main(person);
////				}
//			//}
//		}
//	
//	public static void UsersAccessIsEmployee(Integer access, Person person){
//		for (int i = 0;i<results.size();i++) {
//			Object user = compare.get(0);
//			Object compare = results.get(i);
//			if (compare.toString().equals(user.toString())) {
//				System.out.println("Hello "+ person.getName());
//				Employee.EmployeeAccess.main(person);
//				}
//			}
//		}
//		
//	public static void UsersAccessIsAdmin(Integer access, Person person){
//		for (int i = 0;i<results.size();i++) {
//			Object user = compare.get(0);
//			//Object compare = results.get(i);
//			if(results.get(user) != null) {
//				System.out.println("Hello" + person.getName());
//			}
////			if (compare.toString().equals(user.toString())) {
////				System.out.println("Hello "+ person.getName());
////				Admin.AdminAccess.main(person);
////				}
//		}
//	}
//	
//	public static void UsersAccessIsNewUser(Integer access, Person person){
//		for (int i = 0;i<results.size();i++) {
//			Object user = compare.get(0);
//			if(results.get(user) != null) {
//				System.out.println("Hello" + person.getName());
//			//Object compare = results.get(i);
//			
//			//System.out.println(compare);
//			//if (compare.toString().equals(user.toString())) {
//				//System.out.println("Hello "+ person.getName());
//				//NewUser.NewUserAccess.main(person);
//				}
//			}
//		}
//	
//	protected static void readObject(String filename) throws ClassNotFoundException, IOException {
//		FileInputStream f = new FileInputStream(filename);
//
//	    try {
//	        while (true) {
//	            ObjectInputStream ois = new ObjectInputStream(f);
//	            //results.add(ois.readObject());
//	            Object obj = ois.readObject();
//	            //System.out.println(obj);
//	            results.put((Person)obj,0);
//	            //System.out.println("added to map"+results);
//	        }
//	    } catch (EOFException ignored) {
//	    } finally {
//	        if (f != null) {
//	            f.close();
//	        }
//	    }
//	}
//	
//	@SuppressWarnings("static-access")
//	protected static void updateObject(String filename, Person person) throws FileNotFoundException, IOException, ClassNotFoundException {
//		FileInputStream f = new FileInputStream(filename);
//		try {
//			while(true) {
//				ObjectInputStream os = new ObjectInputStream(f);
//				Object obj = person;
//				Object line = os.readObject();
//				
//				if(obj.toString().equals(line.toString())) { 
//					//change part of the object
//					//writeObject(filename, person);
//					line = os.SUBSTITUTION_PERMISSION;
//					line = obj;
//					writeObject(filename,(Person) line);
//					System.out.println("updating information"+ results);
//				}
//			}
//		}finally {
//			if(f != null) {
//				f.close();
//			}
//		}
//	}
//	
//	protected static void writeObject(String filename, Person person) {
//		System.out.println("Writing new information");
//		try(ObjectOutputStream oos = new ObjectOutputStream(
//				new FileOutputStream(filename,true)))
//		
//		{
//			Object obj = person;
//			oos.reset();
//			oos.writeObject(obj); //serialization
//			oos.close();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	
//	}
//	
//}
//
