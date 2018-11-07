package com.bank.main.customer;

import org.apache.log4j.Logger;

import com.bank.account.service.AccountService;
import com.bank.account.service.AccountServiceImpl;
import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerService;
import com.bank.customer.service.CustomerServiceImpl;
import com.bank.main.Main;
import com.bank.main.ScannerSingleton;
import com.bank.registration.model.Registration;
import com.bank.registration.service.RegistrationService;
import com.bank.registration.service.RegistrationServiceImpl;

public class CustomerMainMenu {
	
	final static Logger logger = Logger.getLogger(CustomerMainMenu.class);
	
	CustomerService customerService = new CustomerServiceImpl();
	RegistrationService registrationService = new RegistrationServiceImpl();
	AccountService accountService = new AccountServiceImpl();
	boolean choosing = true;
	
	public CustomerMainMenu() {
		while (choosing) {
			chooseAction();
		}
	}

	void chooseAction() {
		System.out.println("[A] Login [B] Register [U] Back [X] Exit");
		String temp = ScannerSingleton.instance().next().toUpperCase();

		switch (temp) {
		case "A":
			attemptLogin();
			break;
		case "B":
			register();
			break;
		case "U":
			choosing = false;
			new Main();
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
		if (temp) {
			new CustomerPortal(customerService.getCustomerFromUsername(username));
		} else if (!temp) {
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
		if (c == null) {
			System.out.println("There is no account associated with this username.");
			logger.warn("Customer User tried to log in without a username that was registered.");
			return false;
		} else if (c.getPassword().equals(password)) {
			System.out.println("Credentials accepted. Logging in.");
			logger.info("Customer User managed to login.");
			return true;
		} else {
			logger.warn("Customer User inputed wrong combination");
			System.out.println("Your username and password combination is not correct. ");
			return false;
		}
	}

	void register() {
		System.out.println("[ CUSTOMER REGISTRATION ]");
		System.out.print("Enter your desired username: ");
		
		String username = ScannerSingleton.instance().next();

		String password;
		while (true) {
			System.out.print("Enter your desired Password: ");
			String password1 = ScannerSingleton.instance().next();

			System.out.print("Confirm your password: ");
			String password2 = ScannerSingleton.instance().next();

			if (password1.equals(password2)) {
				logger.info("Customer managed to login.");
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
		if (jointCustomer) {
			
			logger.info("Joint customer registration submitted.");
			int person1 = registrationService.getAllRegistration().size() + 1;

			Registration tempRegistration = new Registration(person1, username, password, firstname, lastname,
					person1 + 1);
			registrationService.addRegistration(tempRegistration);

			addJoint(person1);
		}
		if (!jointCustomer) {
			
			logger.info("Single customer registration submitted.");
			int temp = registrationService.getAllRegistration().size() + 1;
			Registration tempRegistration = new Registration(temp, username, password, firstname, lastname, 0);
			registrationService.addRegistration(tempRegistration);
		}
		System.out.println("User account successfully created.");
		System.out.println();
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

	void addJoint(int partnerRegistration) {
		System.out.println("[ CUSTOMER JOINT REGISTRATION ]");
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

		Registration tempRegistration = new Registration(partnerRegistration + 1, username, password, firstname,
				lastname, partnerRegistration);
		registrationService.addRegistration(tempRegistration);
		
		
	}
}
