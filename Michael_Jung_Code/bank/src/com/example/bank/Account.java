package com.example.bank;

import java.io.Serializable;

public class Account implements Serializable{

	@Override
	public String toString() {
		return "Account [customerNum=" + customerNum + ", accountNo=" + accountNo + ", isJointAccoun=" + isJointAccoun
				+ ", jointCustomerNo=" + jointCustomerNo + ", amount=" + amount + ", isApproved=" + isApproved
				+ ", isWaitingForApproved=" + isWaitingForApproved + ", isCancelled=" + isCancelled + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1813587169894778060L;
	private int customerNum;
	private int accountNo;
	private boolean isJointAccoun;
	private int jointCustomerNo;
	private double amount;
	private boolean isApproved;
	private boolean isWaitingForApproved;
	private boolean isCancelled;
	
	
	
	
	public Account(int customerNum, int accountNo, boolean isJointAccoun, double amount, boolean isWaitingForApproved) {
		super();
		this.customerNum = customerNum;
		this.accountNo = accountNo;
		this.isJointAccoun = isJointAccoun;
		this.amount = amount;
		this.isWaitingForApproved = isWaitingForApproved;
	}
	public Account(int customerNum, int accountNo, boolean isJointAccoun, int jointCustomerNo, double amount,
			boolean isWaitingForApproved) {
		super();
		this.customerNum = customerNum;
		this.accountNo = accountNo;
		this.isJointAccoun = isJointAccoun;
		this.jointCustomerNo = jointCustomerNo;
		this.amount = amount;
		this.isWaitingForApproved = isWaitingForApproved;
	}
	public int getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public boolean isJointAccoun() {
		return isJointAccoun;
	}
	public void setJointAccoun(boolean isJointAccoun) {
		this.isJointAccoun = isJointAccoun;
	}
	public int getJointCustomerNo() {
		return jointCustomerNo;
	}
	public void setJointCustomerNo(int jointCustomerNo) {
		this.jointCustomerNo = jointCustomerNo;
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
	
	
	
}
