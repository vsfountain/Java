package com.example.bank;

import java.io.Serializable;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3484783818244247978L;
	
	
	
	
	@Override
	public String toString() {
		return "Customer [customerNum=" + customerNum + ", userName=" + userName + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public int getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	/*@Override
	public String toString() {
		return "Customer [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}*/
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1606827861902257440L;*/
	/*public Customer(String userName, String password, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}*/
	public Customer(int customerNum, String userName, String password, String firstName, String lastName) {
		super();
		this.customerNum = customerNum;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	private int customerNum;
	private String userName;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String firstName;
	private String lastName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
	
	
}
