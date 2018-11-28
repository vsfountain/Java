package com.reimbsys.model;

public class Admin extends User {

	//This will act as a marker class for admins more than anything
	
	public Admin() {
		
	}
	
	public Admin(String username, String password, String firstName, 
			String lastName, String email, String role) {
		super(username, password, firstName, lastName, email, role);
		// log4j
	}
	
	public Admin(int usersId, String username, String password, String firstName, String lastName, String email,
			int roleId, String role) {
		super(usersId, username, password, firstName, lastName, email, roleId, role);
		// log4j?
	}

	@Override
	public String toString() {
		return "Admin [usersId=" + usersId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + ", role=" + role
				+ "]";
	}

}
