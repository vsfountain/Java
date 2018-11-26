package com.kers.models;

import java.sql.Blob;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Reimbursement {
	private int id;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private Blob receipt;
	private byte[] receiptByteArray;
	private String author;
	private String resolver;
	private String status;
	private String type;

	// testing constructor
	// constructor for making reimbursement
		public Reimbursement(double amount, String description, String author, String type) {
			super();
			this.amount = amount;
			this.description = description;
			this.author = author;
			this.type = type;
		}
	
	// constructor for making reimbursement
	public Reimbursement(double amount, String description, byte[] receiptByteArray , String author, String type) {
		super();
		this.amount = amount;
		this.description = description;
		this.receiptByteArray = receiptByteArray;
		this.author = author;
		this.type = type;
	}

	// constructor for retrieving reimbursement that is pending
	public Reimbursement(int id, double amount, Timestamp submitted, String description, byte[] receiptByteArray, String author,
			String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.receiptByteArray = receiptByteArray;
		this.author = author;
		this.status = status;
		this.type = type;
	}
	
	// constructor for retrieving reimbursement for completed transactions
	public Reimbursement(int id, double amount, Timestamp submitted, Timestamp resolved, String description, byte[] receiptByteArray,
			String author, String resolver, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receiptByteArray = receiptByteArray;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}

	public String getAmount() {
		return "$"+String.format( "%.2f", amount );
	}

	public double getAmountDouble() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return "" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(submitted);
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		if (resolved != null) {
			return "" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(resolved);
		} else {
			return null;
		}
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	public byte[] getReceiptByteArray() {
		return receiptByteArray;
	}

	public void setReceiptByteArray(byte[] receiptByteArray) {
		this.receiptByteArray = receiptByteArray;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", receiptByteArray=" + receiptByteArray + ", author=" + author + ", resolver="
				+ resolver + ", status=" + status + ", type=" + type + "]";
	}

	

}
