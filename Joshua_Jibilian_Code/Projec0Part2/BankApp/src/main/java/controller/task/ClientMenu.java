package controller.task;

import java.util.ArrayList;
import java.util.Scanner;

import controller.main.RunApp;
import controller.services.UserService;
import controller.services.UserServicesImpl;
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
		UserService services = new UserServicesImpl();
		CurrentUser user = CurrentUser.getInstance();
		User currentUser = user.getCurrentUser();
		//PotentialAccounts accounts = PotentialAccounts.getInstance();
		//System.out.println("loading this properly? " + accounts);
		int choice = -1;
		while (choice != 7) {
			choice = ClientOptions.showClientOptions();
			if (choice == 1) { // view personal info
				System.out.println(currentUser);
				for (Account x : user.getCurrentUser().getAccounts()) {
					System.out.println(x);
				}
			} else if (choice == 2) {// apply for account
				User applying = new User(currentUser.getFirstName(), currentUser.getLastName(),currentUser.getEmail(), null,
						currentUser.getAccountId());
				Account newAccount = null;
				System.out.println("What type of account do you want?\n[1] "
						+ "Savings\n [2]Checking");
				int accountChoice = scan.nextInt();
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
				if(result) {
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
				User check = new User(null, null, email, null);
				AllUsers allOfThem = AllUsers.getInstance();
				ArrayList<User> theActualUsers = allOfThem.getUsers();
				Boolean result = false;
				//checks if the joint user requested exists and isn't an employee
				if (theActualUsers.contains(check)) {
					int indexOf = theActualUsers.indexOf(check);
					if(theActualUsers.get(indexOf) instanceof Employee) {
						System.out.println("That user dosn't exsist");
					} else {
						//creation and addition of the joint account object into request table
						User toAdd = new User(currentUser.getFirstName(),
								currentUser.getLastName(), currentUser.getEmail(), null);
						result = services.applyForAccount(currentUser.getAccountId(), 3);
						//jC.addUser(currentUser);
						//System.out.println("CU " + currentUser);
						//jC.addUser(check);
						//System.out.println("Check"+ check);
						//System.out.println("UWITN" + jC.getUsersWith());
						//toAdd.getAccounts().add(jC);
						//accounts.addUser(toAdd);
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
