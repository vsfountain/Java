package com.app.account;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

// customers HAVE A bank account

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6749420445233467828L;
	private double balance;
	private ArrayList<Customer> customers;

	public Account(double balance, ArrayList<Customer> customers) {
		super();
		this.balance = balance;
		this.customers = customers;
	}

	public void addCustomers(Customer customer) {
		customers.add(customer);
	}

	public double getBalance() {
		return balance;
	}
	
	public String printBalance() {
		DecimalFormat df = new DecimalFormat("###.##");
		return df.format(balance);
	}

	public boolean setBalance(double balance) {
		if (balance >= 0) {
			this.balance = balance;
			return true;
		} else {
			System.out.println("youre trying to set a negative balance");
			return false;
		}
	}

	public boolean withdraw(double balance) {
		if (this.balance - balance >= 0) {
			DecimalFormat df = new DecimalFormat("###.##");
			this.balance -= balance;
			System.out.println("Your balance is now: " + df.format(this.balance));
			return true;
		} else {
			System.out.println("youre trying to overdraw!");
			return false;
		}
	}

	public void deposit(double balance) {
		setBalance(this.balance + balance);
		System.out.println("Your balance is now: " + printBalance());
	}

	public boolean transfer(Account account, double balance, boolean transferToOther) {
		// transfer money
		if (transferToOther) {
				setBalance(getBalance() - balance);
			if (account.setBalance(account.getBalance() + balance)) {
				System.out.println("Your balance is now: " + printBalance());
				System.out.println("Your friends balance is " + account.printBalance());
				return true;
			} else {
				return false;
			}
		} else {
			account.setBalance(this.getBalance() + account.getBalance());
			if (this.setBalance(this.getBalance() - account.getBalance())) {
				System.out.println("Your balance is now: " + printBalance());
				return true;
			} else {
				return false;
			}
		}
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

}
