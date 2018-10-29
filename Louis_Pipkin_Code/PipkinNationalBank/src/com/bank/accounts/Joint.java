package com.bank.accounts;

import java.util.ArrayList;

import com.bank.users.Client;

public class Joint extends Account{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2328880142745761291L;

	public ArrayList<Client> owners;

	Joint(){
	}
	
	public Joint(ArrayList<Client> owners) {
		super();
		this.owners = owners;
	}

	public ArrayList<Client> getOwners() {
		return owners;
	}

	public void setOwners(ArrayList<Client> owners) {
		this.owners = owners;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Joint [owners=" + owners + "]";
	} 
	
}
