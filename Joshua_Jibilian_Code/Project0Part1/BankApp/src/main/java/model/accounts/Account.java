/*
 * 
 */
package model.accounts;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Account.
 */
public class Account implements Serializable{
	
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2317963651739543774L;
	
	/**  The balance of the account. */
	private int balance = 0;
	
	/** The id of the account. */
	private final int id;
	
	
	/** The type of the account. Probably should use enums later */
	private String type = "";
	
	
	/**
	 * Instantiates a new account.
	 *
	 * @param type the type
	 * @param id the id
	 */
	public Account(String type, int id) {
		this.type = type;
		this.id = id;
	}
	
	/**
	 * Add money to account.
	 *
	 * @param ammount the ammount
	 * @return true, if successful
	 */
	public boolean deposit(int ammount) {
		if (ammount < 0) {
			return false;
		}
		balance += ammount;
		return true;
	}
	
	/**
	 * Withdraws money from account and prevents over drawing the account.
	 *
	 * @param amount the amount
	 * @return true, if successful, false if they try to overdraw
	 */
	public boolean withdraw(int amount) {
		if(amount < 0) {
			return false;
		}
		if(balance - amount < 0) {
			return false;
		} else {
			balance-=amount;
			return true;
		}
	}
	
	/**
	 * Used to transfer money from this account to another.
	 *
	 * @param amount the amount
	 * @param to the to
	 * @return true, if successful, false if they try to transfer more then they have
	 */
	public boolean transfer(int amount, Account to) {
		if(amount < 0) {
			return false;
		}
		if (this.getBalance() - amount < 0) {
			return false;
		} else {
			this.balance -= amount;
			to.balance += amount;
			return true;
		}
	}
	
	/**
	 * Gets the balance.
	 *
	 * @return int, the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(int balance) {
		
		this.balance = balance;
	}

	/**
	 * Gets the type of account.
	 *
	 * @return String, the type of account
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of account.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the id.
	 *
	 * @return int, id
	 */
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", id=" + id + ", type=" + type + "]";
	}
	
}
