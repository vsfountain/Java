package com.ErsReimbursement.model;


/**
 * Model for user role.
 * 
 * @author Kristen Kavanagh
 * @verson 11/14/2017
 *
 */
public class UserRole {
	
	
	private int id;
	
	private String name;
	
	public UserRole() { super(); }

	public UserRole(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	
	
}
