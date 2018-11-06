package accountFunds;

import java.util.Scanner;

import accountManagement.AccountManagement;

public interface HandleTransactionsDao {

	public void withdraw(int currID, AccountManagement currentAccount, Scanner getAmount);
	public void deposit(int currID, AccountManagement currentAccount, Scanner getAmount);
	public void transfer(int currID, AccountManagement currentAccount, Scanner getAmount);
}
