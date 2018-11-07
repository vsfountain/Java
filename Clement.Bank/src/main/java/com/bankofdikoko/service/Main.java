package com.bankofdikoko.service;

import java.util.Scanner;

import com.bankofdikoko.dao.AccountDao;
import com.bankofdikoko.dao.UserDao;
import com.bankofdikoko.model.Account;
import com.bankofdikoko.model.User;

/*To run my project, please register first and then log in to attempt the functionality that users have to view, edit accounts
 * As of right now my project only remembers the information of the obj that is created when registering a user and forgets
 * that object once another user is registered or once the program is closed.
 * */

public class Main {
	public static Scanner in = new Scanner(System.in);
	public static User obj;
	public static UserDao ud = new UserDao();
	public static Account a = new Account();
	public static AccountDao ad = new AccountDao();

	public static void main(String[] args) {
		try {
			displayMenu();
		} catch (NullPointerException e) {
			displayMenu();
		} catch (ArrayIndexOutOfBoundsException s) {
			displayMenu();
		}

	}

	// Menu logic
	static void displayMenu() {
		System.out.println("Welcome to the Bank of Dikoko App!");
		System.out.println("We accept all applicants with a credit score above 500");
		System.out.println("To open an account, a minimum deposit of $100 is required.");
		System.out.println("Please select one of the following Options: ");
		obj = new User();
		// Initialize new User Obj

		String response = "";

		// Establish terminating condition
		while (!response.equals("3")) {
			System.out.println("[1]Register\n[2]Log in\n[3]Exit");
			response = in.next();
			// if they say register
			if (response.equals("1")) {
				// obj = new User();
				// self explanatory
				System.out.println("Create username");
				String username = in.next();

				// self explanatory
				obj.setUserName(username);

				// Database method to check if username exists within the database
				if (!ud.checkUserExists(username)) {
					continue;
				}

				System.out.println("You entered: " + obj.getUserName());

				System.out.println("Create password: ");
				String password = in.next();

				if (password.length() <= 10)
					obj.setPassword(password);

				System.out.println("Enter first name: ");
				String firstN = in.next();
				obj.setFirstName(firstN);

				System.out.println("Enter last name: ");
				String lastN = in.next();
				obj.setLastName(lastN);

				System.out.println("Enter Email address associated with the account: ");
				String email = in.next();
				obj.setEmailAddress(email);

				System.out.println("To apply for an account there is a required credit check. "
						+ "\nPlease enter your credit Score: ");
				int score = in.nextInt();

				if (score < 500) {
					System.out.println(
							"We are sorry to inform you, but your application has not been approved.\nWe highly recommend you apply for the Bank of Dikoko for people that are trying to improve their credit.\n"
									+ " They accept all applicants. Our founder is still undergoing their program.\n\n\n\n");
					continue;
				}

				if (score >= 500) {
					System.out.println("Please enter deposit amount: ");
					int deposit = in.nextInt();
					if (deposit < 100) {
						System.out.println("ERROR: please deposit $100 or more.");
						continue;
					}
					ad.registerAccount(username, deposit);
					System.out.println("Welcome " + firstN + " "+ lastN
							+ "\nYour account has been created!\nPassword has been set: " + obj.getPassword());
					System.out.println("Returning to main menu");

					a.setCustomerName(obj.getFirstName());
					String p_name = obj.getUserName();
					System.out.println(p_name);

					ud.registerUser(obj.getUserName(), obj.getPassword(), obj.getFirstName(), obj.getLastName(),
							obj.getEmailAddress());
					continue;
				}
			}

			if (response.equals("2")) {
				System.out.println("Enter username: ");
				String username = in.next();
				System.out.println("Enter password: ");
				String password = in.next();
				if (username.equals("BankAdmin")) {

					if (ud.checkCredentials("BankAdmin", "1234")) {
						String exit = "1";
						while (exit.equals("1")) {
							System.out.println(
						  "Welcome Back Mr. Dikoko\nHere are the options for you today: \n1. View All Existing Accounts \n2. Edit Existing Accounts \n3.Return to main menu.\n Please select one of those options: 1/2 or 3 to exit");
							String b = in.next();
							if (b.equals("1")) {
								ad.viewAccounts();
								continue;
							} else if (b.equals("2")) {
								System.out.println("Please select the account you would like to edit: ");
								String edit = in.next();
								System.out.println("[1] View Balance\n[2] Deposit Money"
										+ " \n[3] Withdraw Money \n[4] Close account\n[5]Exit");
								String adminchoice = in.next();
								if (adminchoice.equals("1")) {
									if(ud.checkUserExists(in.next()))System.out.println(ad.checkBalance(edit));
									continue;
								}
								if (adminchoice.equals("2")) {
									System.out.println(
											"Please enter how much you would like to deposit into this account: ");
									int transaction = in.nextInt();
									
									int balance = ad.checkBalance(edit);
									int newBal = balance + transaction;;
									ad.updateBalance(newBal, edit);
									continue;
								}
								if (adminchoice.equals("3")) {
									System.out.println(
											"Please enter how much you would like to withdraw from this account: ");
									int transaction = in.nextInt();
									int balance = ad.checkBalance(edit);
									int newBal = balance - transaction;;
									ad.updateBalance(newBal, edit);
									continue;
								}
								if (adminchoice.equals("4")) {
									int bal = ad.checkBalance(edit);
									int bal2 = ad.checkBalance("BankAdmin");
									ad.updateBalance(bal2, "BankAdmin");
									ad.updateBalance(0, edit);
									ad.removeAccount(edit);
									ud.removeUser(edit);
									continue;
								}
								if (adminchoice.equals("5")) {
									exit = "2";
								}

							}else if(b.equals("3")) {
								exit = "3";
								System.out.println(exit);
							}
						}
					}continue;
				}
				if (obj == null) {
					System.out.println("We are unable to find the account associated with that username.");
					break;
				}
				if (ud.checkCredentials(username, password) && !username.equals("BankAdmin")) {
					System.out.println("Login Successful");
					String choice = "";
					while (!choice.equals("6")) {
						System.out.println(
								"[1] View Balance\n[2] Deposit Money \n[3] Withdraw Money\n[4]Transfer \n[5] Close account\n[6]Exit");
						choice = in.next();
						if (choice.equals("1")) {
							int currentBalance = ad.checkBalance(username);
							a.setBalance(currentBalance);
							System.out.println("Your current balance is: $" + currentBalance);
						} else if (choice.equals("2")) {
							System.out.println("Enter Deposit Amount");
							int deposit = in.nextInt();
							a.deposit(deposit);
							ad.updateBalance(a.getBalance(), username);
							System.out.println(
									"You deposited $" + deposit + "\n Your new balance is: $" + a.getBalance());

							continue;
						} else if (choice.equals("3")) {
							System.out.println("How much would you like to withdraw?");
							int withdraw = in.nextInt();
							a.withdraw(withdraw);
							ad.updateBalance(a.getBalance(), username);
							System.out.println(
									"You withdrew $" + withdraw + "\nYour new balance is: $" + a.getBalance());
							continue;

						} else if (choice.equals("4")) {
							System.out.println(
						   "Please select the name of the account you would like to transfer funds to: ");
							String accountTo = in.next();
							System.out.println("Please enter transfer amount: ");
							int transfer = in.nextInt();
							int toBalance = ad.checkBalance(accountTo);
							Account toAccount = new Account();
							toAccount.setBalance(toBalance);
							a.withdraw(transfer);
							toAccount.deposit(transfer);
							int newToAccountBalance = toAccount.getBalance();
							int newBalance = a.getBalance();
							ad.updateBalance(newBalance, username);
							ad.updateBalance(newToAccountBalance, accountTo);
						} else if (choice.equals("5")) {
							System.out.println("Closing account.....");
							ud.removeUser(username);
							ad.removeAccount(username);
							choice = "6";
							break;
						} else
							choice = "6";

					}
				} else
					System.out.println("Login Unsucessful: Invalid username or password");

			}
		}
		System.out.println("Now exiting application.");
		System.exit(0);

	}
}
