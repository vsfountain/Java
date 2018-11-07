package com.banker;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import com.banker.model.accounts.Account;
import com.banker.model.accounts.Joint;
import com.banker.model.accounts.Personal;
import com.banker.model.users.User;

public class MenuPrinter {
	
	public static void welcome() {
		System.out.println( "*****************************************\n"+
						  	"*                                        *\n"+
						  	"*  Welcome to Pipkin International Bank  *\n"+
						  	"*                                        *\n"+
						  	" *****************************************");
	}
	
	public static void initial() {
		System.out.println("Please select an option\n"+
			  				"*  1. Login\n"+
			  				"*  2. Register\n"+
			  				"* 90. Exit");
	}
	
	public static void openAccount() {
		System.out.println("\nPlease select an option\n"+
  				"*  1. Create a Personal Account\n"+
  				"*  2. Create a Joint Account\n"+
  				"* 80. Back");
	}
	
	public static void openJointAccount() {
		System.out.println("\nPlease select an option\n"+
  				"*  1. Open Account with Existing User\n"+
  				"*  2. Open Account with New User\n"+
  				"* 80. Back");
	}
	
	public static void viewAccounts(ArrayList<Account> accounts) {
		String type = "t?";
		//String owners = "o?";
		for (Account a: accounts) {
			String owners = "";
			if (a instanceof Personal) {
				type = "Personal";
			} else if (a instanceof Joint) {
				type = "Joint";
				owners = a.toString();
			}
			
			System.out.println(accounts.indexOf(a) + ". " + owners + type + ": $" + a.getBalance());
		}
	}
	
	public static void viewAllAccounts(ArrayList<Account> accounts) {
		String type = "t?";
		String owners = "";
		for (Account a: accounts) {
			if (a instanceof Personal) {
				type = "Personal";
				owners = ((Personal) a).getOwner();
			} else if (a instanceof Joint) {
				type = "Joint";
				owners = a.toString();
			}
			
			System.out.println(accounts.indexOf(a) + ". " + owners + ", " + type + ": $" + a.getBalance());
		}
	}
	
	public static void approveDenyAccount() {
		System.out.println("\nPlease select an option\n"+
  				"*  1. Deny an Account\n"+
  				"*  2. Aprove an Account\n"+
  				"* 80. Back");
	}
	
	public static void accountOptions() {
		System.out.println("\nPlease select an option\n"+
  				"*  1. Withdraw from Account\n"+
  				"*  2. Deposit to Account\n"+
  				"*  3. Transfer accross Accounts\n"+
  				"* 80. Back");
	}
	
	
	
	public static void viewAllUsers(Map<String, User> allUsers) {
		for (Entry<String, User> entry : allUsers.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
	
	public static void adminMenu() {
		System.out.println("\nPlease select an option\n"+
  				"*  1. Create an Account\n"+
  				"*  2. View All Accounts\n"+
  				"*  3. Approve/Deny Accounts\n"+
  				"*  4. Cancel Account\n"+
  				"*  5. View User Information\n"+
  				"*  6. Create User\n"+
  				"* 90. Exit");
	}
	
	public static void associateMenu() {
		//view all accounts, view all customer info
		System.out.println("\nPlease select an option\n"+
  				"*  1. View All Accounts\n"+
  				"*  2. Approve/Deny Accounts\n"+
  				"*  3. View Customer Information\n"+
  				"* 90. Exit");
	}
	
	public static void clientMenu() {
		//view accounts, create account, view info, update info
		//transfer, withdraw, deposit
		System.out.println("\nPlease select an option\n"+
  				"*  1. Open an Account\n"+
  				"*  2. View Accounts\n"+
  				//"*  3. View Personal Infomation\n"+
  				"* 90. Exit");
	}

	public static String ownerString(Account a) {
		return "";
	}
}
