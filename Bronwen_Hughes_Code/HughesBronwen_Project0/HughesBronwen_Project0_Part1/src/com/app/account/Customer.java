package com.app.account;

import java.io.Serializable;

// customers have a bank account
// joint account - one bank acct - two owners

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5394705306836271709L;
	private String username;
	private String password;

	private String firstName;
	private String lastName;

	private boolean jointCustomer;

	public Customer(String username, String password, String firstName, String lastName, boolean jointCustomer) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jointCustomer = jointCustomer;
	}

	// can apply to open an account
	public void openAccount(String username, String password, boolean jointAccount) {
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean isJointCustomer() {
		return jointCustomer;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setJointCustomer(boolean jointCustomer) {
		this.jointCustomer = jointCustomer;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", jointCustomer=" + jointCustomer + "]\n";
	}

}
