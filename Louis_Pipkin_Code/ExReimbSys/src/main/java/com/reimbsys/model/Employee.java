package com.reimbsys.model;

public class Employee extends User {

	//This will act as a marker class for employees more than anything
	
	public Employee() {
		
	}
	
	public Employee(int usersId, String username, String password, String firstName, String lastName, String email,
			int roleId, String role) {
		super(usersId, username, password, firstName, lastName, email, roleId, role);
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String password, String firstName, String lastName, String email, String role) {
		super(username, password, firstName, lastName, email, role);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [usersId=" + usersId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + ", role=" + role
				+ "]";
	}
	
}
