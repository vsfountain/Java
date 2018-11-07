package controller.task;

import java.util.ArrayList;
import java.util.Scanner;

import controller.main.RunApp;
import model.accounts.Account;
import model.accounts.JointAccount;
import model.accounts.PotentialAccounts;
import model.users.AllUsers;
import model.users.User;
import view.AdminOptions;

// TODO: Auto-generated Javadoc
// 
/**
 * The Class AdminMenu. Handles all logic for the admin menu
 */
public class AdminMenu {

	/**
	 * Go to admin menu.
	 */
	public static void goToAdminMenu() {
		Scanner scan = RunApp.scan;
		//stores users and approved accounts.
		AllUsers users = AllUsers.getInstance();
		//Stores requests
		//Accounts that have a requests for checking, svaings or joint account
		PotentialAccounts accounts = PotentialAccounts.getInstance(); 
		//System.out.println("Admin Menu: " + users);
		//CurrentUser user = CurrentUser.getInstance();
		int choice = -1;
		while (choice != 7) {
			choice = AdminOptions.showAdminOptions();
			if (choice == 1) { // view all client info
				for (User x : users.getUsers()) {
					System.out.println(x);
					for (Account y : x.getAccounts()) {
						System.out.println("\t" + y);
					}
				}
				// validate accounts
			} else if (choice == 2) {
				System.out.println(accounts.getUsers());
				if (accounts.getUsers() == null || accounts.getUsers().size() == 0) {
					System.out.println("No Accounts to aprove");
				} else {
					System.out.println("Choose user to aprove for");
					int selection = 1;
					for (User x : accounts.getUsers()) {
						System.out.println("[" + (selection) + "]" + " " + x);
						selection += 1;
					}
					int max = selection;
					selection = scan.nextInt(); //User choice
					if (selection < 1 || selection > max) {
						System.out.println("not a valid choice");
					} else {
						User toApproveFor = accounts.getUsers().get(selection - 1); // User looking for approval
						System.out.println("select account to approve");
						int selection2 = 1; // Account type request
						//print accounts with requests
						for (Account x : toApproveFor.getAccounts()) {
							System.out.println("[" + (selection2) + "]" + " " + x);
							selection2 += 1;
						}
						//choice validation
						int max2 = selection2;
						selection2 = scan.nextInt();
						if (selection2 < 1 || selection > max2) {
							System.out.println("not a valid choice");
						} else {
							//add account to main table
							Account toApprove = toApproveFor.getAccounts().get(selection2 - 1);
							if (toApprove instanceof JointAccount) { //goes to joint account logic
								createJointAccount((JointAccount) toApprove);
								ArrayList<Account> peek = accounts.getUsers().get(selection - 1).getAccounts();
								//System.out.println("Peek is" + peek);
								//removes user from request table when there will be no requests later
								if (peek.size() == 1) {
									accounts.getUsers().remove(selection - 1);
								} else {
									peek.remove(selection2 - 1);
								}
							} else {
								//Find user in main table, add account to him
								int index = users.getUsers().indexOf(toApproveFor);
								User gettingNewAccount = users.getUsers().get(index);
								gettingNewAccount.getAccounts().add(toApproveFor.getAccounts().get(selection2 - 1));

								ArrayList<Account> peek = accounts.getUsers().get(selection - 1).getAccounts();
								//System.out.println("Peek is" + peek);
								if (peek.size() == 1) {
									accounts.getUsers().remove(selection - 1);
								} else {
									peek.remove(selection2 - 1);
								}
							}
							System.out.println("Account added");
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
		Scanner scan = RunApp.scan;
		AllUsers users = AllUsers.getInstance();
		System.out.println("Select user account to modify");
		int selection = 1;
		for (User x : users.getUsers()) {
			System.out.println("[" + selection + "]" + x);
			selection += 1;
		}
		int index = scan.nextInt();
		if (index > 0 && index < selection) {
			return users.getUsers().get(index - 1);
		}
		return null;
	}

	/**
	 * Used to delete the account of a user.
	 *
	 * @param currentUser the current user
	 */
	static private void deleteAccount(User currentUser) {
		Scanner scan = RunApp.scan;
		System.out.println("Select account to delete ");
		ArrayList<Account> theirAccounts = currentUser.getAccounts();
		int selection = 1;
		for (Account x : theirAccounts) {
			System.out.println("[" + selection + "]" + x);
			selection += 1;
		}
		int index = scan.nextInt();
		if (index > 0 && index < selection) {
			theirAccounts.remove(index - 1);
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
