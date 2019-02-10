package com.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId;
	
	@Column(name ="username")
	private String userName;
	
	@Column(name="Password")
	private String userPassword;
	
	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;
	
	public Customer() {
		
	}
	
	public Customer( String userName, String userPassword, String firstName, String lastName,
			String email) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Customer(int accountId, String userName, String userPassword, String firstName, String lastName,
			String email) {
		super();
		this.accountId = accountId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [accountId=" + accountId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	@Column(name ="email")
	private String email;
	
	
}
