package com.bank.customer.model;

public class Customer {
	
	private int id;
	
	private String username;
	private String password;
	
	private String firstName;
	private String lastName;
	
	private int jointPartner;

	public Customer(int id, String username, String password, String firstName, String lastName, int jointPartner) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jointPartner = jointPartner;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getJointPartner() {
		return jointPartner;
	}

	

	
}
