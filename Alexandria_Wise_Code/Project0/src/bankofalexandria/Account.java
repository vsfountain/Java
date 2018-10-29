package bankofalexandria;

import java.io.Serializable;
import java.util.Random;

public class Account extends Customer implements Serializable {
	
	Account() {
		// TODO Auto-generated constructor stub
	}

	Random accountID;
	double balance;
	
	//concrete methods
	public void withdraw(double amount) {
		if(amount<0) {
			System.out.println("Invalid withdraw value.");
		}else if(amount>this.balance) {
			System.out.println("Insufficient funds.");
		}else {
			this.balance -= amount;
			System.out.println("Withdrawal successful.");
		}
	}
	
	public void deposit(double amount) {
		if(amount<0) {
			System.out.println("Invalid deposit amount.");
		}else {
			this.balance += amount;
			System.out.println("Deposit successful.");
		}
	}
	
	public void makeTransfer(Account to, double amount) {
			this.withdraw(amount);
			to.deposit(amount);
			System.out.println("Transfer successful.");
	}
	
	@Override
	public String toString() {
		return "Account Info [ accountID="+accountID+", name=" + name + ", userName=" + userName + ", balance=" + balance + "]";
	}
	
}

	
	
