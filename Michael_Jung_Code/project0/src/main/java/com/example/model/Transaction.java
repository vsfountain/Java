package com.example.model;

public class Transaction {

	int transactionId;
	int accountId;
	int transferAccountId;
	String description;
	
	
	
	
	
	public Transaction(int accountId, int transferAccountId, String description) {
		super();
		this.accountId = accountId;
		this.transferAccountId = transferAccountId;
		this.description = description;
	}
	public Transaction(int accountId, String description) {
		super();
		this.accountId = accountId;
		this.description = description;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getTransferAccountId() {
		return transferAccountId;
	}
	public void setTransferAccountId(int transferAccountId) {
		this.transferAccountId = transferAccountId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
