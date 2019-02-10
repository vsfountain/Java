package com.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//
@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId;
	
	@Column(name="balance")
	private int balance;
	
	@ManyToOne
	@JoinColumn(name="username")
	private Customer primary;
	
	public Account() {}

	public Account(int balance, Customer primary) {
		super();
		this.balance = balance;
		this.primary = primary;
	}

	public Account(int accountId, int balance, Customer primary) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.primary = primary;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Customer getPrimary() {
		return primary;
	}

	public void setPrimary(Customer primary) {
		this.primary = primary;
	}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", primary=" + primary + ", secondary="
				 + "]";
	}

	
}
