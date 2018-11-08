package com.profiles;
import java.time.Instant;

import com.service.BankService;
import com.service.BankServiceImplementation;

//Author: Sean Doyle
//Date Created: 2018/10/24

//This class stores information about the transaction

public final class Transaction {
	private static int transactionCount;
	private double amount;
	private int clientNum = -1;
	private int accountNum;
	private String transDesc;
	private Instant date;
	private int transactionID;
	private BankService bserv = new BankServiceImplementation();
	
	//This is only designed to be used by the DAO
	public Transaction(double amount, int accountNum, String transDesc, Instant date, int transactionID) {
		this.transDesc = transDesc;
		this.amount = amount;
		this.accountNum = accountNum;
		this.date = date;
		this.transactionID = transactionID;
		transactionCount++;
	}
	
	//This class is designed to be immutable
	public Transaction(double amount, int clientNum,  int accountNumber,  String transType) {
	//This constructor is designed for regular Transactions
		this.transDesc = transType;
		this.amount = amount;
		this.clientNum = clientNum;
		this.date = Instant.now();
		this.accountNum = accountNumber;
		this.transactionID = transactionCount++;
		bserv.storeTransaction(this);
	}
	
	public Transaction(double amount, int clientNum, int accountNumber) {
		//Used only once to denote that the account is held jointly
		this.transDesc = "Solo Account Creation: holder = " + clientNum;
		this.amount = amount;
		this.date = Instant.now();
		this.accountNum = accountNumber;
		this.transactionID = transactionCount++;
		bserv.storeTransaction(this);
	}
	public Transaction(double amount, int clientNum, int jointNum, int accountNumber) {
		//Used only once to denote that the account is held jointly
		this.transDesc = "Joint Account Creation: holder1 = " + clientNum + " holder2 = " + jointNum;
		this.amount = amount;
		this.date = Instant.now();
		this.accountNum = accountNumber;
		this.transactionID = transactionCount++;
		bserv.storeTransaction(this);
	}

	public double getAmount() {
		return this.amount;
	}

	public int getClientNum() {
		return this.clientNum;
	}

	public String getTransDesc() {
		return this.transDesc;
	}

	public Instant getDate() {
		//System.out.println(this.date);
		return this.date;
	}
	public int getTransactionID() {
		return this.transactionID;
	}
	public int getAccountNum() {
		return this.accountNum;
	}
	@Override
	public String toString() {
		return "\n\t\tTransaction [amount=" + amount + ", clientNum=" + clientNum + ", transDesc=" + transDesc + ", date="
				+ date + ", transactionID=" + transactionID + "]";
	}
}
