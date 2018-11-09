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
	private String description;
	private int isJointAccount;
	private int jointAccountClientId;

	/**
	 * @param client_id
	 * @param accountBalance
	 * @param interestEarned
	 * @param status
	 * @param description
	 * @param isJointAccount
	 * @param jointAccountClientId
	 */
	public Account(int client_id, double accountBalance, double interestEarned, String status, String description,
			int isJointAccount, int jointAccountClientId) {
		super();
		this.client_id = client_id;
		this.accountBalance = accountBalance;
		this.interestEarned = interestEarned;
		this.status = status;
		this.description = description;
		this.isJointAccount = isJointAccount;
		this.jointAccountClientId = jointAccountClientId;
	}
	public Account(int client_id,int accountNumber, double accountBalance, double interestEarned,
			String description, String status, int isJointAccount,int jointAccountClientId) {
		super();
		this.accountNumber = accountNumber;
		this.client_id = client_id;
		this.accountBalance = accountBalance;
		this.interestEarned = interestEarned;
		this.description = description;
		this.status = status;
		this.isJointAccount = isJointAccount;
		this.jointAccountClientId = jointAccountClientId;;
	}
/**
 * @return the isJointAccount
 */
	public int getisJointAccount() {
		return isJointAccount;
	}
	/**
	 * @param jointAccountClientId the jointAccountClentID
	 */
	public void setJointAccountClientId (int jointAccountClientId) {
		this.jointAccountClientId = jointAccountClientId;
	}
	/**
	 * 
	 */
	public int getjointAccountClientId() {
		return jointAccountClientId;
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
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
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
				+ interestEarned + ",description" + description + ",status=" + status + ",isJointAccount=" + isJointAccount + ",jointAccountClientId=" + jointAccountClientId +
				"]";
	}
}
