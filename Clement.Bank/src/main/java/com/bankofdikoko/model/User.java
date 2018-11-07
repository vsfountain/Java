package com.bankofdikoko.model;

public class User  {

	/**
	 * 
	 */
	private String userName;
	private String password;
	private String emailAddress;
	private String firstName;
	private String lastName;

	public User() {
		// TODO Auto-generated constructor stub
		userName = "";
		password = "";
		emailAddress = "";

	}

	public String login(String user, String pass) {
		return user + pass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", emailAddress=" + emailAddress
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
