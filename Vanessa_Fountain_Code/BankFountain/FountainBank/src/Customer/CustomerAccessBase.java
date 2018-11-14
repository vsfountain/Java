package Customer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Admin.Person;

public class CustomerAccessBase {
	static String filename = "./CustomerInformation";
	static Map<Object,Integer> AccountHolderInfo = new HashMap<Object, Integer>();
	static Map<Object, Integer> holder = new HashMap<Object, Integer>();
	static Map<Object,Integer> replaceFile = new HashMap<Object, Integer>();	
	
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
	
		Integer num = null;
		readObject(filename, person);
		System.out.println("first read obj: "+replaceFile);
		for (Entry<Object, Integer> entry : AccountHolderInfo.entrySet()) {
			num = entry.getValue();
			System.out.println("value to replace: "+ num);
		}
		System.out.println("Balance: "+num);
		return num;
	}
	
	protected static void updateObject(Integer number,Person person) throws IOException{
		for (Entry<Object, Integer> entry : replaceFile.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
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
	            System.out.println("j and k: "+j + k);
	            for (Entry<Object, Integer> entry : map.entrySet()) {
	    		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	    		    if(entry.getKey().toString().equals(person.toString())) {
	    		    	AccountHolderInfo.put(entry.getKey(), entry.getValue());
	    		    	System.out.println("Match found: "+ AccountHolderInfo);
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
	
	protected static void PreparedStatement(String filename, Person person) {
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