package com.classes;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

public class Reimbursement implements Serializable{
	private static final long serialVersionUID = -8883421641006927656L;
	final static Logger logger = Logger.getLogger(Reimbursement.class);
	private int reimb_id;
	private double reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	private String reimb_author;
	private int reimb_resolver;
	private String reimb_status;
	private String reimb_type;
	private Blob reimb_receipt;
	
	public Reimbursement(int reimb_id, double reimb_amount, Timestamp reimb_submitted, Timestamp tempResDate,
			String reimb_description, String reimb_author, int reimb_resolver, String reimb_status,
			String reimb_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = tempResDate;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
		this.setReimb_receipt(null);
	}
	
	
	public Reimbursement(int reimb_id, double reimb_amount, Timestamp reimb_submitted, Timestamp tempResDate,
			String reimb_description, String reimb_author, int reimb_resolver, String reimb_status,
			String reimb_type, Blob receipt) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = tempResDate;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
		this.reimb_receipt = receipt;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_submitted() {
		return ""+reimb_submitted;
	}

	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public String getReimb_resolved() {
		return ""+reimb_resolved;
	}

	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public String getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(String reimb_author) {
		this.reimb_author = reimb_author;
	}

	public int getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	public Blob getReimb_receipt() {
		return reimb_receipt;
	}

	public void setReimb_receipt(Blob reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}
	
	@Override
	public String toString() {
		return "\n\tReimbursement [ID=" + reimb_id + ", Amount=" + reimb_amount + ", dateSubmitted="
				+ reimb_submitted + ", dateResolved=" + reimb_resolved + ", Description=" + reimb_description
				+ ", Author=" + reimb_author + ", Resolver=" + reimb_resolver + ", Status="
				+ reimb_status + ", Type=" + reimb_type + "]";
	}
}
