package com.bankofdikoko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("Account")
@Entity
@Table(name="Accounts")
public class Account {
	
	
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_SEQ")
	@SequenceGenerator(name="ACCOUNT_SEQ", sequenceName="ACCOUNT_SEQ", allocationSize=13)
	private int accountId;
	
	public Account(int balance, User user, User secondaryAccountHolder) {
		super();
		this.balance = balance;
		this.user = user;
		this.secondaryAccountHolder = secondaryAccountHolder;
	}

	@Column(name="Balance")
	private int balance;
	
	@OneToOne
	@JoinColumn(name="accountholder", nullable =false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="secondaryholder")
	private User secondaryAccountHolder;
	
	public Account() {}

	public Account(int accountId, int balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}
	
	public Account(int balance) {
		super();
		this.balance = balance;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getSecondaryAccountHolder() {
		return secondaryAccountHolder;
	}

	public void setSecondaryAccountHolder(User secondaryAccountHolder) {
		this.secondaryAccountHolder = secondaryAccountHolder;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + "]";
	}
	


}
