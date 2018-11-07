package com.bank.main;

import org.apache.log4j.Logger;

import com.bank.account.service.AccountService;
import com.bank.account.service.AccountServiceImpl;
import com.bank.customer.service.CustomerService;
import com.bank.customer.service.CustomerServiceImpl;
import com.bank.employee.service.EmployeeService;
import com.bank.employee.service.EmployeeServiceImpl;
import com.bank.main.customer.CustomerMainMenu;
import com.bank.main.employee.EmployeeMainMenu;
import com.bank.registration.service.RegistrationService;
import com.bank.registration.service.RegistrationServiceImpl;

public class Main {

	final static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();
		RegistrationService registrationService = new RegistrationServiceImpl();
		AccountService accountService = new AccountServiceImpl();

		registrationService.createRegistrationDB();
		customerService.createCustomerDB();
		accountService.createAccountDB();
		employeeService.createEmployeeDB();
		
		logger.info("Starting up program - Creating Databases. Ignore if DB was already created beforehand.");
		
		chooseAction();
	}

	public Main() {
		chooseAction();
	}

	public static void chooseAction() {
		System.out.println("[ Welcome to the Grand Exchange ]");
		System.out.println("[A] Customer [B] Employee");
		String temp = ScannerSingleton.instance().next().toUpperCase();
		switch (temp) {
		case "A":
			new CustomerMainMenu();
			break;
		case "B":
			new EmployeeMainMenu();
			break;
		default:
			logger.error("User inputed the wrong response.", new Exception());
			System.out.println("Please enter a valid response.");
			chooseAction();
			break;
		}
	}

	public static void exitApplication() {
		System.out.println("[ Exiting program! ]");
		System.exit(0);
	}

}
