package com.bank.users;

public class Admin extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5122500926875539292L;

	Admin(){
	}

	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Admin(String userName, String email, String password, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
