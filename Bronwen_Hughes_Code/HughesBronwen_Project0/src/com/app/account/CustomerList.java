package com.app.account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8109140945177818132L;

	private static CustomerList instance;

	public ArrayList<Customer> customerList = new ArrayList<>();
	
	private static boolean hasNoFile;

	public void addCustomer(Customer customer) {
		customerList.add(customer);
		System.out.println(customerList.toString());
		//printTo(instance);
		
	}

	private CustomerList() {
		//repopulate(instance);
	}

	public static CustomerList getInstance() {
		if (instance == null) {
			instance = new CustomerList();
			
		}
		/*printTo(instance);
		repopulate(instance);*/
		return instance;
	}
	

	
	
	@Override
	public String toString() {
	//	repopulate(instance);
		return "CustomerList [customerList=" + customerList + "]";
	}

	public static void printTo(CustomerList instance) {
		String fileName = "./CustomerList.txt";
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
			out.writeObject(instance);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void repopulate(CustomerList instance) {
		String fileName = "./CustomerList.txt";
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
			System.out.println("A");
			instance = (CustomerList) in.readObject();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
