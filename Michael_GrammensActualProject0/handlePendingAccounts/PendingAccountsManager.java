package handlePendingAccounts;

import java.util.Scanner;

import accountManagement.AccountManagement;

public class PendingAccountsManager {
	public static void pendingAccounts(Scanner currString) {
		AccountManagement currentAccounts = new AccountManagement();
		System.out.println(currentAccounts.getCustomerAccountRequests());
		System.out.println("Is there an account you would like to handle? Yes or No.");
		String accountHandling = currString.nextLine();
		if(accountHandling.toLowerCase().equals("yes")) {
			while(true) {
				System.out.println("Would you like to approve or deny an account? Approve or Deny.");
				String approveOrDeny = currString.nextLine();
				if(approveOrDeny.equals("Approve") || approveOrDeny.equals("approve")) {
					System.out.println("Which account would you like to approve? Format: ID of account holder.");
					for(int i = 0; i < currentAccounts.getCustomerAccountRequests().size(); i++) {
						System.out.println(currentAccounts.getCustomerAccountRequests().get(i));
					}
					boolean checkString = false;
					while(checkString==false) {
						String currAccount = currString.nextLine();
						if(currAccount.toLowerCase().equals("no")) {
							break;
						}
						for(int i = 0; i < currentAccounts.getCustomerAccountRequests().size(); i++) {
							String currID = "" + currentAccounts.getCustomerAccountRequests().get(i).getAccountID();
							if(currID.equals(currAccount)) {
								currentAccounts.setApprovedAccounts(currentAccounts.getCustomerAccountRequests().get(i).getUserPW(), 
										currentAccounts.getCustomerAccountRequests().get(i).getUserName(), 
										currentAccounts.getCustomerAccountRequests().get(i).getUserNameJoint(), 
										currentAccounts.getCustomerAccountRequests().get(i).getAccountType(), 
										currentAccounts.getCustomerAccountRequests().get(i).getAccountID());
								currentAccounts.removeCustomerAccountRequests(currID);
								checkString = true;
								break;
							}
						}
						if(checkString==false) {
							System.out.println("The ID of that account was not found, please try again.");
							System.out.println("Type \"no\" to exit.");
						}
						else {
							System.out.println("Account: " + currAccount + " has been Approved.");
							break;
						}
					}
					break;
				}
				else if(approveOrDeny.equals("Deny") || approveOrDeny.equals("deny")) {
					System.out.println("Which account would you like to deny? ID of current Account.");
					for(int i = 0; i < currentAccounts.getCustomerAccountRequests().size(); i++) {
						System.out.println(currentAccounts.getCustomerAccountRequests().get(i));
					}
					boolean checkString = false;
					while(checkString==false) {
						String currAccount = currString.nextLine();
						if(currAccount.toLowerCase().equals("no")) {
							break;
						}
						for(int i = 0; i < currentAccounts.getCustomerAccountRequests().size(); i++) {
							String currID = "" + currentAccounts.getCustomerAccountRequests().get(i).getAccountID();
							if(currID.equals(currAccount)) {
								currentAccounts.removeCustomerAccountRequests(currID);
								checkString = true;
								break;
							}
						}
						if(checkString==false) {
							System.out.println("The account was not found, please try again.");
							System.out.println("Type \"no\" to exit.");
						}
						else {
							System.out.println("Account: " + currAccount + " has been Denied.");
							break;
						}
					}
					break;
				}
				else{
					System.out.println("Incorrect input, please try again.");
				}
			}
		}
		else if(accountHandling.toLowerCase().equals("no")) {
			return;
		}
	}
}
