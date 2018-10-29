package com.app.company;

import java.util.ArrayList;

import com.app.account.Account;
import com.app.account.AccountList;
import com.app.account.Customer;
import com.app.account.CustomerList;
import com.app.account.Employee;
import com.app.account.Registration;
import com.app.account.RegistrationList;
import com.app.main.Main;
import com.app.main.ScannerSingleton;

public class CompanyView {
	// employees - see, approve, deny any applications
	// bank admins - view and edit all accounts
	// approving, denying accounts
	// withdrawing, depositing, transfering from all accounts
	// canceling accounts

	private Employee employee;
	private ArrayList<Registration> tempRegistration;
	private boolean running;
	
	
	public CompanyView() {
		tempRegistration = new ArrayList<Registration>(RegistrationList.getInstance().registrationList);
		System.out.println("You have " + RegistrationList.getInstance().registrationList.size()
				+ " application(s) needing to be approved/denied.");

		running = true;
		
		while (running) {
			handleSwitch();
		}

	}

	void handleSwitch() {
		System.out.println(
				"Type: [A] View Account Information, [B] View Account Balances, [C] View Personal Information, [D] Handle Applications, [E] Admin Functions [U] Back [X] Exit");
		String temp = ScannerSingleton.instance().next().toUpperCase();
		switch (temp) {
		case "A":
			System.out.println("View account information");
			viewAccountInfo();
			break;
		case "B":
			System.out.println("View Account balances");
			viewAccountBalances();
			break;
		case "C":
			System.out.println("View personal information");
			viewPersonalInformation();
			break;
		case "D":
			handleApplications();
			break;
		case "E":
			accessAdminFunctions();
			break;
		case "U":
			Main.start();
			break;
		case "X":
			running = false;
			Main.exitApplication();
			break;
		default:
			handleSwitch();
		}
	}

	void viewAccountInfo() {
		System.out.println(AccountList.getInstance().accountList);
		/*
		 * for(Customer c: CustomerList.getInstance().customerList) {
		 * System.out.println(c); }
		 */
	}

	void viewAccountBalances() {
		for (Account c : AccountList.getInstance().accountList) {
			System.out.println(c.getBalance());
		}
	}

	void viewPersonalInformation() {
		System.out.println(CustomerList.getInstance().customerList);
	}

	void handleApplications() {
		System.out.println("Please type A to accept or D to deny.");

		for (Registration r : tempRegistration) {
			System.out.println(r + " (A / D)");

			while (true) {

				String temp = ScannerSingleton.instance().next().toUpperCase();
				if (temp.equals("A")) {
					Customer customer = new Customer(r.getUsername(), r.getPassword(), r.getFirstName(),
							r.getLastName(), r.isJointCustomer());
					CustomerList.getInstance().addCustomer(customer);
					RegistrationList.getInstance().registrationList.remove(r);
					Account account = new Account(0.0f, new ArrayList<Customer>());
					account.addCustomers(customer);
					AccountList.getInstance().addAccount(account);
					System.out.println("Added.");
					break;
				} else if (temp.equals("D")) {
					RegistrationList.getInstance().registrationList.remove(r);
					break;
				} else {
					System.out.println("Invalid - Please input A or D.");
				}
			}
		}
	}
	
	void accessAdminFunctions() {
		if(employee.isAdmin()) {
			chooseAdminFunctions();
		}
	}
	
	void chooseAdminFunctions() {
		System.out.println(
				"Type: [A] Withdrawing, [B] Depositing, [C] Transfering, [D] Canceling Accounts, [U] Back [X] Exit");
		String temp = ScannerSingleton.instance().next().toUpperCase();
		switch (temp) {
		case "A":
			System.out.println("View account information");
			System.out.println(AccountList.getInstance().toString());
			System.out.println("Choose account");
			int temp2 = ScannerSingleton.instance().nextInt() - 1;
			
			System.out.println("Choose amount");
			double tempMoney = ScannerSingleton.instance().nextDouble();
			AccountList.getInstance().accountList.get(temp2).withdraw(tempMoney);
			break;
		case "B":
			System.out.println("View Account balances");
			System.out.println("View account information");
			System.out.println(AccountList.getInstance().toString());
			System.out.println("Choose account");
			temp2 = ScannerSingleton.instance().nextInt() - 1;
			
			System.out.println("Choose amount");
			tempMoney = ScannerSingleton.instance().nextDouble();
			AccountList.getInstance().accountList.get(temp2).deposit(tempMoney);
			break;
		case "C":
			System.out.println("View Account balances");
			System.out.println("View account information");
			System.out.println(AccountList.getInstance().toString());
			System.out.println("Choose two accounts account");
			temp2 = ScannerSingleton.instance().nextInt() - 1;
			int temp3 = ScannerSingleton.instance().nextInt() -1;
			
			System.out.println("Choose amount");
			tempMoney = ScannerSingleton.instance().nextDouble();
			AccountList.getInstance().accountList.get(temp2).transfer(AccountList.getInstance().accountList.get(temp3), tempMoney, true);
			break;
		case "D":
			System.out.println("View account information");
			System.out.println(AccountList.getInstance().toString());
			System.out.println("Choose one account");
			temp2 = ScannerSingleton.instance().nextInt() - 1;
			AccountList.getInstance().accountList.remove(temp);
			break;
		case "U":
			chooseAdminFunctions();
			break;
		case "X":
			running = false;
			Main.exitApplication();
			break;
		default:
			handleSwitch();
		}
	}
}
