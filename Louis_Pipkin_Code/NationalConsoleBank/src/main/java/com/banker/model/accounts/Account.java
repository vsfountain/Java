package com.banker.model.accounts;

public class Account {

	private int accountid;
	private int balance;
	private boolean approved;
	private String accountName;
	
	public Account(){
	}
	
	public Account(int balance) {
		super();
		this.balance = balance;
	}
	
	public Account(int accountid, int balance) {
		super();
		this.accountid = accountid;
		this.balance = balance;
	}
	
	public Account(int accountid, int balance, String accountName) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.accountName = accountName;
	}

	public boolean deposit(int amount) {
		if (amount>0) {
			balance += amount;
			return true;
		}else {
			return false;
		}
	}
	
	public int withdrawal(int amount) {
		if (amount < balance && amount >= 0) {
			balance -= amount;
			return amount;
		}else {
			return 0;
		}
	}
	
	public boolean transfer(int amount, Account toAccount) {
		if (amount < balance && amount > 0) {
			balance -= amount;
			toAccount.deposit(amount);
			return true;
		}else {
			return false;
		}
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", balance=" + balance + ", approved=" + approved + ", accountName="
				+ accountName + "]";
	}

	
}

