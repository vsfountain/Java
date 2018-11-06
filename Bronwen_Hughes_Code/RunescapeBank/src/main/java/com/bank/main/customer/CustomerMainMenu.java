package com.bank.main.customer;

import com.bank.account.service.AccountService;
import com.bank.account.service.AccountServiceImpl;
import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerService;
import com.bank.customer.service.CustomerServiceImpl;
import com.bank.main.ScannerSingleton;
import com.bank.registration.model.Registration;
import com.bank.registration.service.RegistrationService;
import com.bank.registration.service.RegistrationServiceImpl;

public class CustomerMainMenu {
	CustomerService customerService = new CustomerServiceImpl();
	RegistrationService registrationService = new RegistrationServiceImpl();
	AccountService accountService = new AccountServiceImpl();

	public CustomerMainMenu() {
		registrationService.createRegistrationDB();
		customerService.createCustomerDB();
		accountService.createAccountDB();
		chooseAction();
	}

	void chooseAction() {
		System.out.println("[A] Login [B] Register");
		String temp = ScannerSingleton.instance().next().toUpperCase();

		switch (temp) {
		case "A":
			attemptLogin();
			break;
		case "B":
			register();
			break;
		default:
			System.out.println("Please enter a valid reponse.");
			chooseAction();
			break;
		}
	}

	void attemptLogin() {
		System.out.println("Please enter your credentials.");
		System.out.print("Username: ");
		String username = ScannerSingleton.instance().next();
		System.out.print("Password: ");
		String password = ScannerSingleton.instance().next();
		
		boolean temp = checkCredentials(username, password);
		if(temp) {
			new CustomerPortal(customerService.getCustomerFromUsername(username));
		} else if(!temp) {
			while (true) {
				System.out.println("Would you like to try again? [Y/N] ");
				String tempS = ScannerSingleton.instance().next().toUpperCase();

				switch (tempS) {
				case "Y":
					attemptLogin();
					break;
				case "N":
					break;
				default:
					System.out.println("Please enter a valid response.");
					break;
				}
			}
		}
	}
	
	public boolean checkCredentials(String username, String password) {
		Customer c = customerService.getCustomerFromUsername(username);
		System.out.println("c: " + c);
		if(c == null) {
			System.out.println("There is no account associated with this username.");
			return false;
		}
		else if(c.getPassword().equals(password)) {
			System.out.println("Credentials accepted. Logging in.");
			return true;
		} else {
			System.out.println("Your username and password conbination is not correct. ");
			return false;
		}
	}

	void register() {
		System.out.println("[ CUSTOMER REGISTRATION ]");
		System.out.print("Enter your desired username: ");
		// ADD CHECK DESIRED USERNAME HERE!
		String username = ScannerSingleton.instance().next();

		String password;
		while (true) {
			System.out.print("Enter your desired Password: ");
			String password1 = ScannerSingleton.instance().next();

			System.out.print("Confirm your password: ");
			String password2 = ScannerSingleton.instance().next();

			if (password1.equals(password2)) {
				password = password1;
				break;
			}
		}

		System.out.print("Enter your first name: ");
		String firstname = ScannerSingleton.instance().next();

		System.out.print("Enter your last name: ");
		String lastname = ScannerSingleton.instance().next();

		boolean jointCustomer = checkIfJoint();

		// TODO - CONFIRM DETAILS TO SUBMIT!

		// TODO - INCREMENT IN JAVA
		Registration tempRegistration = new Registration(registrationService.getAllRegistration().size() + 1, username, password, firstname, lastname, jointCustomer);
		registrationService.addRegistration(tempRegistration);
		// Employee tempEmployee = new Employee(7, username, password, firstname,
		// lastname, admin);
		// employeeService.addEmployee(tempEmployee);
	}

	boolean checkIfJoint() {
		while (true) {
			System.out.println("Are you a joint customer? [Y / N]");
			String temp = ScannerSingleton.instance().next().toUpperCase();

			switch (temp) {
			case "Y":
				return true;
			case "N":
				return false;
			default:
				System.out.println("Please enter a valid response.");
				break;
			}
		}
	}
}
