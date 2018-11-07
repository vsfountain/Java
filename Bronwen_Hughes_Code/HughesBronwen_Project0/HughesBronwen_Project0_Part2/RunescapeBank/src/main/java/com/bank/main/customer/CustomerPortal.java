package com.bank.main.customer;

import java.util.List;

import org.apache.log4j.Logger;

import com.bank.account.model.Account;
import com.bank.account.service.AccountService;
import com.bank.account.service.AccountServiceImpl;
import com.bank.customer.model.Customer;
import com.bank.main.ScannerSingleton;

public class CustomerPortal {
	
	final static Logger logger = Logger.getLogger(CustomerPortal.class);

	private Customer customer;
	private Account account;
	boolean loggedIn = true;

	AccountService accountService = new AccountServiceImpl();

	public CustomerPortal(Customer c) {
		
		logger.info("Customer Portal was accessed.");
		customer = c;
		account = accountService.getAccountFromCustomerId(c.getId());
		while (loggedIn) {
			chooseAction();
		}
	}

	void chooseAction() {
		System.out.println("[A] Withdraw [B] Deposit [C] Transfer [U] Back [X] Exit");

		String temp = ScannerSingleton.instance().next().toUpperCase();

		switch (temp) {
		case "A":
			System.out.println("[ Withdrawing from " + customer.getUsername() + "'s Account ]");
			withdraw();
			break;
		case "B":
			System.out.println("[ Viewing Account Balances ]");
			deposit();
			break;
		case "C":
			System.out.println("[ Viewing Personal Information ]");
			transfer();
			break;
		case "U":
			System.out.println("[ Logging Out ]");
			loggedIn = false;
			new CustomerMainMenu();
			break;
		case "X":
			System.out.println("[ Handling Customer Registrations ]");
			break;
		default:
			chooseAction();
			break;
		}
	}

	void withdraw() {
		System.out.println("Your account currently has $" + account.getBalance() + ".");
		System.out.print("Please enter how much you'd like to withdraw: ");
		double temp = ScannerSingleton.instance().nextDouble();
		if (account.getBalance() - temp < 0) {
			System.out.println("You cannot withdraw more than you own!");
			withdraw();
		} else {
			account.setBalance(account.getBalance() - temp);
			accountService.updateAccount(account);
			logger.info("Account " + account.getId() + " withdrew $" + temp + ".");
		}
	}

	void deposit() {
		System.out.println("Your account currently has $" + account.getBalance() + ".");
		System.out.print("Please enter how much you'd like to deposit: ");
		double temp = ScannerSingleton.instance().nextDouble();
		account.setBalance(account.getBalance() + temp);
		accountService.updateAccount(account);
		logger.info("Account " + account.getId() + " deposit $" + temp + ".");
	}

	void transfer() {
		System.out.println("Your account currently has $" + account.getBalance() + ".");

		List<Account> accList = accountService.getAllAccounts();
		for (Account a : accList) {
			System.out.println("[Account " + a.getId() + "] " + "[Balance: $" + a.getBalance() + "]");
		}

		System.out.print("Please enter the account ID you'd like to withdraw from: ");
		int temp1 = ScannerSingleton.instance().nextInt();

		Account otherAccount = accountService.getAccountFromId(temp1);
		System.out.print("Please enter the amount you'd like to transfer to Account " + temp1 + ": ");
		double temp2 = ScannerSingleton.instance().nextDouble();

		if(account.getBalance() - temp2 < 0) {
			System.out.println("You cannot withdraw more than you own!");
			transfer();
		}
		
		account.setBalance(account.getBalance() - temp2);
		otherAccount.setBalance(otherAccount.getBalance() + temp2);

		accountService.updateAccount(account);
		accountService.updateAccount(otherAccount);
		logger.info("Account " + account.getId() + " transfered $" + temp2 + " to Account " + otherAccount.getId() + ".");
	}

}
