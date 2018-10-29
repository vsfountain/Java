package com.app.account;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7571605448451250235L;

	private static AccountList instance;

	public ArrayList<Account> accountList = new ArrayList<>();

	public void addAccount(Account account) {
		accountList.add(account);
		System.out.println(accountList.toString());
		
	}

	private AccountList() {

	}

	public static AccountList getInstance() {
		if (instance == null) {
			instance = new AccountList();
		}
		return instance;
	}

	@Override
	public String toString() {
		return "AccountList [accountList=" + accountList + "]";
	}
	
}
