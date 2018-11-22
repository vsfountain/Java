package com.ErsReimbursement.model;

/**
 * Model for reimbursement type.
 *
 * @author Kristen Kavanagh
 * @version 11/15/2018
 *
 */
public class ReimbursementType {
		
	
	private int id;

	private String name;
	
	public ReimbursementType() { super(); }
	
	public ReimbursementType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() { return id; }
	public void setId(int id) {	this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}

	
	
