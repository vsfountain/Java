package bankofalexandria;

import java.util.Random;

public class Administrator extends Employee{
	
	
	static SoloAccount createSoloAccount(Customer accountHolder, double initialBalance) {
			SoloAccount newAccount = new SoloAccount();
			newAccount.owner1= accountHolder;
			newAccount.balance = initialBalance;
			newAccount.accountID = new Random();
	
			return newAccount;
	}
	
	static JointAccount createJointAccount(Customer accountHolder1, Customer accountHolder2, double initialBalance) {
			JointAccount newAccount = new JointAccount();
			newAccount.owner1 = accountHolder1;
			newAccount.owner2 = accountHolder2;
			newAccount.balance = initialBalance;
			newAccount.accountID = new Random();
		
			return newAccount;
	}
	
	static void deleteAccount(Account close) {
		close = null;
	}
}
