package controller.task;

import java.util.ArrayList;
import java.util.Scanner;

import controller.dataio.ScannerInt;
import controller.main.RunApp;
import controller.services.UserService;
import controller.services.UserServicesImpl;
import model.accounts.Account;
import model.users.CurrentUser;
import model.users.User;
import view.ClientOptions;

// TODO: Auto-generated Javadoc
/**
 * handles all the logic in the clients menu.
 */
public class ClientMenu {
	static ScannerInt scannerInt = new ScannerInt();
	/**
	 * Starts the clients menue.
	 */
	public static void goToClientMenu() {
		Scanner scan = RunApp.scan;
		UserService services = new UserServicesImpl();
		CurrentUser user = CurrentUser.getInstance();
		User currentUser = user.getCurrentUser();
		// PotentialAccounts accounts = PotentialAccounts.getInstance();
		// System.out.println("loading this properly? " + accounts);
		int choice = -1;
		while (choice != 7) {
			choice = ClientOptions.showClientOptions();
			if (choice == 1) { // view personal info
				System.out.println(currentUser);
				ArrayList<Account> accounts = services.getAccounts(currentUser.getAccountId());
				for (Account x : accounts) {
					System.out.println(x);
				}
			} else if (choice == 2) {// apply for account
				System.out.println("What type of account do you want?\n[1] " + "Savings\n[2] Checking");
				int accountChoice = scannerInt.scanInt();
				Boolean result = false;
				if (accountChoice != 1 && accountChoice != 2) {
					System.out.println("not valid account type");

				} else if (accountChoice == 1) {

					// System.out.println(accounts);
					// System.out.println(applying.getAccounts());

					result = services.applyForAccount(currentUser.getAccountId(), 1);
				} else if (accountChoice == 2) {
					result = services.applyForAccount(currentUser.getAccountId(), 2);

				}
				if (result) {
					System.out.println("Applications submitted");
				} else {
					System.out.println("Something went wrong, try again later.");
				}
				// make withdraw
			} else if (choice == 3) {

				Utility.withdraw();
				// make deposits
			} else if (choice == 4) {
				Utility.deposit();

				// Transfer
			} else if (choice == 5) {

				ArrayList<Account> theirAccounts = services.getAccounts(currentUser.getAccountId());
				if (theirAccounts.size() <= 1) {
					System.out.println("You need more then 1 account to transfer");
				} else {
					Utility.transfer();
				}
				// create the joint account request
			} else if (choice == 6) {

				ArrayList<User> users = services.getAllUsers();
				ArrayList<User> jointWith = new ArrayList<User>();
				jointWith.add(currentUser);
				Boolean addMore = true;
				// checks if the joint user requested exists and isn't an employee
				while (addMore) {
					System.out.println("enter email of person you want to create a joint account with.");
					String email = scan.next();
					User check = new User(null, null, email, null);
					int indexOf = -1;
					if (users.contains(check)) {
						indexOf = users.indexOf(check);
						if (jointWith.contains(check)) {

							System.out.println("User already added for joint account");
						} else if (indexOf == -1) {
							System.out.println("user dosnt exsist");
						}

						else {
							jointWith.add(users.get(indexOf));
							System.out.println(jointWith);
							System.out.println("Added: " + users.get(indexOf));
						}
						int input = -1;
						while (input < 0 || input > 2) {
							System.out.println("Add more users to joint account?\n" + "[1] Yes \n[2] No\n");
							input = scannerInt.scanInt();
						}
						if (input != 1) {
							addMore = false;
						}
					} else {
						System.out.println("That user dosn't exsist");
					}
				}
				
				services.batchApplyForAccount(jointWith);
			}
			if (choice != 7) {
				choice = -1;
			}
		}
	}
}
