package com.banker.model.users;

public class Admin extends User{
	
	Admin(){
	}

	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Admin(String userName, String password, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
}
