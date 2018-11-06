package employeePanel;

import java.util.Scanner;

import accountManagement.AccountManagement;
import handlePendingAccounts.PendingAccountsManager;
import handlePendingAccounts.PendingAccountsManagerDao;

public class EmployeeUI implements EmployeeUIDao{

	private final static String employeeUserName = "employee";
	private final static String employeePassWord = "employeeemployee";
	
	@Override
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
			}
		}
	}
	
	@Override
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
					System.out.print(currentAccount.getApprovedAccounts().get(i) + " ");
				}
				System.out.println();
			}
			else if(employeeController.toLowerCase().equals("balance")) {
				System.out.println("Account Balances: ");
				for(int i = 1; i < currentAccount.getApprovedAccounts().size()+1; i++) {
					String currID = "" + i;
					System.out.println(currentAccount.getNameOfAccountHolder(currID) + " " + currentAccount.getNameOfJointAccountHolder(currID) + 
							" has this balance: " + currentAccount.dataBaseMoney(currID));
				}
				System.out.println();
			}
			else if(employeeController.toLowerCase().equals("personal")) {
				System.out.println("Personal Information: ");
				for(int i = 1; i < currentAccount.getApprovedAccounts().size()+1; i++) {
					String currID = "" + i;
					System.out.println(currentAccount.getNameOfAccountHolder(currID) + " " + currentAccount.getNameOfJointAccountHolder(currID) + " has this password: " + currentAccount.getPasswordOfAccountHolder(currID));
				}
				System.out.println();
			}
			else if(employeeController.toLowerCase().equals("pending")) {
				PendingAccountsManagerDao checkPending = new PendingAccountsManager();
				checkPending.pendingAccounts(currString);
			}
			else {
				System.out.println("Invalid command, try again.");
			}
		}
	}
}
