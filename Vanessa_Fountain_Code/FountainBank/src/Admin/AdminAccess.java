package Admin;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AdminAccess {
	static String filename;
	static List<Object> results = new ArrayList<Object>();
	static List<Object> compare = new ArrayList<Object>();
	
	public static void AdminAccessor(Integer access, Person person) throws ClassNotFoundException, IOException{
		person.setAccessLevel(access);
		System.out.println("change the access level"+person);
		compare.add(person);
		if(access == 1) {
			filename = "./CustomerInformation";
			readObject(filename);
		}
		if(access == 2) {
			filename = "./EmployeeInformation";
			readObject(filename);
		}
		if(access == 3) {
			filename = "./AdminInformation";
			readObject(filename);
		}
		else if(access == 4){
			filename = "./NewUserInformation";
			readObject(filename);
			//writeObject(filename, person);
		}
		for (int i = 0;i<results.size();i++) {
			//ArrayList user = (ArrayList) compare.get(0);
			Object user = compare.get(0);
			Object compare = results.get(i);
			//System.out.println("to string: " + user.toString());
			//System.out.println(compare.toString());
			//System.out.println("searching array: "+user.getClass() + user);
			//System.out.println("comparing to person entered: "+compare.getClass() + compare);
			if (compare.toString().equals(user.toString())) {
//				System.out.println(user);
//				System.out.println(compare);
				System.out.println("Hello "+ person.getName());
				}
//			if (user.toString()==compare.toString()) {
////				System.out.println(user);
////				System.out.println(compare);
//				System.out.println("Hello "+ person.getName());
//				}
		}
	}
	
	protected static void readObject(String filename) throws ClassNotFoundException, IOException {
		//List<Object> results = new ArrayList<Object>();
		FileInputStream f = new FileInputStream(filename);

	    try {
	        while (true) {
	            ObjectInputStream ois = new ObjectInputStream(f);
	            results.add(ois.readObject());
	        }
	    } catch (EOFException ignored) {
	    } finally {
	        if (f != null) {
	            f.close();
	        }
	    }
	    //System.out.println("results = " + results);
	}
	
	protected static void writeObject(String filename, Person person) {
		System.out.println("Writing new information");
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(filename,true)))
		
		{
			Object obj = person;
			oos.reset();
			oos.writeObject(obj); //serialization
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	//public static void AdminAccessor(Integer accessLevel, Person person) {
		// TODO Auto-generated method stub
		
	//}	
	//
}
