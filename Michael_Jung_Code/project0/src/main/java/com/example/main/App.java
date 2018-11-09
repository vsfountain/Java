package com.example.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.example.model.Customer;
import com.example.model.Employee;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

public class App {

	
	final static Logger logger = Logger.getLogger(Main.class);
	
	public static void runProgram() {
		//userPrompt: Welcome to the bank
		
		//while loop iterating until user exits
			//userPrompt: Would you like to
			//Register
				//registerPrompt
					//What would you like your username to be?
					//b) Exit
					//while loop iterating if user enters username already belonging
					//to system or when b is entered
					//What would you like your password to be?
					//b) Exit
					//accept all input, if 'b', exit
					//What is your first name?
					//b) Exit
					//accept all input, if 'b', exit
					//What is your last name?
					//accept all input, if 'b', exit
				//
			//Log In (customer)
			//Log In (employee)
		
		runPrompt();
		//registerPrompt();
		
		
		
		
		
		
	}
	
	
	public static void runPrompt() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome");
		
		boolean lo = true;
		while(lo) {
		
		
		System.out.println("What would you like to do?"
							+"\na) Register"
							+"\nb) Log In (customer)"
							+"\nc) Log In (employee)"
							+"\nd) Exit");
		
		
		
		String userInput = sc.next();
		if(userInput.equals("a")) {
			registerPrompt();
		} else if (userInput.equals("b")) {
			logIn();
		} else if (userInput.equals("c")) {
			
		} else if (userInput.equals("d")) {
			System.out.println("Thank you for using Bank Main");
			System.exit(0);
		} else {
			System.out.println("Please choose 'a', 'b', 'c', or 'd'");
		}
		
		
		
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	public static void logInEmployee() {
		
		Employee e = LogInEmployee.logInEmployeePrompt();
		
		
	}
	
	
	
	
	public static void logIn() {
		
		Customer c = LogIn.logInPrompt();
		
		Scanner sc = new Scanner(System.in);
		if(c == null) {
			return;
		} else {
			
			boolean lo = true;
			while(lo) {
			
			System.out.println("What would you like to do?"
								+ "\na) Register an Account"
								+ "\nb) Register a Joint Account"
								+ "\nc) Make a Deposit"
								+ "\nd) Make a Withdrawal"
								+ "\ne) Transfer funds between Accounts"
								+ "\nf) Exit");
			
			
			String userInput = sc.next();
			
			if(userInput.equals("a")) {
				LogIn.registerAccount(c);
			} else if (userInput.equals("b")) {
				LogIn.registerJointAccount(c);
			} else if (userInput.equals("c")) {
				LogIn.depositPrompt(c);
			} else if (userInput.equals("d")) {
				LogIn.withdrawalPrompt(c);
			} else if (userInput.equals("e")) {
				LogIn.transferPrompt(c);
			} else if (userInput.equals("f")) {
				return;
			} else {
				System.out.println("Please choose 'a', 'b', 'c', 'd', 'e', or 'f'");
			}
			
			}
			
		}
		
		
	}
	
	
	public static int registerPrompt() {
		
		String username = Register.askUsername();
		if(username.equals("b") ) {
			return 0;
		}
		String password = Register.askPassword();
		if(password.equals("b")) {
			return 0;
		}
		String firstName = Register.askFirstName();
		if(firstName.equals("b")) {
			return 0;
		}
		String lastName = Register.askLastName();
		if(lastName.equals("b")) {
			return 0;
		}
		int customerCreate = Register.createCustomer(username, password, firstName, lastName);
		if(customerCreate == 1) {
			System.out.println("User \"" + username + "\" created");
			
			//log
			logger.info("User \"" + username + "\" has been created");
			return 1;
		} else {
			System.out.println("Creating user \"" + username + "\" unsuccessful");
			return 0;
			//log
		}
		
		
		
		
	}
	
	
	public static void aaa() {
		CustomerService customerService = new CustomerServiceImpl();
		//Customer customer = new Customer(null, "customer1", "customer1", "customer1", "customer1");
		List<Customer> customers = customerService.getAllCustomer();
		/*String a = customerService.getCustomerName("customer1");
		System.out.println(a);*/
		
		for(Customer c: customers) {
			System.out.println(c);
		}
		System.out.println("done");
		
		
	}
	
	
}
