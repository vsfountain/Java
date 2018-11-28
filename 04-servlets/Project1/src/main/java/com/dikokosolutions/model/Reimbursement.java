package com.dikokosolutions.model;

import java.sql.Date;

public class Reimbursement {
	private int reim_id, reim_amount, reim_author, reim_resolver, reim_status, reim_type_id;
	private String reim_description = " ";
	private Date reim_submitted, reim_resolved;
	private String Reim_author_name;

	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reimbursement [reim_id=" + reim_id + ", reim_amount=" + reim_amount + ", reim_author=" + reim_author
				+ ", reim_resolver=" + reim_resolver + ", reim_status=" + reim_status + ", reim_type_id=" + reim_type_id
				+ ", reim_description=" + reim_description + ", reim_submitted=" + reim_submitted + ", reim_resolved="
				+ reim_resolved + "]";
	}

	public int getReim_id() {
		return reim_id;
	}

	public void setReim_id(int reim_id) {
		this.reim_id = reim_id;
	}

	public int getReim_amount() {
		return reim_amount;
	}

	public void setReim_amount(int reim_amount) {
		this.reim_amount = reim_amount;
	}

	public int getReim_author() {
		return reim_author;
	}

	public void setReim_author(int reim_author) {
		this.reim_author = reim_author;
	}

	public int getReim_resolver() {
		return reim_resolver;
	}

	public void setReim_resolver(int reim_resolver) {
		this.reim_resolver = reim_resolver;
	}

	public int getReim_status() {
		return reim_status;
	}

	public void setReim_status(int reim_status) {
		this.reim_status = reim_status;
	}

	public int getReim_type_id() {
		return reim_type_id;
	}

	public void setReim_type_id(int reim_type_id) {
		this.reim_type_id = reim_type_id;
	}

	public String getReim_description() {
		return reim_description;
	}

	public void setReim_description(String reim_description) {
		this.reim_description = reim_description;
	}

	public Date getReim_submitted() {
		return reim_submitted;
	}

	public void setReim_submitted(Date reim_submitted) {
		this.reim_submitted = reim_submitted;
	}

	public Date getReim_resolved() {
		return reim_resolved;
	}

	public void setReim_resolved(Date reim_resolved) {
		this.reim_resolved = reim_resolved;
	}

	public void setReim_author_name(String string) {
		// TODO Auto-generated method stub
		this.Reim_author_name = string;
	}

}
