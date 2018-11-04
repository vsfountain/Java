package accountFunds;

import java.util.Scanner;

import accountManagement.AccountManagement;

public interface HandleTransactionsDao {

	public void withdraw(int currentAccountDetails, AccountManagement currentAccount, Scanner getAmount);
	public void deposit(int currentAccountDetails, AccountManagement currentAccount, Scanner getAmount);
	public void transfer(int currentAccountDetails, AccountManagement currentAccount, Scanner getAmount);
}
