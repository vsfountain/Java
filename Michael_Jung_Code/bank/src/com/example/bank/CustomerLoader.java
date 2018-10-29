package com.example.bank;

import java.util.ArrayList;

import java.io.*;

public class CustomerLoader {

	
	
	public static ArrayList<Customer>  loadCustomer() {
		
		String filename = "C:\\Users\\Michael's Laptop\\Documents\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\Bank\\Customer.txt"/*"C:\\Users\\Michael's Laptop\\Documents\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\Bank\\src\\com\\example\\bank\\Customer.txt"*/;
		
		ArrayList<Customer> aaa = new ArrayList<>();
		
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(filename)))
		{
			System.out.println(ois.available());
			
			while(true) {
			Object obj = ois.readObject();//de-serialization
			Customer a = (Customer) obj;
			aaa.add(a);
			/*System.out.println(obj);*/
			System.out.println(a);
			}
			
			/*Object oaa = ois.readObject();
			Customer aaa = (Customer) oaa;
			System.out.println(oaa);*/
			
			
		}catch(EOFException e) {
			e.printStackTrace();
			return aaa;
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return aaa;
		
		
		
		
		
		/*ArrayList<Customer> a = new ArrayList<>();
		
		File file = new File("C:\\Users\\Michael's Laptop\\Documents\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\Bank\\src\\com\\example\\bank\\Customer.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String aa = "";
		String [] aaa;
		while((aa = br.readLine()) != null) {
			aaa = aa.split("|");
			
			Customer aaaa = new Customer();
			
			
			
			
			
		}
		*/
		
	}
	

	
	static void writeCustomer(/*String filename, */ArrayList<Customer> AaA) {
		String filename = "./Customer.txt";
		try(ObjectOutputStream oos =new ObjectOutputStream(
				new FileOutputStream(filename, false)))
		{
			for(Customer aaa: AaA) {
			oos.writeObject(aaa); //serialization
			/*System.out.println(aaa);*/
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
