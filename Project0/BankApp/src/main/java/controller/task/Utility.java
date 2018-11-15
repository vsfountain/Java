package controller.task;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.dao.UserDaoImpl;
import controller.dataio.ScannerInt;
import controller.services.UserService;
import controller.services.UserServicesImpl;
import model.accounts.Account;
import model.users.CurrentUser;
import model.users.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Utility.
 */
public class Utility {
	final static Logger logger = LogManager.getLogger(UserDaoImpl.class.getName());
	/**
	 * This is strictly the transfer method that clients can call.
	 */
	static void transfer() {

		CurrentUser user = CurrentUser.getInstance();
		User currentUser = user.getCurrentUser();
		Utility.Transfer(currentUser);

	}

	/**
	 * Transfers money from one accout to the other for the user. Asks for all input
	 * here
	 *
	 * @param currentUser the user that wants a transfer
	 */
	static void Transfer(User currentUser) {
		System.out.println("Select account to transfer from: ");
		Account from = null;
		Account to = null;
		UserService services = new UserServicesImpl();
		ArrayList<Account> theirAccounts = services.getAccounts(currentUser.getAccountId());
		// creating a shallow copy, remove selected accounts without affecting users
		// information
		ArrayList<Account> copy = new ArrayList<Account>();

		for (Account x : theirAccounts) {
			copy.add(x);
		}
		int selection = 1;
		// select first account
		for (Account x : copy) {
			System.out.println("[" + selection + "]" + x);
			selection += 1;
		}

		int account1Selection = ScannerInt.scanInt();
		if (account1Selection > 0 && account1Selection < selection) {
			System.out.println("Select accout to transfer to");
			// second account selection
			from = copy.remove(account1Selection - 1);
			int selection2 = 1;
			for (Account x : copy) {
				System.out.println("[" + selection2 + "]" + x);
				selection2 += 1;
			}
			int account2Selection = ScannerInt.scanInt();
			if (account2Selection > 0 && account2Selection < selection2) {
				to = copy.remove(account2Selection - 1);
				System.out.println("enter ammount");

				int ammount = ScannerInt.scanInt();
				if (services.transfer(from.getId(), to.getId(), ammount)) {
					System.out.println("Succses.");
				} else {
					System.out.println("ammount can not be negative");
				}
					
			} else {
				System.out.println("Invalid input");
			}
		} else {
			System.out.println("invalid input");
		}
	}

	/**
	 * Used to deposit money to current user.
	 */
	public static void deposit() {

		CurrentUser user = CurrentUser.getInstance();
		User currentUser = user.getCurrentUser();
		deposit(currentUser);

	}

	/**
	 * used to deposit money to specified user.
	 *
	 * @param currentUser the current user
	 */
	public static void deposit(User currentUser) {
		
		System.out.println("Select account for Deposit: ");
		UserService services = new UserServicesImpl();
		ArrayList<Account> theirAccounts = services.getAccounts(currentUser.getAccountId());
		int selection = 1;
		for (Account x : theirAccounts) {
			System.out.println("[" + selection + "]" + x);
			selection += 1;
		}
		int accountSelection = ScannerInt.scanInt();
		System.out.println("enter ammount");
		int ammount = ScannerInt.scanInt();
		if (accountSelection > 0 && accountSelection < selection) {
			Account depositTo = theirAccounts.get(accountSelection - 1);

			if (!services.deposit(depositTo.getId(), ammount)) {
				System.out.println("you can not withraw more then what is in the account");
			} else {
				System.out.println("Success");
				logger.info("DEPOSIT: User "+ currentUser.getAccountId()+ " to Account " +
						depositTo.getId() + " deposited " + ammount );
			}
		} else {
			System.out.println("invalid input");
		}
	}

	/**
	 * Used to withdraw money from current user's account.
	 */
	public static void withdraw() {
		CurrentUser user = CurrentUser.getInstance();
		User currentUser = user.getCurrentUser();
		withdraw(currentUser);
	}

	/**
	 * Used to withdraw money from specified users account.
	 *
	 * @param currentUser the current user
	 */
	public static void withdraw(User currentUser) {

		System.out.println("Select account for withdraw: ");
		UserService services = new UserServicesImpl();
		ArrayList<Account> theirAccounts = services.getAccounts(currentUser.getAccountId());
		int selection = 1;
		if (theirAccounts.size() >= 1) {
			for (Account x : theirAccounts) {
				System.out.println("[" + selection + "]" + x);
				selection += 1;
			}
			//
			int accountSelection = ScannerInt.scanInt();
			System.out.println("enter ammount");
			int ammount = ScannerInt.scanInt();
			if (accountSelection > 0 && accountSelection < selection) {
				Account withdrawFrom = theirAccounts.get(accountSelection - 1);

				if (!services.withdraw(withdrawFrom.getId(), ammount)) {
					System.out.println("you can not withraw more then what is in the account");
				} else {
					System.out.println("Success");
					logger.info("WITHDRAW: User "+ currentUser.getAccountId()+ " from Account " +
					withdrawFrom.getId() + " withdrew " + ammount );
				}
			} else {
				System.out.println("invalid input");
			}
		} else {
			System.out.println("You do not have any accounts");
		}

	}
}
