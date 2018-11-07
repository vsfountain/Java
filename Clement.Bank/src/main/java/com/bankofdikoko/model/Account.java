package com.bankofdikoko.model;

public class Account extends User{
	private int balance;
	private int previousTransaction;
	private String customerName;
	
	public void deposit(int amount) {
		if (amount > 0) {
			balance = balance + amount;
			previousTransaction = amount;
			setBalance(balance);
		} else
			System.out.println("Invalid amount");
	}

	public void withdraw(int amount) {

		if (amount > 0) {
			if ((balance - amount) > 0) {
				balance -= amount;
				previousTransaction = amount;
				System.out.println("You withdrew: $" + amount);
			}else System.out.println("Insufficient funds");
		} else
			System.out.println("Invalid amount");
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPreviousTransaction() {
		return previousTransaction;
	}
	public void setPreviousTransaction(int previousTransaction) {
		this.previousTransaction = previousTransaction;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", previousTransaction=" + previousTransaction + "]";
	}
	public static void apply() {
		
	
		
	}
	

}
