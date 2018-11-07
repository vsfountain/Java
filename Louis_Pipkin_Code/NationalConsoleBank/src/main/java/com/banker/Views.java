package com.banker;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.banker.model.accounts.Account;
import com.banker.model.users.User;
import com.banker.service.BankerService;
import com.banker.service.BankerServiceImpl;

public class Views {

	public static int option = -1;
	public static int acc = 0;
	public static int num = 0;
	public static int tmp = 0;
	public static boolean flag;
	// String input;
	public static String userID = "";
	public static String tmpUserID = "";
	public static String password = "";
	public static String type = "";

	public static BankerService service = new BankerServiceImpl();
	public static Map<String, User> allUsers = service.getAllUsers();
	public static ArrayList<Account> accounts = null;
	public static User user = null;
	public static User tmpUser = null;
	// Account account = null;
	public static Scanner scanner = new Scanner(System.in);

	public static int getOption(Scanner scanner) {
		int option = 0;
		String input;

		while (option != -1) {
			input = scanner.nextLine();
			try { // Catch bad input
				option = Integer.parseInt(input);
				return option;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number.");
			}
		}
		return option;
	}

	public static String getInput(Scanner scanner) {
		return scanner.nextLine();
	}

	public static int approveAccounts() {
		option = -1;

		while (option != 80) {
			accounts = service.getUnapprovedAccounts();
			MenuPrinter.viewAllAccounts(accounts);
			MenuPrinter.approveDenyAccount();
			option = getOption(scanner);
			if (option == 1) {
				System.out.println("Select an account to deny");
				option = getOption(scanner);
				if (option >= 0 && option < accounts.size()) {
					// System.out.println("account size: "+accounts.size());
					service.removeAccount(accounts.get(option));
					// accounts.remove(option);
					//accounts = service.getUnapprovedAccounts();
					option = -1;
				}
			} else if (option == 2) {
				System.out.println("Select an account to approve");
				option = getOption(scanner);
				if (option >= 0 && option < accounts.size()) {
					tmp = accounts.get(option).getAccountid();
					// service.approveAccount(accounts.get(option).getAccountid());
					// System.out.println("account id: "+tmp);
					service.approveAccount(tmp);
					//accounts = service.getUnapprovedAccounts();
					option = -1;
				}
			}
		}

		return option;
	}

	public static int clientLoop(User u) {

		MenuPrinter.clientMenu();
		option = getOption(scanner);
		if (option < 1 && option > 2 && option != 90) {
			option = -2;
		} else {
			if (option == 1) { // create account
				MenuPrinter.openAccount();
				option = getOption(scanner);
				if (option == 1) { // personal account
					// System.out.println("create personal");
					service.addAccount(u);
					accounts = (service.getUsersAccounts(u.getUserName()));
					System.out.println(
							"Your account has been submitted.\n" + "Please allow 24 hours for account approval.\n");
					option = -2;
				} else if (option == 2) { // joint account
					// System.out.println("create joint");
					flag = false;
					MenuPrinter.openJointAccount();
					option = getOption(scanner);
					while (flag == false) {
						if (option == 1) { // joint with existing
							System.out.println("Please enter a user name for the existing user.");
							tmpUserID = getInput(scanner);
							System.out.println("Please enter a password for the existing user.");
							password = getInput(scanner);
							if (!service.isUser(tmpUserID)) {
								System.out.println("User not found.");
							} else {
								tmpUser = service.getUser(tmpUserID);
								service.addAccount(u, tmpUser);
								accounts = service.getUsersAccounts(u.getUserName());

								flag = true;
								// option = -2;
							}
						} else if (option == 2) { // joint with new
							System.out.println("Please enter a user name for the new user.");
							tmpUserID = getInput(scanner);
							System.out.println("Please enter a password for the new user.");
							password = getInput(scanner);
							if (allUsers.containsKey(tmpUserID)) {
								System.out.println("User already exists.");
							} else {
								service.addUser(tmpUserID, password, "client");
								tmpUser = service.getUser(tmpUserID);
								service.addAccount(u, tmpUser);
								accounts = service.getUsersAccounts(u.getUserName());
								flag = true;
								// option = -2;
								// go to home screen
							}
						}
					}
					System.out.println(
							"Your account has been submitted.\n" + "Please allow 24 hours for account approval.\n");
					option = -2;
				} else if (option == 80) {
					option = -2;
				}
			} else if (option == 2) { // view accounts
				flag = false;
				while (flag == false) {
					accounts = service.getUsersAccounts(u.getUserName());
					MenuPrinter.viewAccounts(accounts);
					MenuPrinter.accountOptions();
					option = getOption(scanner);
					if (option == 1) { // Withdraw
						System.out.println("Select Account");
						acc = getOption(scanner);
						if (acc >= 0 && acc < accounts.size()) {
							System.out.println("Enter an amount");
							num = getOption(scanner);
							accounts.get(acc).withdrawal(num);
							service.syncAccount(accounts.get(acc));
						}
					} else if (option == 2) { // Deposit
						System.out.println("Select Account");
						acc = getOption(scanner);
						// System.out.println("Enter an amount");
						if (acc >= 0 && acc < accounts.size()) {
							System.out.println("Enter an amount");
							num = getOption(scanner);
							accounts.get(acc).deposit(num);
							service.syncAccount(accounts.get(acc));
						}
					} else if (option == 3) { // Transfer
						System.out.println("Select Account to transfer from");
						acc = getOption(scanner);
						System.out.println("Select Account to transfer to");
						tmp = getOption(scanner);
						if (acc >= 0 && acc < accounts.size() && tmp >= 0 && tmp < accounts.size()) {
							System.out.println("Enter an amount");
							num = getOption(scanner);
							// acc -> tmp
							accounts.get(acc).transfer(num, accounts.get(tmp));
							service.syncAccount(accounts.get(acc));
							service.syncAccount(accounts.get(tmp));
						}
					} else if (option == 80) {
						flag = true;
						option = -2;
					}
				}

			}
		}
		return option;
	}

