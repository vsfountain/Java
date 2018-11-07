package com.banker.model.accounts;

public class Personal extends Account {

	private String owner;
	
	Personal() {
		
	}

	public Personal(int balance, String owner) {
		super(balance);
		this.owner = owner;
		//this.accountName = "v";
	}
	
	public Personal(int accountid, int balance, String owner) {
		super(accountid, balance);
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Personal [owner=" + owner + "]";
	}
	
}
