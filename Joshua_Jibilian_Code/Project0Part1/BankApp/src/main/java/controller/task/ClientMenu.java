package controller.task;

import java.util.ArrayList;
import java.util.Scanner;

import controller.main.RunApp;
import model.accounts.Account;
import model.accounts.JointAccount;
import model.accounts.PotentialAccounts;
import model.users.AllUsers;
import model.users.CurrentUser;
import model.users.Employee;
import model.users.User;
import view.ClientOptions;

// TODO: Auto-generated Javadoc
/**
 * handles all the logic in the clients menu.
 */
public class ClientMenu {

	/**
	 *Starts the clients menue.
	 */
	public static void goToClientMenu() {
		Scanner scan = RunApp.scan;
		CurrentUser user = CurrentUser.getInstance();
		User currentUser = user.getCurrentUser();
		PotentialAccounts accounts = PotentialAccounts.getInstance();
		System.out.println("loading this properly? " + accounts);
		int choice = -1;
		while (choice != 7) {
			choice = ClientOptions.showClientOptions();
			if (choice == 1) { // view personal info
				System.out.println(user.getCurrentUser());
				for (Account x : user.getCurrentUser().getAccounts()) {
					System.out.println(x);
				}
			} else if (choice == 2) {// apply for account
				User applying = new User(currentUser.getName(), currentUser.getEmail(), null,
						currentUser.getAccountId());
				Account newAccount = null;
				System.out.println("What type of account do you want?\n[1] Checking\n [2]Savings");
				int accountChoice = scan.nextInt();
				if (accountChoice != 1 && accountChoice != 2) {
					System.out.println("not valid account type");

				} else if (accountChoice == 1) {
					// System.out.println(accounts);
					// System.out.println(applying.getAccounts());
					newAccount = new Account("Checking", accounts.getAccountId());
					System.out.println("request sent for aproval");
				} else if (accountChoice == 2) {
					newAccount = (new Account("Savings", accounts.getAccountId()));
					System.out.println("request sent for aproval");
				}
				if (newAccount != null) {
					int index = accounts.getUsers().indexOf(applying);
					if (index >= 0) {
						accounts.getUsers().get(index).getAccounts().add(newAccount);
					} else {
						applying.getAccounts().add(newAccount);
						accounts.addUser(applying);
					}
					System.out.println("Added app " + accounts.getUsers());
				}

				// make withdraw
			} else if (choice == 3) {

				Utility.withdraw();
				// make deposits
			} else if (choice == 4) {
				Utility.deposit();

				// Transfer
			} else if (choice == 5) {

				ArrayList<Account> theirAccounts = currentUser.getAccounts();
				if (theirAccounts.size() <= 1) {
					System.out.println("You need more then 1 account to transfer");
				} else {
					Utility.transfer();
				}
				//create the joint account request
			} else if (choice == 6) {
				System.out.println("enter email of person you want to create a joint account with.");
				String email = scan.next();
				User check = new User(null, email, null);
				AllUsers allOfThem = AllUsers.getInstance();
				ArrayList<User> theActualUsers = allOfThem.getUsers();
				//checks if the joint user requested exists and isn't an employee
				if (theActualUsers.contains(check)) {
					int indexOf = theActualUsers.indexOf(check);
					if(theActualUsers.get(indexOf) instanceof Employee) {
						System.out.println("That user dosn't exsist");
					} else {
						//creation and addition of the joint account object into request table
						User toAdd = new User(currentUser.getName(), currentUser.getEmail(), null);
						JointAccount jC = new JointAccount("Joint", accounts.getAccountId());
						jC.addUser(currentUser);
						//System.out.println("CU " + currentUser);
						jC.addUser(check);
						//System.out.println("Check"+ check);
						//System.out.println("UWITN" + jC.getUsersWith());
						toAdd.getAccounts().add(jC);
						accounts.addUser(toAdd);
						System.out.println("account sent for aproval");
					}
					
				} else {
					System.out.println("That user dosn't exsist");
				}
			}
			if (choice != 7) {
				choice = -1;
			}
		}
	}
}
