package com.bank.accounts;

import com.bank.users.Client;

public class Joint extends Account{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2328880142745761291L;

	//public ArrayList<Client> owners;
	public Client owner1;
	public Client owner2;
	
	Joint(){
	}
	
	public Joint(Client owner1, Client owner2) {
		super();
		this.owner1 = owner1;
		this.owner2 = owner2;
	}

	public Joint(Client owner1, Client owner2, boolean approved, int balance) {
		super();
		this.owner1 = owner1;
		this.owner2 = owner2;
		this.approved = approved;
		this.balance = balance;
		this.accountName = owner1.getUserName() + "|" + owner2.getUserName();
	}
	
	public Client getOwner1() {
		return owner1;
	}

	public void setOwner1(Client owner1) {
		this.owner1 = owner1;
	}

	public Client getOwner2() {
		return owner2;
	}

	public void setOwner2(Client owner2) {
		this.owner2 = owner2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Joint [owner1=" + owner1 + ", owner2=" + owner2 + ", approved=" + approved + ", balance=" + balance
				+ ", accountName=" + accountName + "]";
	}
	
}
