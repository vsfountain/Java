package com.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.profiles.Account;
import com.profiles.Client;
import com.profiles.Transaction;

public class AccountServiceImplementation implements AccountService {
	final private static Scanner s = new Scanner(System.in);
	//private static final String EMPLOYEEACCESSCODE = "Snoflake";
	//private static final String ADMINISTRATORACCESSCODE = "Fluffy";

	@Override
	// This Works
	public boolean deposit(Client c, Account a) {
		int id = 0;
		if (c == null) {
			id = -567;
		} else {
			id = c.getClientID();
		}
		System.out.print("Enter the decimal amount to be Deposited: $");
		Double amount = s.nextDouble();
		if (amount < 0.0) {
			System.out.println("You have entered an invalid amount.");
			a.addHistory(new Transaction(amount, id, a.getAccountNumber(), "FAIL: Deposit, Invalid Amount"));
			return false;
		} else {
			System.out.println("Success. Your new balance is: " + a.deposit(amount));
			a.addHistory(new Transaction(amount, id, a.getAccountNumber(), "Success: Deposit"));
			return true;
		}
	}

	@Override
	// This Works
	public boolean withdraw(Client c, Account a) {
		int id = 0;
		if (c == null) {
			id = -567;
		} else {
			id = c.getClientID();
		}
		System.out.print("Enter the decimal amount to withdraw: $");
		Double amount = s.nextDouble();
		if (amount < 0.0) {
			System.out.println("You have entered an invalid amount.");
			a.addHistory(new Transaction(amount, id, a.getAccountNumber(), "FAIL: Withdrawal, Invalid Amount"));
			return false;
		} else if (a.getAccountBalance() >= amount) {
			System.out.println("Success. Your new balance is: " + a.withdraw(amount));
			a.addHistory(new Transaction(amount, id, a.getAccountNumber(), "Success: Deposit"));
			return true;
		} else {
			System.out.println("You do not have sufficient funds for a withdrawl of: $" + amount);
			a.addHistory(new Transaction(amount, id, a.getAccountNumber(), "FAIL: Withdrawal, Insufficient Funds"));
			return false;
		}
	}

	@Override
	public boolean transfer(Client c, Account a1, Account a2) {
		int id = 0;
		if (c == null) {
			id = -567;
		} else {
			id = c.getClientID();
		}
		if (a2 != null) {
			System.out.print("Enter the decimal amount to transfer from account "+a1.getAccountNumber() +" into account "+a2.getAccountNumber()+": $");
			Double amount = s.nextDouble();
			if (amount < 0.0) {
				System.out.println("You have entered an invalid amount.");
				a1.addHistory(new Transaction(amount, id, a1.getAccountNumber(), "FAIL: Transfer, Invalid Amount"));
				a2.addHistory(new Transaction(amount, id, a2.getAccountNumber(), "FAIL: Transfer, Source had Invalid Amount"));
				return false;
			} else if (a1.getAccountBalance() >= amount) {
				System.out.println(
						"Success. Source account " + a1.getAccountNumber() + " balance is: " + a1.withdraw(amount));
				System.out.println(
						"Success. Sink account " + a2.getAccountNumber() + " balance is: " + a2.deposit(amount));
				a1.addHistory(new Transaction(amount, id, a1.getAccountNumber(), "Success: Tranefer-Withdrawl to " + a2.getAccountNumber()));
				a2.addHistory(new Transaction(amount, id, a2.getAccountNumber(), "Success: Transfer-Deposit from " + a1.getAccountNumber()));
				return true;
			} else {
				System.out.println("You account has insufficient funds for a withdrawl of: $" + amount);
				a1.addHistory(new Transaction(amount, id, a1.getAccountNumber(), "FAIL:Transfer, Insufficient Funds"));
				a2.addHistory(new Transaction(amount, id, a2.getAccountNumber(), "FAIL:Transfer, Source account had Insufficient Funds"));
				return false;
			}
		} else {
			a1.addHistory(new Transaction(0.0, id, a1.getAccountNumber(), "FAIL:Transfer, No such Sink account."));
			return false;
		}
	}

	@Override
	public void mutateBalance(Account a, ArrayList<Account> accounts) {
		Maxwell: while (true) {
			System.out.println("Please choose from the list of options below:");
			System.out.println("A: Deposit Funds.\nB: Withdraw Funds.\nC: Transfer Funds.\nD: CANCEL TRANSACTION");
			switch (s.next().toLowerCase().substring(0, 1)) {
			case "a":
				deposit(null, a);
				break;
			case "b":
				withdraw(null, a);
				break;
			case "c":
				System.out.println("Here is a list of all possible accounts: " + accounts.toString());
				System.out.println("Please select an account number to deposit funds into: ");
				int sink = Integer.parseInt(s.next());
				if (sink >= 666 && sink <= accounts.size()+666-1) {
					transfer(null, a, accounts.get(sink - 666));
				} else {
					System.out.println("Fail: invalid account number.");
				}
				break;
			case "d":
				break Maxwell;
			default:
				System.out.println("Please enter valid option.");
			}
		}
	}

}
