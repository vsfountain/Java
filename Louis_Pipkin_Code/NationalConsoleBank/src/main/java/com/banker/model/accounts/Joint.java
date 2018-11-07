package com.banker.model.accounts;

import java.util.ArrayList;

public class Joint extends Account {

	private ArrayList<String> owners;
	
	Joint(){
	}

	public Joint(int balance) {
		super(balance);
	}
	
	public Joint(int accountid, int balance) {
		super(accountid, balance);
	}
	
	public Joint(int balance, ArrayList<String> owners) {
		super(balance);
		this.owners = owners;
	}
	
	public Joint(int accountid, int balance, ArrayList<String> owners) {
		super(accountid, balance);
		this.owners = owners;
	}

	public String getOwner(int i) {
		return owners.get(i);
	}
	
	public ArrayList<String> getOwners() {
		return owners;
	}

	public void addOwner(String owner) {
		this.owners.add(owner);
	}

	@Override
	public String toString() {
		return "Joint [owners=" + owners + "]";
	}
	
	

}
