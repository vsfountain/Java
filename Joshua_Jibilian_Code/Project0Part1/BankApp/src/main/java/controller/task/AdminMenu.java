package controller.task;

import java.util.ArrayList;
import java.util.Scanner;

import controller.dataio.ScannerInt;
import controller.main.RunApp;
import controller.services.UserService;
import controller.services.UserServicesImpl;
import model.accounts.Account;
import model.accounts.JointAccount;
import model.users.AllUsers;
import model.users.User;
import view.AdminOptions;

// TODO: Auto-generated Javadoc
// 
/**
 * The Class AdminMenu. Handles all logic for the admin menu
 */
public class AdminMenu {
	static ScannerInt scannerInt = new ScannerInt();
	/**
	 * Go to admin menu.
	 */
	public static void goToAdminMenu() {
		
		// stores users and approved accounts.
	
		UserService services = new UserServicesImpl();
		// Stores requests
		// Accounts that have a requests for checking, svaings or joint account
		
		// System.out.println("Admin Menu: " + users);
		// CurrentUser user = CurrentUser.getInstance();
		int choice = -1;
		while (choice != 7) {
			choice = AdminOptions.showAdminOptions();
			if (choice == 1) { // view all client info
				ArrayList<User> allInfo = services.getAccountsForAll();
;				for (User x : allInfo) {
					System.out.println(x);
					for (Account y : x.getAccounts()) {
						System.out.println("\t" + y);
					}
				}
				// validate accounts
			} else if (choice == 2) {
				Account toApprove = null;
				ArrayList<User> accountsToAprove = services.getAccountsForAproval();
				//System.out.println("FOR APROVAL!!!" + accountsToAprove);
				if (accountsToAprove == null || accountsToAprove.size() == 0) {
					System.out.println("No Accounts to aprove");
				} else {
					System.out.println("Choose user to aprove for");
					int selection = 1;
					for (User x : accountsToAprove) {
						System.out.println("[" + (selection) + "]" + " " + x);
						selection += 1;
					}
					int max = selection;
					selection = scannerInt.scanInt(); // User choice
					
					if (selection < 1 || selection > max) {
						System.out.println("not a valid choice");
					} else {
						User toApproveFor = accountsToAprove.get(selection - 1); // User looking for approval
						System.out.println("select account to approve");
						int selection2 = 1; // Account type request
						// print accounts with requests
						for (Account x : toApproveFor.getAccounts()) {
							System.out.println("[" + (selection2) + "]" + " " + x);
							selection2 += 1;
						}
						// choice validation
						int max2 = selection2;
						selection2 = scannerInt.scanInt();
						System.out.println(selection2 + " " + max2 + " " + (selection2 < 1) + " "+ (selection2 > max2));
						if (selection2 < 1 || selection2 > max2) {
							System.out.println("not a valid choice " + selection2);
						} else {
							// add account to main table
							toApprove = toApproveFor.getAccounts().get(selection2 - 1);

						}
						Boolean result = false;
						if (toApprove != null) {
							if(toApprove instanceof JointAccount) {
								result = services.approveJointAccount((JointAccount)toApprove);
								
							} else {
								result = services.approveAccount(toApproveFor, toApprove);

							}
							
							if (result) {
								System.out.println("Account added");
							} else {
								System.out.println("1Something went wrong with connection, try again later #1");
							}
							
							
							
						} else {
							System.out.println("2Something went wrong with connection, try again later");
						}
					}
				}

			} else if (choice == 3) {// close account
				User theUser = selectUser();
				if (theUser != null) {
					deleteAccount(theUser);
				} else {
					System.out.println("bad input");
				}
			} else if (choice == 4) {// withdraw from user account
				User theUser = selectUser();
				if (theUser != null) {
					Utility.withdraw(theUser);
				} else {
					System.out.println("bad input");
				}
			} else if (choice == 5) {// Deposit user account
				User theUser = selectUser();
				if (theUser != null) {
					Utility.deposit(theUser);

				} else {
					System.out.println("bad input");
				}
			} else if (choice == 6) {// transfer user account
				User theUser = selectUser();
				if (theUser != null) {
					Utility.Transfer(theUser);
				} else {
					System.out.println("bad input");
				}
			}
			if (choice != 7) {
				choice = -1;
			}
		}
	}

	/**
	 * Allows admin to select a user to work on.
	 *
	 * @return User the user to work on
	 */
	static private User selectUser() {
		
		UserService services = new UserServicesImpl();
		ArrayList<User> users = services.getAccountsForAll();
		System.out.println("Select user account to modify");
		int selection = 1;
		for (User x : users) {
			System.out.println("[" + selection + "]" + x);
			selection += 1;
		}
		int index = scannerInt.scanInt();
		if (index > 0 && index < selection) {
			return users.get(index - 1);
		}
		return null;
	}

	/**
	 * Used to delete the account of a user.
	 *
	 * @param currentUser the current user
	 */
	static private void deleteAccount(User currentUser) {

		System.out.println("Select account to delete ");
		UserService services = new UserServicesImpl();
		ArrayList<Account> theirAccounts = currentUser.getAccounts();
		int selection = 1;
		for (Account x : theirAccounts) {
			System.out.println("[" + selection + "]" + x);
			selection += 1;
		}
		int index = scannerInt.scanInt();
		if (index > 0 && index < selection) {
			Account toRemove = theirAccounts.get(index - 1);
			if(services.cancelAccount(toRemove.getId())) {
				System.out.println("account cancled");
			} else {
				System.out.println("Acount not deleted, try again later.");
			}
		} else {
			System.out.println("bad input");
		}

	}

	/**
	 * Creates the joint account for each user specified to have ownership of it.
	 *
	 * @param toApprove the to approve
	 */
	static private void createJointAccount(JointAccount toApprove) {
		ArrayList<User> addTo = toApprove.getUsersWith();
		AllUsers users = AllUsers.getInstance();
		ArrayList<User> allTheUsers = users.getUsers();
		for (User x : addTo) {
			int index = allTheUsers.indexOf(x);
			allTheUsers.get(index).getAccounts().add(toApprove);
		}
	}
}