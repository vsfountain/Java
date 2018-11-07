package com.bank.account.model;

import java.util.ArrayList;

import com.bank.customer.model.Customer;

public class Account {
	
	private int id;
	private double balance;
	private int mainUserId;
	private int jointUserId;
	public Account(int id, double balance, int mainUserId, int jointUserId) {
		super();
		this.id = id;
		this.balance = balance;
		this.mainUserId = mainUserId;
		this.jointUserId = jointUserId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getMainUserId() {
		return mainUserId;
	}
	public void setMainUserId(int mainUserId) {
		this.mainUserId = mainUserId;
	}
	public int getJointUserId() {
		return jointUserId;
	}
	public void setJointUserId(int jointUserId) {
		this.jointUserId = jointUserId;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", mainUserId=" + mainUserId + ", jointUserId="
				+ jointUserId + "]";
	}
}
