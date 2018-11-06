package com.bank.main.employee;

import java.util.List;

import com.bank.account.model.Account;
import com.bank.account.service.AccountService;
import com.bank.account.service.AccountServiceImpl;
import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerService;
import com.bank.customer.service.CustomerServiceImpl;
import com.bank.main.ScannerSingleton;
import com.bank.registration.model.Registration;
import com.bank.registration.service.RegistrationService;
import com.bank.registration.service.RegistrationServiceImpl;

public class EmployeePortal {
	
	RegistrationService registrationService = new RegistrationServiceImpl();
	CustomerService customerService = new CustomerServiceImpl();
	AccountService accountService = new AccountServiceImpl();
	
	public EmployeePortal() {
		chooseAction();
	}

	void chooseAction() {
		System.out.println(
				"[A] View Account Information [B] View Account Balances [C] View Personal Information [D] Handle Applications [E] Admin Functions [U] Back [X] Exit");

		String temp = ScannerSingleton.instance().next().toUpperCase();

		switch (temp) {
		case "A":
			System.out.println("[ Viewing Account Information ]");
			viewAccountInfo();
			break;
		case "B":
			System.out.println("[ Viewing Account Balances ]");
			viewAccountBalances();
			break;
		case "C":
			System.out.println("[ Viewing Personal Information ]");
			viewPersonalInfo();
			break;
		case "D":
			System.out.println("[ Handling Customer Registrations ]");
			handleRegistrations();
			break;
		case "E":
			System.out.println("[ Accessing Admin Functions ]");
			accessAdminFunctions();
			break;
		default:
			chooseAction();
			break;
		}
	}

	private void viewAccountInfo() {
		// TODO Auto-generated method stub
		
	}

	private void viewAccountBalances() {
		// TODO Auto-generated method stub
		
	}

	private void viewPersonalInfo() {
		// TODO Auto-generated method stub
		
	}

	private void handleRegistrations() {
		List<Registration> registrationList = registrationService.getAllRegistration();
		System.out.println("Please [A] Accept or [D] Deny the following " + registrationList.size() + " registrations.");
		
		for(Registration r:registrationService.getAllRegistration()) {
			while (r != null) {
				System.out.println(r);
				System.out.println("[A] Accept [D] Deny");
				
				String temp = ScannerSingleton.instance().next().toUpperCase();

				switch (temp) {
				case "A":
					System.out.println("im here");
					
					Customer c = new Customer(customerService.getAllCustomers().size() + 1, r.getUsername(), r.getPassword(), r.getFirstName(), r.getLastName(), r.isJointCustomer());
					registrationService.removeRegistration(r);
					customerService.addCustomer(c);
					
					Account a = new Account(accountService.getAllAccounts().size() + 1, 0.0, c.getId(), 0);
					accountService.addAccount(a);
					r = null;
					break;
				case "D":
					System.out.println("im here too");
					registrationService.removeRegistration(r);
					r = null;
					break;
				default:
					System.out.println("Please enter a valid response.");
				}
			}
			
		}
		//System.out.println(registrationList);
	}
	


	private void accessAdminFunctions() {
		// TODO Auto-generated method stub
		
	}
}
