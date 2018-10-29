package com.simulate.bank.model;

/**
 * be able to view customers information account balance login information
 * 
 * @author Kristen Kavanagh
 * @version 10/28/2018
 *
 */
public class Employee {
	Account balance;
	Customer client;

	public Employee() {
		this.balance = new Account();
		this.client = new Customer();

	}

	/**
	 * Employees can view account information
	 */
	public String accountInformation() {
		return (client.userName + client.passWord);
	}

	/**
	 * Employees can view balance
	 */
	public double accountBalance() {
		return balance.getBalance();

	}

	/**
	 * Employees views customer's personal information
	 */
	public String personalInformation() {
		return client.name;

	}

	/*
	 * employees approve or deny account open applications for accounts
	 */
	public void openAccount() {
		if (balance.getBalance()> 500) {
			System.out.println("Approved, your account is now open");
		} else {
			System.out.println(" Sorry, we are not able to complete your reques");
		}
	}

}