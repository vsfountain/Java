package com.bank.main.employee;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bank.account.model.Account;
import com.bank.account.service.AccountService;
import com.bank.account.service.AccountServiceImpl;
import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerService;
import com.bank.customer.service.CustomerServiceImpl;
import com.bank.employee.model.Employee;
import com.bank.main.Main;
import com.bank.main.ScannerSingleton;
import com.bank.main.customer.CustomerPortal;
import com.bank.registration.model.Registration;
import com.bank.registration.service.RegistrationService;
import com.bank.registration.service.RegistrationServiceImpl;

public class EmployeePortal {
	
	final static Logger logger = Logger.getLogger(EmployeePortal.class);

	Employee employee;

	RegistrationService registrationService = new RegistrationServiceImpl();
	CustomerService customerService = new CustomerServiceImpl();
	AccountService accountService = new AccountServiceImpl();

	static int a = 1;
	boolean loggedIn = true;

	public EmployeePortal(Employee e) {
		logger.info("Employee Portal was accessed.");
		employee = e;
		while (loggedIn) {
			chooseAction();
		}
	}

	void chooseAction() {
		System.out.println(
				"[A] View Account Information [B] View Account Balances [C] View Personal Information [D] Handle Applications [E] Admin Functions [U] Logout [X] Exit");

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
		case "U":
			System.out.println("[ Logging Out ]");
			loggedIn = false;
			new EmployeeMainMenu();
			break;
		case "X":
			System.out.println("[ Exiting Program ]");
			Main.exitApplication();
			break;
		default:
			chooseAction();
			break;
		}
	}

	private void viewAccountInfo() {
		logger.info("View Account Info was accessed.");
		List<Account> accList = new ArrayList<>();
		accList = accountService.getAllAccounts();
		System.out.println("There are " + accList.size() + " account(s).");
		if (accList.size() != 0) {
			for (Account a : accList) {
				System.out.println("[Account " + a.getId() + "] " + "[Balance: $" + a.getBalance() + "] [Main User ID: "
						+ a.getMainUserId() + "] [Joint User ID: " + a.getJointUserId() + "]");
			}
		}
		System.out.println();
	}

	private void viewAccountBalances() {
		logger.info("View Account Balance was accessed.");
		List<Account> accList = new ArrayList<>();
		accList = accountService.getAllAccounts();
		System.out.println("There are " + accList.size() + " account(s).");
		if (accList.size() != 0) {
			for (Account a : accList) {
				System.out.println("Account " + a.getId() + "'s Balance: [$" + a.getBalance() + "]");
			}
		}
		System.out.println();
	}

	private void viewPersonalInfo() {
		logger.info("View Person Info was accessed.");
		List<Customer> cusList = new ArrayList<>();
		cusList = customerService.getAllCustomers();
		System.out.println("There are " + cusList.size() + " customer(s).");
		if (cusList.size() != 0) {
			for (Customer c : cusList) {
				System.out.println("[Customer " + c.getId() + "] " + "[Username: " + c.getUsername() + "] "
						+ "[First Name: " + c.getFirstName() + "] [Last Name: " + c.getLastName() + "]");
			}
		}
		System.out.println();
	}

	private void handleRegistrations() {
		logger.info("Handling Registration was accessed.");
		List<Registration> registrationList = registrationService.getAllRegistration();
		System.out
				.println("Please [A] Accept or [D] Deny the following " + registrationList.size() + " registrations.");

		for (Registration r : registrationService.getAllRegistration()) {
			while (r != null) {

				System.out.println(r);
				System.out.println("[A] Accept [D] Deny");

				String temp = ScannerSingleton.instance().next().toUpperCase();
				Customer c;
				int tempN = customerService.getAllCustomers().size() + 1;

				switch (temp) {
				case "A":
					logger.info("Registration was accepted.");
					if (r.getJointPartner() == 0) {
						c = new Customer(tempN, r.getUsername(), r.getPassword(), r.getFirstName(), r.getLastName(), 0);
					} else if (r.getJointPartner() != 0 & a == 1) {
						c = new Customer(tempN, r.getUsername(), r.getPassword(), r.getFirstName(), r.getLastName(),
								tempN + 1);
						a++;
					} else {
						c = new Customer(tempN, r.getUsername(), r.getPassword(), r.getFirstName(), r.getLastName(),
								tempN - 1);
						a = 1;
					}

					/*
					 * Customer c = new Customer(0, null, null, null, null, 0); if
					 * (r.getJointPartner() == 1 && joint == 1) { c = new Customer(r.getId(),
					 * r.getUsername(), r.getPassword(), r.getFirstName(), r.getLastName(),
					 * r.getJointPartner()); joint++; break; } else if (r.getJointPartner() == 1 &&
					 * joint == 2) { System.out.println("dont be here"); int person2 =
					 * customerService.getAllCustomers().size() + 1; c = new Customer(person2,
					 * r.getUsername(), r.getPassword(), r.getFirstName(), r.getLastName(), person2
					 * -1); joint = 1; break; } else { c = new Customer(r.getId(), r.getUsername(),
					 * r.getPassword(), r.getFirstName(), r.getLastName(), 0); }
					 */
					registrationService.removeRegistration(r);
					customerService.addCustomer(c);

					if (c.getId() < c.getJointPartner()) {
						Account ac = new Account(accountService.getAllAccounts().size() + 1, 0.0, c.getId(),
								c.getJointPartner());
						accountService.addAccount(ac);
					} else if (c.getJointPartner() == 0) {
						Account ac = new Account(accountService.getAllAccounts().size() + 1, 0.0, c.getId(), 0);
						accountService.addAccount(ac);
					}
					r = null;
					break;
				case "D":
					logger.info("Registration was denied.");
					registrationService.removeRegistration(r);
					r = null;
					break;
				default:
					System.out.println("Please enter a valid response.");
				}
			}

		}
	}

	private void accessAdminFunctions() {
		logger.info("Admin functions was accessed.");
		if (employee.isAdmin()) {
			boolean running = true;
			while (running) {
				System.out.println(
						"[A] Withdrawing [B] Depositing [C] Transfering [D] Canceling Accounts [U] Back [X] Exit");
				String temp = ScannerSingleton.instance().next().toUpperCase();
				switch (temp) {
				case "A":
					adminWithdraw();
					break;
				case "B":
					adminDeposit();
					break;
				case "C":
					adminTransfer();
					break;
				case "D":
					adminCancelAccount();
					break;
				case "U":
					running = false;
					break;
				case "X":
					running = false;
					Main.exitApplication();
					break;
				default:
					accessAdminFunctions();
					break;
				}
			}
		} else {
			logger.warn("An employee tried to access admin functions without being an admin.");
			System.out.println("You do not have permission as an admin!");
		}
	}

	void adminWithdraw() {
		List<Account> accList = accountService.getAllAccounts();
		System.out.println("View account information");
		System.out.println(accList.toString());
		System.out.println("Choose account");
		int temp1 = ScannerSingleton.instance().nextInt();

		System.out.println("Choose amount");
		double tempMoney = ScannerSingleton.instance().nextDouble();
		Account a = accountService.getAccountFromId(temp1);
		a.setBalance(a.getBalance() - tempMoney);
		accountService.updateAccount(a);
		logger.info("Admin withdrew $" + temp1 + " from Account " + a + ".");
	}


	void adminDeposit() {
		List<Account> accList = accountService.getAllAccounts();
		System.out.println("View account information");
		System.out.println(accList.toString());
		System.out.println("Choose account");
		int temp1 = ScannerSingleton.instance().nextInt();

		System.out.println("Choose amount");
		double tempMoney = ScannerSingleton.instance().nextDouble();
		Account a = accountService.getAccountFromId(temp1);
		a.setBalance(a.getBalance() + tempMoney);
		accountService.updateAccount(a);
		logger.info("Admin deposited $" + temp1 + " from Account " + a + ".");
	}

	void adminTransfer() {
		List<Account> accList = accountService.getAllAccounts();
		System.out.println("View account information");
		System.out.println(accList);

		System.out.println("Choose account to transfer from");
		int temp1 = ScannerSingleton.instance().nextInt();

		System.out.println("Choose second account to transfer to");
		int temp2 = ScannerSingleton.instance().nextInt();

		Account a1 = accountService.getAccountFromId(temp1);
		Account a2 = accountService.getAccountFromId(temp2);

		System.out.println("Choose amount");
		double tempMoney = ScannerSingleton.instance().nextDouble();

		a1.setBalance(a1.getBalance() - tempMoney);
		a2.setBalance(a2.getBalance() + tempMoney);

		accountService.updateAccount(a1);
		accountService.updateAccount(a2);
		logger.info("Admin transfered $" + temp1 + " from Account " + a1 + " to Account " + a2 + ".");
	}

	void adminCancelAccount() {
		List<Account> accList = accountService.getAllAccounts();
		System.out.println(accList);
		System.out.println("Choose account id to cancel:");
		int temp1 = ScannerSingleton.instance().nextInt();

		Account a = accountService.getAccountFromId(temp1);
		logger.info("Admin canceled account " + a.getId());
		Customer c1 = customerService.getCustomerFromAccount(a);
		accountService.deleteAccount(a);
		if (c1.getJointPartner() != 0) {
			Customer c2 = customerService.getCustomerFromId(c1.getJointPartner());
			customerService.deleteCustomer(c2);
		}
		customerService.deleteCustomer(c1);
		logger.info("Admin deleted customer(s) associated with the account.");
	}
}
