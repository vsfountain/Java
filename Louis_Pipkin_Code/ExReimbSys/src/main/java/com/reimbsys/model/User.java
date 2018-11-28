package com.reimbsys.model;

public class User {
	/*
	 * All fields and functionality will be defined in parent class
	 * Children will function as marker classes
	 */	
	
	protected int usersId;
	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected int roleId;
	protected String role;
	
	public User(){
		
	}
	
	public User(String username, String password){
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String firstName, String lastName){
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String username, String password, String firstName, 
				String lastName, String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	public User(int usersId, String username, String password, String firstName, 
				String lastName, String email, int roleId, String role) {
		super();
		this.usersId = usersId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
		this.role = role;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [usersId=" + usersId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + ", role=" + role
				+ "]";
	}
	
}
