/*
 * Michael Grammens, 10/29/2018 Banking application
 * Simple object used to store data for Approved accounts.
 */
package com.homework.customerAccounts;

import java.io.Serializable;

public class ApprovedAccounts implements Serializable{
	
	private String userPW = "";
	private String userName = "";
	private String accountType = "";
	private String userNameJoint = "";
	private Double money = 0.0;
	
	public ApprovedAccounts() {
	}
	
	public ApprovedAccounts(String userPW, String userName, String accountType, String userNameJoint) {
		this.userPW = userPW;
		this.userName = userName;
		this.accountType = accountType;
		this.userNameJoint = userNameJoint;
	}
	
	public Double getMoney() {
		return this.money;
	}
	public void setMoney(double deposit) {
		this.money+=deposit;
	}
	public double withdraw(double amount) {
		if(amount <= 0.0) {
			return -1.0;
		}
		if(amount > this.money) {
			return 0;
		}
		else if(amount <= this.money) {
			this.money-=amount;
			return this.money;
		}
		return 0;
	}
	public String getUserNameJoint() {
		return this.userNameJoint;
	}
	public void setUserNameJoint(String userNameJoint) {
		this.userNameJoint = userNameJoint;
	}
	public String getUserPW() {
		return this.userPW;
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
		return "Account List [Account type for created accounts:\t" + this.getUserName() + "\t" + this.getUserNameJoint()+ "\t" + this.getAccountType()+ "\t" + this.getMoney() + "]";
	}
}
