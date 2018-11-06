/*
 * Checks the customer for an account, prompts the customer for log details, and gives the customer access to transactions
 */
package customerPanel;

import java.util.Scanner;

import org.apache.log4j.Logger;

import accountFunds.HandleTransactions;
import accountFunds.HandleTransactionsDao;
import accountManagement.AccountManagement;

public class CustomersUI implements CustomersUIDao{
	final static Logger logger = Logger.getLogger(CustomersUI.class);
	private static boolean passWordChecker = false;
	private static AccountManagement accountAccess = new AccountManagement();
	private static int accountID = 1;
	
	@Override
	public void customerMain(Scanner consoleInput) throws Exception{
		System.out.println("Do you have an existing account? Yes or No.");
		String accountY = consoleInput.nextLine();
		if(accountY.equals("Yes") || accountY.equals("yes")) {
			loggedInAccount(consoleInput);
		}
		else if(accountY.equals("No")||accountY.equals("no")) {
			createAccount(consoleInput);
		}
	}
	
	@Override
	public void loggedInAccount(Scanner loggedInAccount) throws Exception{
		//Login info
		String associatedName = "";
		AccountManagement currentAccount = new AccountManagement();
		int currID = 0;
		while(true){
			boolean checkName = false;
			System.out.println("Enter id associated with account or joint account or type \"Cancel\": ");
			associatedName = loggedInAccount.nextLine();
			if(associatedName.toLowerCase().equals("cancel")) {
				passWordChecker = true;
				break;
			}
			if(currentAccount.getNameOfAccountHolder(associatedName)!="") {
				checkName = true;
				currID = Integer.parseInt(associatedName);
			}
			if(checkName == false) {
				System.out.println("ID was not found in our system, try again.");
			}
			else if(checkName == true){
				while(true) {
					System.out.println("Enter password associated with the account " + associatedName+ ", or type \"Cancel\": ");
					String getPassword = loggedInAccount.nextLine();
					if(getPassword.toLowerCase().equals("cancel")) {
						passWordChecker = true;
						break;
					}
					if(currentAccount.getPasswordOfAccountHolder(associatedName).equals(getPassword)) {
						break;
					}
					else {
						System.out.println("Password incorrect, please try again.");
						logger.warn("User information entered incorrectly on account: " + associatedName);
					}
				}
				break;
			}
		}
		if(passWordChecker==false) {
			System.out.print("Welcome: " + currentAccount.getNameOfAccountHolder(associatedName));
			if(currentAccount.getNameOfJointAccountHolder(associatedName)!=""||currentAccount.getNameOfJointAccountHolder(associatedName)!="N/A") {
				System.out.println(" " + currentAccount.getNameOfJointAccountHolder(associatedName));
			}
			else {
				System.out.println();
			}
			while(true) {
				System.out.println("Would you like to withdraw, deposit or transfer funds? Withdraw, Deposit, or Transfer. Type \"Logout\" to return to home page.");
				String userAction = loggedInAccount.nextLine();
				if(userAction.toLowerCase().equals("withdraw")) {
					HandleTransactionsDao withdrawFunds = new HandleTransactions();
					withdrawFunds.withdraw(currID, currentAccount, loggedInAccount);
				}
				else if(userAction.toLowerCase().equals("deposit")) {
					HandleTransactionsDao depositFunds = new HandleTransactions();
					depositFunds.deposit(currID, currentAccount, loggedInAccount);
				}
				else if(userAction.toLowerCase().equals("transfer")) {
					HandleTransactionsDao transferFunds = new HandleTransactions();
					transferFunds.transfer(currID, currentAccount, loggedInAccount);
				}
				else if(userAction.toLowerCase().equals("logout")) {
					System.out.println("User interface cancelled, returning to home page.");
					break;
				}
				else {
					System.out.println("Input not valid, please try again, or type \"cancel\".");
				}
			}
		}
		passWordChecker = false;
	}
	
	@Override
	public void createAccount(Scanner createAccount) throws Exception{
		//Apply for an account
		while(true) {
			System.out.println("Would you like to create an account or a joint account? Account or Joint.");
			String accountX = createAccount.nextLine();
			if(accountX.equals("Account") || accountX.equals("account")) {
				System.out.println("Please enter your name specified for the account.");
				String accountName = createAccount.nextLine();
				String accountPWHolder = "";
				String accountPWConfirm = "";
				while(true) {
					System.out.println("Please enter your desired password.");
					accountPWHolder = createAccount.nextLine();
					System.out.println("Please re-enter your desired password.");
					accountPWConfirm = createAccount.nextLine();
					if(accountPWHolder.equals(accountPWConfirm)) {
						break;
					}
					else {
						System.out.println("Passwords do not match, please try again.");
					}
				}
				String accountsID = "" + accountID;
				accountAccess.setCustomerAccountRequests(accountPWConfirm, accountName, "N/A", accountX, accountsID);
				accountID++;
				System.out.println("Account has been recieved, give our Admin's sometime to approve or deny the request. You have been logged out.");
				if(logger.isInfoEnabled()) {
					logger.info("Account created: " + accountName);
				}
				break;
			}
			else if(accountX.equals("Joint") || accountX.equals("joint")) {
				System.out.println("Please enter the first specified name for the account.");
				String accountName = createAccount.nextLine();
				System.out.println("Please enter the second specified name for the account.");
				String accountNameJoint = createAccount.nextLine();
				String accountPWHolder = "";
				String accountPWConfirm = "";
				while(true) {
					System.out.println("Please enter your desired password.");
					accountPWHolder = createAccount.nextLine();
					System.out.println("Please re-enter your desired password.");
					accountPWConfirm = createAccount.nextLine();
					if(accountPWHolder.equals(accountPWConfirm)) {
						break;
					}
					else {
						System.out.println("Passwords do not match, please try again.");
					}
					
				}
				String accountsID = "" + accountID;
				accountAccess.setCustomerAccountRequests(accountPWConfirm, accountName, accountNameJoint, accountX, accountsID);
				accountID++;
				System.out.println("Joint Account has been recieved, give our Admin's sometime to approve or deny the request.");
				if(logger.isInfoEnabled()) {
					logger.info("Account created: " + accountName + " " + accountNameJoint);
				}
				break;
			}
			else if(accountX.equals("No") || accountX.equals("no")) {
				break;
			}
			else {
				System.out.println("Input was entered incorrectly, try again.");
			}
		}
	}
}
