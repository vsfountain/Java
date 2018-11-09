package com.example.model;

public class Account {

	int accountNumber;
	int customerNumber;
	boolean isJointAccount;
	int jointCustomerNumber;
	double amount;
	boolean isApproved;
	boolean isWaitingForApproved;
	boolean isCancelled;
	
	
	public Account(int accountNumber, int customerNumber, boolean isJointAccount, int jointCustomerNumber,
			double amount, boolean isApproved, boolean isWaitingForApproved, boolean isCancelled) {
		super();
		this.accountNumber = accountNumber;
		this.customerNumber = customerNumber;
		this.isJointAccount = isJointAccount;
		this.jointCustomerNumber = jointCustomerNumber;
		this.amount = amount;
		this.isApproved = isApproved;
		this.isWaitingForApproved = isWaitingForApproved;
		this.isCancelled = isCancelled;
	}


	


	public Account(int customerNumber, boolean isJointAccount, int jointCustomerNumber, double amount,
			boolean isWaitingForApproved) {
		super();
		this.customerNumber = customerNumber;
		this.isJointAccount = isJointAccount;
		this.jointCustomerNumber = jointCustomerNumber;
		this.amount = amount;
		this.isWaitingForApproved = isWaitingForApproved;
	}





	public Account(int accountNumber, int customerNumber, boolean isJointAccount, double amount, boolean isApproved,
			boolean isWaitingForApproved, boolean isCancelled) {
		super();
		this.accountNumber = accountNumber;
		this.customerNumber = customerNumber;
		this.isJointAccount = isJointAccount;
		this.amount = amount;
		this.isApproved = isApproved;
		this.isWaitingForApproved = isWaitingForApproved;
		this.isCancelled = isCancelled;
	}





	public Account(int customerNumber, double amount, boolean isWaitingForApproved) {
		super();
		this.customerNumber = customerNumber;
		this.amount = amount;
		this.isWaitingForApproved = isWaitingForApproved;
	}





	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}


	public boolean isJointAccount() {
		return isJointAccount;
	}


	public void setJointAccount(boolean isJointAccount) {
		this.isJointAccount = isJointAccount;
	}


	public int getJointCustomerNumber() {
		return jointCustomerNumber;
	}


	public void setJointCustomerNumber(int jointCustomerNumber) {
		this.jointCustomerNumber = jointCustomerNumber;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public boolean isApproved() {
		return isApproved;
	}


	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}


	public boolean isWaitingForApproved() {
		return isWaitingForApproved;
	}


	public void setWaitingForApproved(boolean isWaitingForApproved) {
		this.isWaitingForApproved = isWaitingForApproved;
	}


	public boolean isCancelled() {
		return isCancelled;
	}


	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	
	
	public void deposit(double deposit) {
		this.amount = this.amount + deposit;
	}
	
	public void withdraw(double withdrawal) {
		this.amount = this.amount - withdrawal;
	}
	
	
	


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerNumber=" + customerNumber + ", isJointAccount="
				+ isJointAccount + ", jointCustomerNumber=" + jointCustomerNumber + ", amount=" + amount
				+ ", isApproved=" + isApproved + ", isWaitingForApproved=" + isWaitingForApproved + ", isCancelled="
				+ isCancelled + "]";
	}
	
	
	
	
	
}
