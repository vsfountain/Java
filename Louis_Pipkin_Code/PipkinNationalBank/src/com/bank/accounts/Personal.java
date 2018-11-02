package com.bank.accounts;

import com.bank.users.Client;

public class Personal extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6242322963130884421L;
	
	public Client owner; 

	Personal(){
	
	}

	public Personal(Client owner, boolean approved, int balance) {
		super();
		this.owner = owner;
		this.approved = approved;
		this.balance = balance;
		this.accountName = owner.getUserName();
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Personal [owner=" + owner + ", approved=" + approved + ", balance=" + balance + ", accountName="
				+ accountName + "]";
	}
	
}
