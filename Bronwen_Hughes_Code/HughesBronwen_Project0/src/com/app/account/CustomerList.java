package com.app.account;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CustomerList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8109140945177818132L;

	private static CustomerList instance;

	public static ArrayList<Customer> customerList = new ArrayList<>();
	static ArrayList<Object> results = new ArrayList<>();

	private static boolean hasNoFile;

	public void addCustomer(Customer customer) {
		customerList.add(customer);
	//	System.out.println(customerList.toString());

		//repopulate(customerList);
		 printTo();
	}

	private CustomerList() {

		//printTo();
		 repopulate(customerList);
	}

	public static CustomerList getInstance() {
		if (instance == null) {
			instance = new CustomerList();
		}
		return instance;
	}

	@Override
	public String toString() {
		return "CustomerList [customerList=" + customerList + "]";
	}

	public static void printTo() {
		System.out.println("READING FROM ARRAY!  " + customerList);
		String fileName = "./CustomerList.txt";
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(customerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void repopulate(ArrayList<Customer> list) {
		System.out.println("WRITING TO ARRAY" + customerList);
		String fileName = "./CustomerList.txt";

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			customerList = (ArrayList<Customer>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally: " + customerList);
		}
	}

}
