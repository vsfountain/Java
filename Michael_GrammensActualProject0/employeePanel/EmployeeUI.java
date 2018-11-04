package employeePanel;

import java.util.Scanner;

import accountManagement.AccountManagement;
import handlePendingAccounts.PendingAccountsManager;

public class EmployeeUI {

	private final static String employeeUserName = "employee";
	private final static String employeePassWord = "employeeemployee";
	
	public static void employeeMain(Scanner employeeDetails) throws Exception{
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
	
	public static void loggedInAccount(Scanner currString) throws Exception{
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
					System.out.print(currentAccount.getApprovedAccounts().get(i));
				}
				System.out.println();
			}
			else if(employeeController.toLowerCase().equals("balance")) {
				System.out.println("Account Balances: ");
				for(int i = 0; i < currentAccount.getApprovedAccounts().size(); i++) {
					System.out.print(currentAccount.getApprovedAccounts().get(i).getUserName() + " has this balance: " + currentAccount.getApprovedAccounts().get(i).getMoney() + " ");
				}
				System.out.println();
			}
			else if(employeeController.equals("Personal") || employeeController.equals("personal")) {
				System.out.println("Personal Information: ");
				for(int i = 0; i < currentAccount.getApprovedAccounts().size(); i++) {
					System.out.print(currentAccount.getApprovedAccounts().get(i).getUserName() + " has this password: " + currentAccount.getApprovedAccounts().get(i).getUserPW());
				}
				System.out.println();
			}
			else if(employeeController.equals("Pending") || employeeController.equals("pending")) {
				PendingAccountsManager.pendingAccounts(currString);
			}
			else {
				System.out.println("Invalid command, try again.");
			}
		}
	}
}
