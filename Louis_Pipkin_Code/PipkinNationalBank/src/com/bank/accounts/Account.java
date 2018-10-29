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
	
	public boolean deposit(int amount) {
		return false;
	}
	
	public boolean withdrawl(int amount) {
		return false;
	}
	
	public boolean transfer(int amount, Account toAccount) {
		return false;
	}
	
}
