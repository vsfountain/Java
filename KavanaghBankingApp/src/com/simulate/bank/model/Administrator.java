package com.simulate.bank.model;
/**
 * should be able to view and edit all accounts approving/denying accounts
 * withdrawing, depositing, transferring from all accounts canceling accounts
 * 
 * @author Kristen Kavanagh
 * @version 10/28/2028
 *
 */

public class Administrator {
	Account balance;
	Customer client;

	public Administrator() {
		this.balance = new Account();
		this.client = new Customer();
	}

	/**
	 * approve or deny account.
	 * 
	 * @return
	 */
	public void approveAccount() {
		if (balance.getBalance()>2100.00) {
			System.out.println("your account has been approved my a manager");
		} else {
			System.out.println("manager was unable to complete your request");
		}

	}
	/**
	 * Admin capable to deposit
	 * @param amount deposit
	 */
	public double deposit(double amount) {
		 return balance.getBalance();
	}

	/**
	 * Administrator withdraw.
	 */
	public double withDraw(double amount) {
		return balance.getBalance();

	}
	/**
	 * Administrator transfer
	 */
	public void adminTransferTo(Account balance, double amount) {
		if (amount <= balance.getBalance()) {
			this.withDraw(amount);
			balance.deposit(amount);
			System.out.println("\nTransfer succesful. Tansfered: $" + balance.getBalance());
		} else if (amount > balance.getBalance()) {
			System.out.println("\nTransfer failed, insufficient funds!");
		}
		
	}
/**
 * cancel account
 * 
 */
	public void cancelAccount() {
		System.exit(0);
	}
}
