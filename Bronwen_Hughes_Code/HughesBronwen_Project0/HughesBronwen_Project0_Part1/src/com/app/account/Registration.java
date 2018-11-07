package com.app.account;

import java.io.Serializable;

import com.app.main.ScannerSingleton;

import reorder.CustomerApplication;

public class Registration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2083377282992618626L;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private boolean isJointCustomer;

	public Registration() {
		System.out.println("Enter a username: ");
		username = ScannerSingleton.instance().next();

		setPassword();
		setPersonalInfo();
	}

	private void setPassword() {
		while (true) {
			System.out.println("Enter a password: ");
			String password1 = ScannerSingleton.instance().next();

			System.out.println("Enter your password again: ");
			String password2 = ScannerSingleton.instance().next();

			if (password1.equals(password2)) {
				password = password1;
				break;
			} else {
				System.out.println("Your passwords did not match.");
			}
		}
	}

	private void setPersonalInfo() {
		System.out.println("Enter your first name:");
		firstName = ScannerSingleton.instance().next();

		System.out.println("Enter your last name:");
		lastName = ScannerSingleton.instance().next();

		System.out.println("Enter if you are applying for a joint account (Y/N):");
		while (true) {
			String temp = ScannerSingleton.instance().next();
			if (temp.substring(0, 1).toUpperCase().equals("Y")) {
				isJointCustomer = true;
				System.out.println("true");
				break;
			} else if (temp.substring(0, 1).toUpperCase().equals("N")) {
				isJointCustomer = false;
				System.out.println("false");
				break;
			} else {
				System.out.println("Please enter Y/N: ");
			}
		}

	}

	@Override
	public String toString() {
		return "Registration [username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", isJointCustomer=" + isJointCustomer + "]";
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
		return isJointCustomer;
	}
	

	

}
