/*
 * Michael Grammens, 10/29/2018 Banking application
 * Simple object used to store data for Pending accounts.
 */

package com.homework.appliedAccounts;

import java.io.Serializable;

public class PendingAccounts implements Serializable{
	
	private String userPW = "";
	private String userName = "";
	private String userNameJoint = "N/A";
	private String accountType = "";
	
	public PendingAccounts() {
	}
	
	public PendingAccounts(String accountType, String userName, String userNameJoint, String userPW) {
		this.accountType = accountType;
		this.userName = userName;
		this.userNameJoint = userNameJoint;
		this.userPW = userPW;
	}
	
	public String getUserNameJoint() {
		return userNameJoint;
	}
	
	public void setUserNameJoint(String name) {
		this.userNameJoint = name;
	}
	
	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "PendingAccounts [Account type for pending accounts:\t" + this.getUserName() + "\t" + this.getUserNameJoint() + "\t" + this.getAccountType() + "]";
	}
}
