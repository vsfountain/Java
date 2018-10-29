package com.example.bank;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main2 {

	public static void main(String[] args) {
		/*String filename = "./sampleObjectFile.txt";*/
		/*String filename = "./Customer.txt";*/
		/*String filename = "./Account.txt";*/
		String filename = "./Employee.txt";
		
		/*Person person = new Person("Michael", 23, "555-05-5589");*/
		
		Customer customer = new Customer(1, "usernameA", "passA", "AA", "aaa");
		Customer customera = new Customer(2, "usernameAAA", "passAaa", "Aaa", "AaA");
		ArrayList<Customer> AaA = new ArrayList<>();
		AaA.add(customer);
		AaA.add(customera);
		
		Employee employeea = new Employee("EmployeeA", "EmployeeA", false);
		Employee employeeaa = new Employee("EmployeeB", "EmployeeB", false);
		Employee employeeaaa = new Employee("admin", "aaa", true);
		ArrayList<Employee> Aaa = new ArrayList<>();
		Aaa.add(employeea);
		Aaa.add(employeeaa);
		Aaa.add(employeeaaa);
		
		
		/*writeObject(filename, person);*/
		/*writeObject(filename, customer);*/
		/*writeAaA(filename, AaA);*/
		writeAaa(filename, Aaa);
		
		/*readObject(filename);*/
		
	}

	static void readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(filename)))
		{
			Object obj = ois.readObject();//de-serialization
			System.out.println(obj);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void writeObject(String filename, Object obj) {
		try(ObjectOutputStream oos =new ObjectOutputStream(
				new FileOutputStream(filename, false)))
		{
			oos.writeObject(obj); //serialization
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static void writeAaA(String filename, ArrayList<Customer> AaA) {
		try(ObjectOutputStream oos =new ObjectOutputStream(
				new FileOutputStream(filename, false)))
		{
			for(Customer aaa: AaA) {
			oos.writeObject(aaa); //serialization
			System.out.println(aaa);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static void writeAaa(String filename, ArrayList<Employee> Aaa) {
		try(ObjectOutputStream oos =new ObjectOutputStream(
				new FileOutputStream(filename, false)))
		{
			for(Employee aaa: Aaa) {
			oos.writeObject(aaa); //serialization
			System.out.println(aaa);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

