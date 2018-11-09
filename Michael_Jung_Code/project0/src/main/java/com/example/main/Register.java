package com.example.main;

import java.util.Scanner;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

public class Register {

	public static String askUsername() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like your username to be?"
							+ "\nb) Exit");
		
		boolean lo = true;
		while(lo) {
			String username = sc.next();
			//System.out.println(username + "d");
			if(username.equals("b")) {
				return "b"; 
			} else if(username.equals("")) {
				System.out.println("Please enter a username");
			} else {
				CustomerService customerService = new CustomerServiceImpl();
				String dbUsername = customerService.getCustomerName(username);
				if(dbUsername.equals("")) {
					
					
					
					return username;
				} else {
					System.out.println("Username \"" + dbUsername + "\" is taken:"
										+ "\nPlease choose another");
				}
				//return username;
			}
		}
		return null;
		
	}
	
	
	public static String askPassword() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like your password to be?"
							+ "\nb) Exit");
		boolean lo = true;
		while(lo) {
			String password = sc.next();
			if(password.equals("b")) {
				return "b";
			} else if (password.equals("")) {
				System.out.println("Please enter a password");
			} else {
				return password;
			}
			
			
			
		}
		return null;	
		
	}
	
	
	public static String askFirstName() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your first name?"
							+ "\nb) Exit");
		boolean lo = true;
		while(lo) {
			String firstName = sc.next();
			if(firstName.equals("b")) {
				return "b";
			} else if (firstName.equals("")) {
				System.out.println("Please enter first name");
			} else {
				return firstName;
			}
		}
		return null;
	}
	
	
	public static String askLastName() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your last name?"
							+"\nb) Exit");
		boolean lo = true;
		while(lo) {
			String lastName = sc.next();
			if(lastName.equals("b")) {
				return "b";
			} else if (lastName.equals("")) {
				System.out.println("Please enter last name");
			} else {
				return lastName;
			}
		}
		return null;
		
	}
	
	
	public static int createCustomer(String username, String password, 
										String firstName, String lastName) {
		
		Customer c = new Customer(username, password, firstName, lastName);
		CustomerService customerService = new CustomerServiceImpl();
		return customerService.createCustomer(c);
		
		
		
		
	}
	
	
}
