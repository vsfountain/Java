package com.simulate.bank.model;

/**
 * This model is to keep track of the information about a light.
 * 
 * @author Kristen Kavanagh
 * @version 10/27/2018
 *
 */

public class Account {
	Customer client;
	 double balance;
	Employee staff;
	Administrator manager;

// set balance to 0.0
	public Account() {
		this.balance = 0.0;
		this.client = new Customer();
		this.staff = new Employee();
		this.manager = new Administrator();
	}

	/**
	 * Customer has own account option
	 * 
	 */
	public void ownAccount() {
		if (this.balance < 2000) {
			System.out.println("Create a ownAccount");
		} else {
			System.out.println("please see options for Joint Account");
		}
	}

	/**
	 * joint account for customer
	 */
	public void jointAccount() {
		if (this.balance >= 2000) {
			System.out.println("Create a Joint Account");
		} else {
			System.out.println(" please see options for own account option");
		}
	}

	/**
	 * account can accept deposits
	 * 
	 * @param amount
	 */

	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}

	/**
	 * checks the account balance prevent negative entry and account overdraft.
	 */
	public double withDraw(double amount) {
		if (this.balance < amount) {
			System.out.println("Insuffienct funds, we are unable to complete your transaction");
		} else {
			this.balance = this.balance - amount;
			System.out.println("Your current balance is\t" + this.getBalance());

		}
		return this.balance;

	}
	public double getBalance() {
		return this.balance;

	}

	/**
	 * Transfer funds to account
	 * 
	 * @param bank
	 * @param amount
	 */
	public void transferTo(Account bank, double amount) {
		if (amount <= balance) {
			Account.this.withDraw(amount);
			bank.deposit(amount);
			System.out.println("\nTransfer succesful. Tansfered: $" + bank.getBalance());
		} else if (amount > balance) {
			System.out.println("\nTransfer failed, insufficient funds!");
		}
	}

	
}
