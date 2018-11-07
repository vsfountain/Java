package bankofalexandria;

import java.util.Random;

public class Administrator extends Employee{
	
	static int k;
	
	
	 SoloAccount createSoloAccount(Customer accountHolder, double initialBalance) {
			SoloAccount newAccount = new SoloAccount(accountHolder.getName(),accountHolder.getUserName(), accountHolder.getPassword(), accountHolder.getAccountID() );
			newAccount.owner1= accountHolder;
			newAccount.balance = initialBalance;
			newAccount.accountID = k++;
	
			return newAccount;
	}
	
	/*static JointAccount createJointAccount(Customer accountHolder1, Customer accountHolder2, double initialBalance) {
			JointAccount newAccount = new JointAccount(accountHolder1.getName(), accountHolder1.getUserName(), accountHolder1.getPassword());
			newAccount.owner1 = accountHolder1;
			newAccount.owner2 = accountHolder2;
			newAccount.balance = initialBalance;
			newAccount.accountID = k++;
		
			return newAccount;
	}*/
	
	static void deleteAccount(Account close) {
		close = null;
	}
}
