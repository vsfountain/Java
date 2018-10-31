package com.app.account;

import java.util.Scanner;

import com.app.main.Main;
import com.app.main.ScannerSingleton;

public class Login {

	private boolean loggedIn;
	private Account account;

	public Login() {
		// check if credentials are the same from the file!
		attemptLogin();
		
	}
	
	public Login(String username, String password) {
		checkCredentials(username, password);
		if(loggedIn) {
			chooseAction();
		}
	}

	public void chooseAction() {
		boolean running = true;

		while (running) {
			System.out.println("[A] Withdraw [B] Deposit [C] Transfer [X] Exit");
			String temp = ScannerSingleton.instance().next().toUpperCase();

			switch (temp) {
			case "A":
				System.out.println("How much money do you want to withdraw? Your balance is currently: " + account.getBalance());
				double temp2 = ScannerSingleton.instance().nextDouble();
				
				account.withdraw(temp2);
				// withdraw
				break;
			case "B":
				System.out.println("How much money do you want do you want to deposit? Your balance is currently: " + account.getBalance());
				temp2 = ScannerSingleton.instance().nextDouble();
				
				account.deposit(temp2);
				// deposit
				break;
			case "C":
				System.out.println("How much money do you want do you want to transfer? Your balance is currently: " + account.getBalance());
				double moneyTemp = ScannerSingleton.instance().nextDouble();
				
				System.out.println("Choose account: ");
				System.out.println(AccountList.getInstance().accountList); // change how it looks
				int accountTemp = ScannerSingleton.instance().nextInt() - 1;
				account.transfer(AccountList.getInstance().accountList.get(accountTemp), moneyTemp, true);
				System.out.println("Your account is at: " + account.printBalance());
				System.out.println("The account you transfered to has: " + AccountList.getInstance().accountList.get(accountTemp).getBalance());
				// transfer
				break;
			case "X":
				Main.exitApplication();
				running = false;
				break;
			default:
				chooseAction();
			}
		}
	}

	public void checkCredentials(String username, String password) {
		//System.out.println(AccountList.getInstance().accountList);
		for (Account account : AccountList.getInstance().accountList) {
			System.out.println(account);
			for (Customer customers : account.getCustomers()) {
				System.out.println(customers);
				if (customers.getUsername().equals(username) && customers.getPassword().equals(password)) {
					loggedIn = true;
					this.account = account;
					break;
				}
			}
		}
		if (!loggedIn) {
			System.out.println("You have entered the wrong username and password. Please try again!");

			trySwitch();
		}
	}

	public void trySwitch() {
		System.out.println("[A] Try Again [B] Back");

		String temp = ScannerSingleton.instance().next().toUpperCase();
		switch (temp) {
		case "A":
			attemptLogin();
			break;
		case "B":
			Main.start();
			break;
		default:
			trySwitch();
		}
	}

	public void attemptLogin() {
		System.out.println("Enter your username: ");
		String username = ScannerSingleton.instance().next();

		System.out.println("Enter your password: ");
		String password = ScannerSingleton.instance().next();

		checkCredentials(username, password);
		
		if (loggedIn) {
			chooseAction();
		}

	}
}
