package com.bank.main.customer;

import com.bank.account.model.Account;
import com.bank.account.service.AccountService;
import com.bank.account.service.AccountServiceImpl;
import com.bank.customer.model.Customer;
import com.bank.main.ScannerSingleton;

public class CustomerPortal {
	
	private Customer customer;
	private Account account;
	
	AccountService accountService = new AccountServiceImpl();
	
	public CustomerPortal(Customer c) {
		customer = c;
		account = accountService.getAccountFromCustomerId(c.getId());
		chooseAction();
	}
	
	void chooseAction() {
		System.out.println(
				"[A] Withdraw [B] Deposit [C] Transfer [D] Add Joint User [X] Exit");

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
		case "D":
			addJoint();
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
		System.out.println("Your account currently has ");
	}
	
	void deposit() {
		
	}
	
	void transfer() {
		
	}
	
	void addJoint() {
		
	}
}
