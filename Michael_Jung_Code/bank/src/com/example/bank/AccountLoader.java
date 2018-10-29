package com.example.bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AccountLoader {

	
	
	public static ArrayList<Account> loadAccount() {
		
String filename = "C:\\Users\\Michael's Laptop\\Documents\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\Bank\\Account.txt"/*"C:\\Users\\Michael's Laptop\\Documents\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\Bank\\src\\com\\example\\bank\\Customer.txt"*/;
		
		ArrayList<Account> aaa = new ArrayList<>();
		
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(filename)))
		{
			System.out.println(ois.available());
			
			while(true) {
			Object obj = ois.readObject();//de-serialization
			Account a = (Account) obj;
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
		
		
		
		
		
	}
	
	
	static void writeAccount(/*String filename, */ArrayList<Account> AaA) {
		String filename = "./Account.txt";
		try(ObjectOutputStream oos =new ObjectOutputStream(
				new FileOutputStream(filename, false)))
		{
			for(Account aaa: AaA) {
			oos.writeObject(aaa); //serialization
			/*System.out.println(aaa);*/
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
