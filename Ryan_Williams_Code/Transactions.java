package com.project0.part1;

public class Transactions {	
	
	double funds;	
	
	public Transactions(double amount) {		
		this.funds = amount;
	}
	
	public double withdraw(double withdrawAmount) {
		if(funds - withdrawAmount < 0) {
			System.out.println("Insufficient funds for that transaction");
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