	public static int associateLoop(User u) {
		MenuPrinter.associateMenu();
		option = getOption(scanner);
		if (option < 1 && option > 3 && option != 90) {
			option = -2;
		} else {
			if (option == 1) { // View All Accounts
				accounts = service.getAllAccounts();
				MenuPrinter.viewAllAccounts(accounts);
				option = -2;
			} else if (option == 2) { // Approve/Deny Accounts
				option = approveAccounts();
			} else if (option == 3) { // View Customer Information
				allUsers = service.getAllUsers();
				MenuPrinter.viewAllUsers(allUsers);
				option = -2;
			}
		}
		return option;
	}

	public static int adminLoop(User u) {

		MenuPrinter.adminMenu();
		option = getOption(scanner);
		if (option < 1 && option > 6 && option != 90) {
			option = -2;
		} else {
			if (option == 1) { // Create an Account
				allUsers = service.getAllUsers();
				MenuPrinter.viewAllUsers(allUsers);
				MenuPrinter.openAccount();
				option = getOption(scanner);
				if (option == 1) { // personal account
					System.out.println("Enter user name");
					// System.out.println("create personal");
					userID = Views.getInput(scanner);
					if (service.isUser(userID)) {
						service.addAccount(service.getUser(userID));
						// accounts = (service.getUsersAccounts(userID));
						option = -2;
					} else {
						System.out.println("Invalid user name");
					}
				} else if (option == 2) { // joint account
					// System.out.println("create joint");
					flag = false;
					MenuPrinter.openJointAccount();
					option = getOption(scanner);
					while (flag == false) {
						if (option == 1) { // joint with existing
							System.out.println("Please enter a user name for an existing user.");
							userID = getInput(scanner);
							System.out.println("Please enter a user name for another existing user.");
							tmpUserID = getInput(scanner);
							if (!service.isUser(userID) || !service.isUser(tmpUserID)) {
								System.out.println("User not found.");
							} else if (userID.equals(tmpUserID)) {
								System.out.println("Invalid input");
							} else {
								// tmpUser = service.getUser(tmpUserID);
								// service.addAccount(user.getUserName(), tmpUser.getUserName());
								service.addAccount(allUsers.get(userID), allUsers.get(tmpUserID));
								// accounts = service.getUsersAccounts(userID);
								flag = true;
								// option = -2;
							}
						} else { // joint with a new user
							System.out.println("Please enter a user name for an existing user.");
							userID = getInput(scanner);
							if (!service.isUser(userID)) {
								System.out.println("User not found.");
							} else {
								System.out.println("Please enter a user name for the new user.");
								tmpUserID = getInput(scanner);
								System.out.println("Please enter a password for the new user.");
								password = getInput(scanner);
								if (allUsers.containsKey(tmpUserID)) {
									System.out.println("User already exists.");
								} else {
								//service.addUser(tmpUserID, password, "client");
								//tmpUser = service.getUser(tmpUserID);
								
								//service.addAccount(u, tmpUser);
								//accounts = service.getUsersAccounts(userID);
								//service.addAccount(allUsers.get(userID), allUsers.get(tmpUserID));
								//flag = true;
								// option = -2;
								// go to home screen
									service.addUser(tmpUserID, password, "client");
									tmpUser = service.getUser(tmpUserID);
									service.addAccount(service.getUser(userID), tmpUser);
									accounts = service.getUsersAccounts(u.getUserName());
									flag = true;
								}
							}
						}
					}
					option = -2;
				} else if (option == 80) {
					option = -2;
				}
			} else if (option == 2) { // View All Accounts
				flag = false;
				while (flag == false) {
					accounts = service.getAllAccounts();
					MenuPrinter.viewAllAccounts(accounts);
					MenuPrinter.accountOptions();
					option = getOption(scanner);
					if (option == 1) { // Withdraw
						System.out.println("Select Account");
						acc = getOption(scanner);
						if (acc >= 0 && acc < accounts.size()) {
							System.out.println("Enter an amount");
							num = getOption(scanner);
							//accounts.get(acc).withdrawal(num);
							accounts.get(acc).withdrawal(num);
							service.syncAccount(accounts.get(acc));
						}
					} else if (option == 2) { // Deposit
						System.out.println("Select Account");
						acc = getOption(scanner);
						//System.out.println("Enter an amount");
						if (acc >= 0 && acc < accounts.size()) {
							System.out.println("Enter an amount");
							num = getOption(scanner);
							//accounts.get(acc).deposit(num);
							accounts.get(acc).deposit(num);
							service.syncAccount(accounts.get(acc));
						}
					} else if (option == 3) { // Transfer
						System.out.println("Select Account to transfer from");
						acc = getOption(scanner);
						System.out.println("Select Account to transfer to");
						tmp = getOption(scanner);
						if (acc >= 0 && acc < accounts.size() && tmp >= 0 && tmp < accounts.size()) {
							System.out.println("Enter an amount");
							num = getOption(scanner);
							//accounts.get(acc).transfer(num, accounts.get(tmp));
							// acc -> tmp
							accounts.get(acc).transfer(num, accounts.get(tmp));
							service.syncAccount(accounts.get(acc));
							service.syncAccount(accounts.get(tmp));
						}
					} else if (option == 80) {
						flag = true;
						option = -2;
					}
				}
			} else if (option == 3) { // Approve/Deny Accounts
				option = approveAccounts();
			} else if (option == 4) { // Cancel Account
				accounts = service.getAllAccounts();
				MenuPrinter.viewAllAccounts(accounts);
				System.out.println("Enter account to cancel.");
				num = getOption(scanner);
				if (num >= 0 && num < accounts.size()) {
					service.removeAccount(accounts.get(num));
				}
				option = -2;
			} else if (option == 5) { // View Customer Information
				allUsers = service.getAllUsers();
				MenuPrinter.viewAllUsers(allUsers);
				option = -2;
			} else if (option == 6) { // Create User
				flag = false;
				while (flag == false) {
					System.out.println("Please enter a user name.");
					userID = Views.getInput(scanner);
					System.out.println("Please enter a password.");
					password = Views.getInput(scanner);
					System.out.println("Please enter the account type (admin, associate, or client).");
					type = Views.getInput(scanner);

					if (service.isUser(userID)) {
						System.out.println("User ID already exists");
					} else {
						service.addUser(userID, password, type);
						// user = service.getUser(userID);
						flag = true;
						option = -2;
						// go to home screen
					}
				}
			}
		}

		return option;
	}
}
