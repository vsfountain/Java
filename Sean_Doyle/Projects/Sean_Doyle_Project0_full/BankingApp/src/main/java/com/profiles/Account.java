package com.profiles;
//Author: Sean Doyle
//Date Created: 2018/10/24

import java.util.ArrayList;

public class Account {
	//private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";
	private double balance;
	
	
	private int myPeople = -1;
	//private ArrayList<Integer> myPeople = new ArrayList<>();
	
	
	
	public static int accountCount = 666;
	private int accountNumber;
	private boolean jointly = false;
	private ArrayList<Transaction> history = new ArrayList<>();
	private boolean isFrozen = false;
	//private BankService bserv = new BankServiceImplementation();
	
	//This is used by the DAO to repopulate the account info
	public Account(double balance, int myPeople, int accountNumber, boolean jointly, ArrayList<Transaction> history, boolean isFrozen) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.myPeople = myPeople;
		this.jointly = jointly;
		this.history = history;
		this.isFrozen = isFrozen;
	}
	
	
	public Account(Client client) {
		this.accountNumber = accountCount++;
		this.balance = 0.0;
		this.myPeople = client.getClientID();
		//this.myPeople.add(client.getClientID());
		this.isFrozen = false;
		history.add(new Transaction(0.0, client.getClientID(), this.accountNumber));
	}

	public Account(Double balance) {
		this.balance = balance;
		this.accountNumber = accountCount++;
		history.add(new Transaction(0.0, 38, this.accountNumber));
	}
	
	//This is designed for temporary accounts:
	public Account(Client client, String noIncre) {
		this.accountNumber = client.getClientAccount();
		this.balance = 0.0;
		this.myPeople = client.getClientID();
		//this.myPeople.add(client.getClientID());
		this.isFrozen = false;
	}
	
	
	public void addCoSignator(int clientID) {
		//this.myPeople.add(clientID);
		System.out.println("Sorry this functionality is not available.");
	}
	
	
	
	
	
	public int getClientID() {
		return this.myPeople;
	}
	/*
	public ArrayList<Integer> getClientID() {
		return this.myPeople;
	}
	*/
	public boolean getAccountStatus() {
		return this.isFrozen;
	}

	public double getAccountBalance() {
		return this.balance;
	}

	public boolean checkJoint() {
		return this.jointly;
	}

	protected void setFreeze(String verify) {
		if (verify.equals(ADMINISTRATORACCESSCODE)) {
			this.isFrozen = true;
		} else {
			System.out.println(
					"Employee, the pass phrase you have enter is incorrect and The account has not been Frozen.");
		}
	}

	public void setThaw(String verify) {
		if (verify.equals(ADMINISTRATORACCESSCODE)) {
			this.isFrozen = false;
		} else {
			System.out.println(
					"Administrator, the pass phrase you have enter is incorrect and The account has not been UnFrozen.");
		}
	}

	public void toggleFreeze(String verify) {
		if (this.isFrozen) {
			setThaw(verify);
		} else {
			setFreeze(verify);
		}
	}

	public ArrayList<Transaction> getHistory() {
		return this.history;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	protected void setClientID(String verify, int clientID) {
		if (verify.equals(ADMINISTRATORACCESSCODE)) {
			//this.myPeople = clientID;
			System.out.println("SUCCESS: you have change the main client ID.");
		} else {
			System.out.println("FAIL: Invalid ADMIN access code");
		}
	}

/*
	private void setAccountNumber(int newAccNum) {
		this.accountNumber = newAccNum;// THIS IS A TERRIBLE IDEA BTW
	}
*/
	public void addHistory(Transaction t) {
		this.history.add(t);
	}
	public Double deposit(Double amt) {
		this.balance += amt;
		return this.balance;
	}
	public Double withdraw(Double amt) {
		this.balance -= amt;
		return this.balance;
	}
	
	@Override
	public String toString() {
		return "\n\tAccount [balance=" + balance + ", myPerson=" + myPeople + ", accountNumber=" + accountNumber
				+ ", jointly=" + jointly + ", history=" + history + ", isFrozen="
				+ isFrozen + "]";
	}

}
