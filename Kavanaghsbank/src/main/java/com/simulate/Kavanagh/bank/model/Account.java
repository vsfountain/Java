package com.simulate.Kavanagh.bank.model;

/**
 * @author Kristen Kavanagh
 * @version 11/4/2018
 *
 */
public class Account {
//initialize
	private int accountNumber;
	private int client_id;
	private double accountBalance;
	private double interestEarned;
	private String status;
	private char description;

	public Account(int accountNumber, int client_id, double accountBalance, double interestRate, double interestEarned,
			char description, String status) {
		super();
		this.accountNumber = accountNumber;
		this.client_id = client_id;
		this.accountBalance = accountBalance;
		this.interestEarned = interestEarned;
		this.description = description;
		this.status = status;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the client_id
	 */
	public int getClient_id() {
		return client_id;
	}

	/**
	 * @param client_id the client_id to set
	 */
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	/**
	 * @return the accountBalance
	 */
	public double getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	/**
	 * @return the interestEarned
	 */
	public double getInterestEarned() {
		return interestEarned;
	}

	/**
	 * @param interestEarned the interestEarned to set
	 */
	public void setInterestEarned(double interestEarned) {
		this.interestEarned = interestEarned;
	}

	/**
	 * @return the description
	 */
	public char getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(char description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account[accountNumber=" + accountNumber + ",accountBalance=" + accountBalance + ",interestEarned ="
				+ interestEarned + ",description" + description + ",status=" + status + "]";
	}
}
