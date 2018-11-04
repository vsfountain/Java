/*
 * Handles the withdraw, deposit, and transfer methods for Admin and Customer UI's
 */
package accountFunds;

import java.util.Scanner;

import accountManagement.AccountManagement;

public class HandleTransactions implements HandleTransactionsDao{
	
	@Override
	public void withdraw(int currentAccountDetails, AccountManagement currentAccount, Scanner getAmount) {
		double moneyAmount = 0.0;
		while(true) {
			System.out.print("Total Balance: " + currentAccount.getApprovedAccounts().get(currentAccountDetails).getMoney());
			System.out.println(" How much would you like to withdraw today? $$.$$");
			try {
				moneyAmount = Double.parseDouble(getAmount.nextLine());
				double moneyWithdrew = currentAccount.getApprovedAccounts().get(currentAccountDetails).withdraw(moneyAmount);
				if(moneyWithdrew == -1.0) {
					System.out.println("Stop trying to break the system, no bad withdrawls. Try again.");
					break;
				}
				else if(moneyWithdrew == -2.0) {
					System.out.println("Not enough funds. Cancelling Transaction.");
					break;
				}
				else if(moneyWithdrew >= 0.0) {
					System.out.println("Money has been withdrawn. New available balance: " + currentAccount.getApprovedAccounts().get(currentAccountDetails).getMoney() + " Have a great Day!");
					break;
				}
			}catch(Exception E) {
				System.out.println("Wrong input, try again.");
			}
		}
	}
	
	@Override
	public void deposit(int currentAccountDetails, AccountManagement currentAccount, Scanner getAmount) {
		double moneyAmount = 0.0;
		while(true) {
			System.out.print("Total Balance: " + currentAccount.getApprovedAccounts().get(currentAccountDetails).getMoney());
			System.out.println(" How much would you like to Deposit today? $$.$$");
			try {
				moneyAmount = Double.parseDouble(getAmount.nextLine());
				if(moneyAmount<0.0) {
					System.out.println("You cannot subtract from a Deposit, try again. Exiting.....");
				}
				else {
					currentAccount.getApprovedAccounts().get(currentAccountDetails).setMoney(moneyAmount);
					System.out.println("Money added to account, Total Balance: " + currentAccount.getApprovedAccounts().get(currentAccountDetails).getMoney());
					break;
				}
			}catch(Exception E) {
				System.out.println("Wrong input, try again.");
			}
		}
	}
	
	@Override
	public void transfer(int currentAccountDetails, AccountManagement currentAccount, Scanner getAmount) {
		double moneyAmount = 0.0;
		int otherAccountDetails = 0;
		while(true) {
			System.out.print("Total Balance: " + currentAccount.getApprovedAccounts().get(currentAccountDetails).getMoney());
			System.out.println(" How much would you like to Transfer today and to which account? Or type \"Cancel\". Format: $$.$$ Name");
			String check = getAmount.nextLine();
			if(check.equals("cancel")||check.equals("Cancel")) {
				break;
			}
			try {
				String[] transferMoney = check.split(" ");
				moneyAmount = Double.parseDouble(transferMoney[0]);
				if(moneyAmount <= 0.0) {
					System.out.println("You cannot transfer zero or negative funds, try again.");
					break;
				}
				else if(moneyAmount > currentAccount.getApprovedAccounts().get(currentAccountDetails).getMoney()) {
					System.out.println("Insufficient funds, try again.");
					break;
				}
				String nameOfTransfer = transferMoney[1];
				boolean checkName = false;
				for(int i = 0; i < currentAccount.getApprovedAccounts().size(); i++) {
					if(currentAccount.getApprovedAccounts().get(i).getUserName().equals(nameOfTransfer) || currentAccount.getApprovedAccounts().get(i).getUserNameJoint().equals(nameOfTransfer)) {
						checkName = true;
						otherAccountDetails = i;
						break;
					}
				}
				if(checkName == true) {
					System.out.println("Transferring funds now, from account: " + currentAccount.getApprovedAccounts().get(currentAccountDetails) + " to the account " + currentAccount.getApprovedAccounts().get(otherAccountDetails));
					currentAccount.getApprovedAccounts().get(currentAccountDetails).withdraw(moneyAmount);
					currentAccount.getApprovedAccounts().get(otherAccountDetails).setMoney(moneyAmount);
					System.out.println("Transfer completed.");
				}
				else {
					System.out.println("Name was not found on another account, please try again or type \"Cancel\".");
				}
			}catch(Exception E) {
				System.out.println("Wrong input, try again.");
			}
		}
	}
}
