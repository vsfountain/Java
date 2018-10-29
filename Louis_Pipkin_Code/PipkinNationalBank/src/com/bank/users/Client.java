package com.bank.users;

import java.util.ArrayList;
import java.util.Date;

import com.bank.accounts.Account;

public class Client extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9113661315726177704L;

	private String address;
	private String ssn;
	private Date birthDay;
	
	public ArrayList<Account> accounts;
	
}
