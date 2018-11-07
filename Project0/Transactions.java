package com.project0;

import org.apache.log4j.Logger;

public class Transactions {	
	final static Logger logger = Logger.getLogger(Transactions.class);
	double funds;	
	
	public Transactions() {//no args constructor
		
	}
	public Transactions(double amount) {		
		this.funds = amount;
	}
	
	public double withdraw(double withdrawAmount) {
		if(funds - withdrawAmount < 0) {
			System.out.println("Insufficient funds for that transaction");
			logger.warn("Warning Insufficient funds");
		}
		funds = funds - withdrawAmount;
		if(funds < 0) {
			funds = 0;
		}		
		return funds;
	}
	public double deposit(double depositAmount) {
		if(depositAmount < 0) {
			System.out.println("Please enter a positive number");
			logger.warn("Warning, please enter a positive number");
		}
		funds = funds + depositAmount;
		if(funds < 0) {
			funds = 0;
		}		
		return funds;
	}
	public double transfer(double transferAmount, int idNum) {
		if(funds - transferAmount < 0) {
			System.out.println("Insufficient funds for that transaction");
			logger.warn("Warning Insufficient funds");
		}
		funds = funds - transferAmount;
		if(funds < 0) {
			funds = 0;
		}
		return funds;
	}	
	
	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	@Override
	public String toString() {
		return "Transactions [funds=" + funds + "]";
	}
	
}
