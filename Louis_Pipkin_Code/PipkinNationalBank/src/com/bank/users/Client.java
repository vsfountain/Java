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
	
	Client(){
		
	}

	public Client(String address, String ssn, Date birthDay, ArrayList<Account> accounts) {
		super();
		this.address = address;
		this.ssn = ssn;
		this.birthDay = birthDay;
		this.accounts = accounts;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Client [address=" + address + ", ssn=" + ssn + ", birthDay=" + birthDay + ", accounts=" + accounts
				+ "]";
	}
	
	
}
