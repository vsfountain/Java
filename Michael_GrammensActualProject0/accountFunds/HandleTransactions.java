/*
 * Handles the withdraw, deposit, and transfer methods for Admin and Customer UI's
 */
package accountFunds;

import java.util.Scanner;

import accountManagement.AccountManagement;

public class HandleTransactions implements HandleTransactionsDao{
	
	@Override
	public void withdraw(int currID, AccountManagement currentAccount, Scanner getAmount) {
		double moneyAmount = 0.0;
		while(true) {
			String currIdd = "" + currID;
			System.out.print("Total Balance: " + currentAccount.dataBaseMoney(currIdd));
			System.out.println(" How much would you like to withdraw today? $$.$$");
			try {
				moneyAmount = Double.parseDouble(getAmount.nextLine());
				double moneyWithdrew = currentAccount.dataBaseWithdrawMoney(moneyAmount, currIdd);
				if(moneyWithdrew == -1.0) {
					System.out.println("Stop trying to break the system, no bad withdrawls. Try again.");
					break;
				}
				else if(moneyWithdrew == -2.0) {
					System.out.println("Not enough funds. Cancelling Transaction.");
					break;
				}
				else if(moneyWithdrew >= 0.0) {
					System.out.println("Money has been withdrawn. New available balance: " + currentAccount.dataBaseMoney(currIdd) + " Have a great Day!");
					break;
				}
			}catch(Exception E) {
				System.out.println("Wrong input, try again.");
			}
		}
	}
	
	@Override
	public void deposit(int currID, AccountManagement currentAccount, Scanner getAmount) {
		double moneyAmount = 0.0;
		while(true) {
			String currIdd = "" + currID;
			System.out.print("Total Balance: " + currentAccount.dataBaseMoney(currIdd));
			System.out.println(" How much would you like to Deposit today? $$.$$");
			try {
				moneyAmount = Double.parseDouble(getAmount.nextLine());
				if(moneyAmount<0.0) {
					System.out.println("You cannot subtract from a Deposit, try again. Exiting.....");
				}
				else {
					currentAccount.dataBaseDepositMoney(moneyAmount, currIdd);
					System.out.println("Money added to account, Total Balance: " + currentAccount.dataBaseMoney(currIdd));
					break;
				}
			}catch(Exception E) {
				System.out.println("Wrong input, try again.");
			}
		}
	}
	
	@Override
	public void transfer(int currID, AccountManagement currentAccount, Scanner getAmount) {
		double moneyAmount = 0.0;
		while(true) {
			String currIdd = "" + currID;
			System.out.print("Total Balance: " + currentAccount.dataBaseMoney(currIdd));
			System.out.println(" How much would you like to Transfer today and to which account? Or type \"Cancel\". Format: $$.$$ ID");
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
				else if(moneyAmount > currentAccount.dataBaseMoney(currIdd)) {
					System.out.println("Insufficient funds, try again.");
					break;
				}
				String idOfTransfer = transferMoney[1];
				boolean checkName = false;
				if(currentAccount.getNameOfAccountHolder(idOfTransfer)!="") {
					checkName=true;
				}
				if(checkName == true) {
					System.out.println("Transferring funds now, from account: " + currentAccount.getNameOfAccountHolder(currIdd) + 
							" " + currentAccount.getNameOfJointAccountHolder(currIdd)+ " to the account " + 
							currentAccount.getNameOfAccountHolder(idOfTransfer) + " " + currentAccount.getNameOfJointAccountHolder(idOfTransfer));
					currentAccount.dataBaseWithdrawMoney(moneyAmount, currIdd);
					currentAccount.dataBaseDepositMoney(moneyAmount, idOfTransfer);
					System.out.println("Transfer completed.");
				}
				else {
					System.out.println("ID was not found on another account, please try again or type \"Cancel\".");
				}
			}catch(Exception E) {
				System.out.println("Wrong input, try again.");
			}
		}
	}
}
