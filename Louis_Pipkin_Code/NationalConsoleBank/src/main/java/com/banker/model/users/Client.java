package com.banker.model.users;

public class Client extends User {
	
	Client(){
	}

	public Client(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Client(String userName, String password, String firstName, 
					String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Client [userName=" + userName + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
	
}
