package com.bank.accounts;

import java.io.Serializable;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4945439128260069361L;
	
	boolean approved;
	int balance;

	public Account(){
	}
	
	public Account(boolean approved, int balance) {
		super();
		this.approved = approved;
		this.balance = balance;
	}
	
	public boolean deposit(int amount) {
		if (amount>0) {
			balance += amount;
			return true;
		}else {
			return false;
		}
	}
	
	public int withdrawl(int amount) {
		if (amount > balance) {
			balance -= amount;
			return amount;
		}else {
			return 0;
		}
	}
	
	public boolean transfer(int amount, Account toAccount) {
		return false;
	}
	
	@Override
	public String toString() {
		return "Account [approved=" + approved + ", balance=" + balance + "]";
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
