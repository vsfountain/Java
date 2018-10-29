package controller.task;

import java.util.ArrayList;
import java.util.Scanner;

import controller.main.RunApp;
import model.accounts.Account;
import model.users.CurrentUser;
import model.users.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Utility.
 */
public class Utility {
	
	/**
	 * This is strictly the transfer method that clients can call.
	 */
	static void transfer() {
		
		CurrentUser user = CurrentUser.getInstance();
		User currentUser = user.getCurrentUser();
		Utility.Transfer(currentUser);
		
	}
	
	/**
	 * Transfers money from one accout to the other for the user. Asks for all input here
	 *
	 * @param currentUser the user that wants a transfer
	 */
	static void Transfer(User currentUser) {
		System.out.println("Select account to transfer from: ");
		Account from = null;
		Account to = null;
		ArrayList<Account> theirAccounts = currentUser.getAccounts();
		//creating a shallow copy, remove selected accounts without affecting users information
		ArrayList<Account> copy = new ArrayList<Account>();
		Scanner scan = RunApp.scan;
		for (Account x : theirAccounts) {
			copy.add(x);
		}
		int selection = 1;
		//select first account
		for (Account x : copy) {
			System.out.println("[" + selection + "]" + x);
			selection += 1;
		}
		
		int account1Selection = scan.nextInt();
		if (account1Selection > 0 && account1Selection < selection) {
			System.out.println("Select accout to transfer to");
			//second account selection
			from = copy.remove(account1Selection - 1);
			int selection2 = 1;
			for (Account x : copy) {
				System.out.println("[" + selection2 + "]" + x);
				selection2 += 1;
			}
			int account2Selection = scan.nextInt();
			if (account2Selection > 0 && account2Selection < selection2) {
				to = copy.remove(account2Selection - 1);
				System.out.println("enter ammount");

				int ammount = scan.nextInt();
				if (from.transfer(ammount, to))
					;
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
		Scanner scan = RunApp.scan;
		System.out.println("Select account for Deposit: ");
		ArrayList<Account> theirAccounts = currentUser.getAccounts();
		int selection = 1;
		for (Account x : theirAccounts) {
			System.out.println("[" + selection + "]" + x);
			selection += 1;
		}
		int accountSelection = scan.nextInt();
		System.out.println("enter ammount");
		int ammount = scan.nextInt();
		if (accountSelection > 0 && accountSelection < selection) {
			Account depositTo = theirAccounts.get(accountSelection - 1);

			if (!depositTo.deposit(ammount)) {
				System.out.println("you can not withraw more then what is in the account");
			} else {
				System.out.println("Success");
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
		Scanner scan = RunApp.scan;
		System.out.println("Select account for withdraw: ");
		ArrayList<Account> theirAccounts = currentUser.getAccounts();
		int selection = 1;
		for (Account x : theirAccounts) {
			System.out.println("[" + selection + "]" + x);
			selection += 1;
		}
		//
		int accountSelection = scan.nextInt();
		System.out.println("enter ammount");
		int ammount = scan.nextInt();
		if (accountSelection > 0 && accountSelection < selection) {
			Account withdrawFrom = theirAccounts.get(accountSelection - 1);

			if (!withdrawFrom.withdraw(ammount)) {
				System.out.println("you can not withraw more then what is in the account");
			} else {
				System.out.println("Success");
			}
		} else {
			System.out.println("invalid input");
		}

	}
}
