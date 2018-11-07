package bankofalexandria;

import java.io.Serializable;
import java.util.Random;

public class Account extends Customer implements Serializable {
	
	Account(){
		super();
	}
	
	Account(String name, String username, String password, int userId) {
		super(name, username, password, userId);
	}
	
	//private static final long serialVersionUID = -3198551566532409697L;

	public Account(int accountID, int balance, int userID) {
		this.accountID = accountID;
		this.balance = balance;
		this.userId = userID;
	}

	int accountID;
	double balance;
	
	
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//concrete methods
	public double withdraw(double amount) {
		if(amount<=0) {
			System.out.println("Invalid withdraw value.");
		}else if(amount>this.balance) {
			System.out.println("Insufficient funds.");
		}else {
			this.balance -= amount;
			System.out.println("Withdrawal successful.");
		}
		return this.balance;
	}
	
	public double deposit(double amount) {
		if(amount<=0) {
			System.out.println("Invalid deposit amount.");
		}else {
			this.balance += amount;
			System.out.println("Deposit successful.");
		}
		return this.balance;
	}
	
	public double makeTransfer(Account to, double amount) {
			this.withdraw(amount);
			to.deposit(amount);
			System.out.println("Transfer successful.");
			return this.balance;
	}
	
	@Override
	public String toString() {
		return "Account Info [ accountID="+accountID+", userID=" + this.userId + " , balance=" + balance + "]";
	}
	
}

	
	
