package com.example.bank;

import java.io.Serializable;

public class Employee implements Serializable{
	
	
	
	
	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -9186162124287725728L;
	public Employee(String username, String password, boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	private String username;
	private String password;
	private boolean isAdmin;
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
