package adminPanel;

import java.util.Scanner;

import org.apache.log4j.Logger;

import accountFunds.HandleTransactions;
import accountFunds.HandleTransactionsDao;
import accountManagement.AccountManagement;
import handlePendingAccounts.PendingAccountsManager;
import handlePendingAccounts.PendingAccountsManagerDao;

public class AdminsUI implements AdminsUIDao{
	final static Logger logger = Logger.getLogger(AdminsUI.class);
	private final static String adminUserName="admin";
	private final static String adminPassWord="adminadmin";
	
	@Override
	public void adminMain(Scanner adminDetails) throws Exception{
		while(true) {
			System.out.println("Enter admin details: ");
			System.out.print("Admin name: ");
			String employeeInfo = adminDetails.nextLine();
			if(employeeInfo.toLowerCase().equals("cancel")) {
				break;
			}
			System.out.println();
			System.out.print("Admin Password: ");
			String passWord = adminDetails.nextLine();
			boolean checkInfo = false;
			if(employeeInfo.toLowerCase().equals(adminUserName) && passWord.toLowerCase().equals(adminPassWord)) {
				checkInfo=true;
			}
			if(checkInfo==true) {
				loggedInAccount(adminDetails);
				break;
			}
			else if(checkInfo==false) {
				System.out.println("Invalid admin credentials, try again. Or type \"Cancel\"");
				logger.warn("Invalid admin login.");
			}
		}
	}
	
	@Override
	public void loggedInAccount(Scanner currString) throws Exception{
		AccountManagement currentAccount = new AccountManagement();
		while(true){
			System.out.println("Welcome admin, would you like to view pending accounts, change money in accounts, or cancel an account? or type \"Logout\". Format: Pending, Change or Cancel.");
			String adminControl = currString.nextLine();
			if(adminControl.toLowerCase().equals("pending")) {
				PendingAccountsManagerDao checkPending = new PendingAccountsManager();
				checkPending.pendingAccounts(currString);
			}
			else if(adminControl.toLowerCase().equals("change")) {
				while(true) {
					int currID = 0;
					boolean checker = false;
					System.out.print("Which accountID would you like to change? or type \"Cancel\": ");
					if(currentAccount.selectApprovedDataBase()==-1) {
						System.out.println("No accounts open at this time, returning......");
						break;
					}
					System.out.println();
					String adminInput = currString.nextLine();
					if(adminInput.toLowerCase().equals("cancel")) {
						System.out.println("Admin interface cancelled, returning to home page.");
						break;
					}
					if(currentAccount.getNameOfAccountHolder(adminInput)!="") {
						checker = true;
						currID = Integer.parseInt(adminInput);
					}
					if(checker==false) {
						System.out.println("Account was not found, try again.");
					}
					else{
						System.out.println("Would you like to withdraw, deposit, or transfer?");
						String adminControlled = currString.nextLine();
						if(adminControlled.toLowerCase().equals("withdraw")) {
							HandleTransactionsDao withdrawFunds = new HandleTransactions();
							withdrawFunds.withdraw(currID, currentAccount, currString);
						}
						else if(adminControlled.toLowerCase().equals("deposit")) {
							HandleTransactionsDao depositFunds = new HandleTransactions();
							depositFunds.deposit(currID, currentAccount, currString);
						}
						else if(adminControlled.toLowerCase().equals("transfer")) {
							HandleTransactionsDao transferFunds = new HandleTransactions();
							transferFunds.transfer(currID, currentAccount, currString);
						}
					}
				}
			}
			else if(adminControl.toLowerCase().equals("cancel")) {
				while(true) {
					System.out.print("Accounts currently listed: ");
					if(currentAccount.selectApprovedDataBase()==-1) {
						System.out.println("No accounts open at this time, returning......");
						break;
					}
					System.out.println();
					System.out.println("Enter accountID you wish to cancel or type \"cancel\":");
					String closeAccount = currString.nextLine();
					if(closeAccount.toLowerCase().equals("cancel")) {
						break;
					}
					boolean checker = false;
					for(int i = 0; i < currentAccount.getApprovedAccounts().size(); i++) {
						if(closeAccount.equals("" + currentAccount.getApprovedAccounts().get(i).getAccountID())) {
							System.out.println("Closing account: " + closeAccount);
							currentAccount.removeApprovedAccount(closeAccount);
							checker = true;
						}
					}
					if(checker==false) {
						System.out.println("Wrong account, try again.");
					}
				}
			}
			else if(adminControl.toLowerCase().equals("logout")) {
				break;
			}
			else {
				System.out.println("Incorrect input, try again.");
			}
		}
	}
}
