package employeePanel;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import accountManagement.AccountManagement;
import accountManagement.ApprovedAccounts;
import handlePendingAccounts.PendingAccountsManager;

public class EmployeeUI{

	final static Logger logger = Logger.getLogger(EmployeeUI.class);
	private final static String employeeUserName = "employee";
	private final static String employeePassWord = "employeeemployee";
	
	public void employeeMain(Scanner employeeDetails) throws Exception{
		while(true) {
			System.out.println("Enter employee details: ");
			System.out.print("Employee name: ");
			String employeeInfo = employeeDetails.nextLine();
			if(employeeInfo.toLowerCase().equals("cancel")) {
				break;
			}
			System.out.println();
			System.out.print("Employee Password: ");
			String passWord = employeeDetails.nextLine();
			boolean checkInfo = false;
			if(employeeInfo.toLowerCase().equals(employeeUserName) && passWord.toLowerCase().equals(employeePassWord)) {
				checkInfo=true;
			}
			if(checkInfo==true) {
				loggedInAccount(employeeDetails);
				break;
			}
			else if(checkInfo==false) {
				System.out.println("Invalid employee credentials, try again. Or type \"Cancel\"");
				logger.warn("Invalid employee login.");
			}
		}
	}
	
	public void loggedInAccount(Scanner currString) throws Exception{
		AccountManagement currentAccount = new AccountManagement();
		while(true) {
			System.out.println("Welcome employee, would you like to view account information, account balances, personal information, or view pending accouns? Format: Info, Balance, Personal, Pending.");
			System.out.println("Type \"Logout\" to exit.");
			String employeeController = currString.nextLine();
			if(employeeController.toLowerCase().equals("logout")) {
				break;
			}
			else if(employeeController.toLowerCase().equals("info")) {
				System.out.print("Account informations: ");
				for(int i = 0; i < currentAccount.getApprovedAccounts().size(); i++) {
					System.out.println(currentAccount.getApprovedAccounts().get(i) + " ");
				}
				System.out.println();
			}
			else if(employeeController.toLowerCase().equals("balance")) {
				System.out.println("Account Balances: ");
				ArrayList<ApprovedAccounts> getPersonal = currentAccount.getApprovedAccounts();
				for(int i = 0; i < currentAccount.getApprovedAccounts().size(); i++) {
					System.out.println(currentAccount.getNameOfAccountHolder(getPersonal.get(i).getAccountID()) + " " + currentAccount.getNameOfJointAccountHolder(getPersonal.get(i).getAccountID()) + " has this balance: " + currentAccount.dataBaseMoney(getPersonal.get(i).getAccountID()));
				}
				System.out.println();
			}
			else if(employeeController.toLowerCase().equals("personal")) {
				System.out.println("Personal Information: ");
				ArrayList<ApprovedAccounts> getPersonal = currentAccount.getApprovedAccounts();
				for(int i = 0; i < currentAccount.getApprovedAccounts().size(); i++) {
					System.out.println(currentAccount.getNameOfAccountHolder(getPersonal.get(i).getAccountID()) + " " + currentAccount.getNameOfJointAccountHolder(getPersonal.get(i).getAccountID()) + " has this password: " + currentAccount.getPasswordOfAccountHolder(getPersonal.get(i).getAccountID()));
				}
				System.out.println();
			}
			else if(employeeController.toLowerCase().equals("pending")) {
				PendingAccountsManager checkPending = new PendingAccountsManager();
				checkPending.pendingAccounts(currString);
			}
			else {
				System.out.println("Invalid command, try again.");
			}
		}
	}
}
