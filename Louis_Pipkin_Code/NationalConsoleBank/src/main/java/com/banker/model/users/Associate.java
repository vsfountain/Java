package com.banker.model.users;

public class Associate extends User{
	
	Associate(){
	}
	
	public Associate(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Associate(String userName, String password, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Associate [userName=" + userName + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
	
}
