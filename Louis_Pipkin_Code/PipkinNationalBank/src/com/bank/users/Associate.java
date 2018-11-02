package com.bank.users;

public class Associate extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5269372106481632744L;

	Associate(){
	}
	
	public Associate(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Associate(String userName, String email, String password, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Associate [userName=" + userName + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}


	
}
