package com.bank.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bank.accounts.Account;
import com.bank.users.Admin;
import com.bank.users.Associate;
import com.bank.users.Client;
import com.bank.users.User;
import com.bank.views.MenuPrinter;

public class Main {

	public static void main(String[] args) {
		/*
		 * 
		 */

		int option = -1;
		boolean flag;
		//String input;
		String userID;
		String password;

		Map<String, User> allUsers = new HashMap<>();
		Map<String, Account> allAccounts = new HashMap<>();
		User user = null;
		Scanner scanner = new Scanner(System.in);
		
		//System.out.println("1. "+allUsers);
		//DataFileIO.readState(allUsers, allAccounts); 
		allUsers = DataFileIO.readUserState();
		allAccounts = DataFileIO.readAccountState();
		System.out.println(allUsers);
		
//		Admin a = new Admin("root", "root");
//		Associate as = new Associate("Louis", "pass");
//		Client c = new Client("John", "pass");
//		
//		allUsers.put(a.getUserName(), a);
//		allUsers.put(as.getUserName(), as);
//		allUsers.put(c.getUserName(), c);
	
		MenuPrinter.welcome();
		//Main loop
		while(option != 90) {	//90 will be our final exit option
			if (option == -1) {
				MenuPrinter.initial();
				option = getOption(scanner);
				if (option != 1 && option != 2 && option != 90 ) {
					option = -1;
				}
			}
			if (option == 1) { 		//login
				flag = false;
				while (flag == false) {
					System.out.println("Please enter your user name.");
					userID = getInput(scanner);
					System.out.println("Please enter your password.");
					password = getInput(scanner);
					if (allUsers.get(userID) != null) {
						//System.out.println("found user: "+allUsers.get(userID).getUserName());
						user = allUsers.get(userID);
						flag = true;
						option = -2;
						//add passord check
					}else {
						System.out.println("User name not found");
					}
				}
			}else if(option == 2) {	//register
				flag = false;
				while (flag == false) {
					System.out.println("Please enter a user name.");
					userID = getInput(scanner);
					System.out.println("Please enter a password.");
					password = getInput(scanner);
					if (allUsers.get(userID) != null) {
						System.out.println("User already exists");
					}else {
						user = new Client(userID, password);
						allUsers.put(user.getUserName(), user);
						flag = true;
						//go to home screen
					}
				}
			}
			
			if (user instanceof Client) {
				MenuPrinter.clientMenu();
				option = getOption(scanner);
				if (option < 1 && option > 3 && option != 90 ) {
					option = -2;
				} else {
					if (option == 1) {			//create account
						MenuPrinter.openAccount();
						option = getOption(scanner);
						if (option == 1) {			//person account
							System.out.println("create personal");
							option = -2;
						} else if (option == 2) { 	//joint account
							System.out.println("create personal");
							option = -2;
						} else if (option == 80) {
							option = -2;
						}
					} else if (option == 2) {	//view accounts
						
					} else if (option == 3) {	//view personal info
						
					}
				}
			} else if (user instanceof Associate) {
				MenuPrinter.associateMenu();
				option = getOption(scanner);
				if (option < 1 && option > 3 && option != 90 ) {
					option = -2;
				} else {
					if (option == 1) {			//View All Accounts
						
					} else if (option == 2) {	//Approve/Deny Accounts
						
					} else if (option == 3) {	//View Customer Information
						
					}
				}
			} else if (user instanceof Admin) {
				MenuPrinter.adminMenu();
				option = getOption(scanner);
				if (option < 1 && option > 6 && option != 90 ) {
					option = -2;
				} else {
					if (option == 1) {			//Create an Account
						
					} else if (option == 2) {	//View All Accounts
						
					} else if (option == 3) {	//Approve/Deny Accounts
						
					} else if (option == 4) {	//Cancel Account
						
					} else if (option == 5) {	//View Customer Information
						
					} else if (option == 6) {	//Create User
						
					}
				}
			}
		}
		//System.out.println("3. "+allUsers);
		DataFileIO.writeState(allUsers, allAccounts);
		//System.out.println("4. "+allUsers);
		
		System.out.println("Good Bye");
	}

	public static int getOption(Scanner scanner) {
		int option = 0;
		String input;
		
		while(option != -1) {
			input = scanner.nextLine(); 
			try {	//Catch bad input
				option = Integer.parseInt(input);
				return option;
			}catch(NumberFormatException e) {
				System.out.println("Please enter a number.");
			}
		}
		return option;
	}
	
	public static String getInput(Scanner scanner) {
		return scanner.nextLine(); 
	}

}
