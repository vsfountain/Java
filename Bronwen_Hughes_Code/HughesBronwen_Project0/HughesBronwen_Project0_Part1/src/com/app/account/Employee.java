package com.app.account;

import java.io.Serializable;

import reorder.CustomerApplication;

public class Employee implements IUser, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 173828278017409015L;
	private String username;
	private String password;

	private String firstName;
	private String lastName;

	private boolean admin;


	public Employee(String username, String password, String firstName, String lastName, boolean admin) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
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


	@Override
	public void viewApplication() {
		// TODO Auto-generated method stub

	}

	public void handleOpenApplications(CustomerApplication application) {

	}

	public void viewAccountBalance(Account account) {

	}

	public void viewPersonalInfo(Account account) {
		// full name, dob, address, balance
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", admin=" + admin + "]";
	}
	
	


}
