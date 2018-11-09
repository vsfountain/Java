package com.example.model;

public class Employee {
	
	int employeeId;
	String username;
	String password;
	boolean isAdmin;
	
	
	
	
	
	public Employee(int employeeId, String username, String password, boolean isAdmin) {
		super();
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
