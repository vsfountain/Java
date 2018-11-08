package com.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.profiles.Account;
import com.profiles.Client;
import com.profiles.Transaction;

public class ClientServiceImplementation implements ClientService {
	Scanner s = new Scanner(System.in);
	BankService bserv = new BankServiceImplementation();
	AccountService aserv = new AccountServiceImplementation();
	private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";

	@Override
	// This Works
	public String clientCreator() {
		s.reset();
		String firstName, lastName;
		boolean correct = false;
		System.out.println("Account Holder, please enter your information: ");
		do {
			System.out.println("Enter Your Given/First Name: ");
			firstName = s.next();
			System.out.println("Enter Your Family/Last Name: ");
			lastName = s.next();
			System.out.println("We have your information as: \nGiven/First Name: " + firstName + "\nFamily/Last Name: "
					+ lastName + "\nIs this information correct? (Y/N)");
			if (s.next().toLowerCase().substring(0, 1).equals("y")) {
				correct = true;
			}
		} while (!correct);
		Client temp = new Client(firstName, lastName);
		if (changeClientPassword(temp, "Giant_Jenga")) {
			System.out.println("A bank employee will review your Application forthwith.\n\n");
		} else {
			System.out.println(
					"Sorry we are unable to set your account pass phrase at this time. \nA bank employee will contact you ASAP to finish setting up your account.");
		}
		bserv.storeClient(temp);
		return "loginScreen";
	}

	@Override
	// This Works
	public String clientLogin() {
		s.reset();
		String first, last, custPass;
		System.out.println("Please enter your given/first name");
		first = s.next();
		System.out.println("Please enter your family/last name");
		last = s.next();
		System.out.println("What is your Password?");
		custPass = s.next();
		System.out.println("We have your information as: \nFrist: " + first + "\nLast: " + last + "\nPassword: ******");
		Client client = bserv.checkClientLogin(first, last, custPass);
		Account account;
		if (client != null) {
			System.out.println("Customer Information Accepted.");
			if (client.getClientStatus()) {
				account = bserv.lookUpAccount(client.getClientAccount());
				if (account != null) {
					if (!account.getAccountStatus()) {
						canBank(client, account);
					} else {
						System.out.println("Sorry your account is frozen, no modifications can be made at this time.");
					}
				} else {
					System.out.println("Sorry no account has been found.");
				}
			} else {
				System.out.println("Sorry you do not yet have privlidges at Ryker.");
			}
		} else {
			System.out.println("Invalid login credentials, match not found in customer records.");
		}
		return "loginScreen";
	}// END CLIENTLOGIN

	@Override
	// This Works
	public void canBank(Client c, Account a) {
		s.reset();
		boolean doMore = true;
		while (doMore) {
			System.out.println("\n\nYour account balance is: " + a.getAccountBalance());
			System.out.println("Please choose from the list of options below:");
			System.out.println("A: Deposit funds.    \nB: Withdraw funds.   \nC: Transfer funds.");
			System.out.println("D: Add another client to my account.  \nE: Change Name");
			System.out.println("F: Change Pass Phrase   \nG: CANCEL");
			switch (s.next().toLowerCase().substring(0, 1)) {
			case "a":
				bserv.deposit(c, a);
				break;
			case "b":
				bserv.withdraw(c, a);
				break;
			case "c":
				ArrayList<Integer> anums = bserv.getAccountNums();
				if (anums.size() <= 1) {
					System.out.println("Sorry there are no other accounts at Ryker at this moment. \nPlease convince your friends to bank with us.\n\n");
					break;
				}
				System.out.println("Please choose an account number listed below:");
				System.out.println(anums.toString());
				int choice = Integer.parseInt(s.next());
				Account acc;
				if (anums.contains((Integer)choice)) {
					acc = bserv.lookUpAccount(choice);
					aserv.transfer(c, a, acc);
					bserv.updateAccount(acc);
				} else {
					System.out.println("Invalid account number.");
				}
				break;
			case "d":
				System.out.println("Redirecting you to link Account...");
				linkAccount(c, a);
				bserv.updateClient(c);
				bserv.updateAccount(a);
				break;
			case "e":
				System.out.println("Redirecting you to change Name...");
				mutateName(c);
				bserv.updateClient(c);
				break;
			case "f":
				System.out.println("Are you sure you wish to change your password? (Y/N)");
				if (s.next().toLowerCase().substring(0, 1).equals("y")) {
					System.out.println("Please enter your Pass Phrase now: ");
					changeClientPassword(c, s.next());
				}
				bserv.updateClient(c);
				break;
			case "g":
				doMore = false;
				break;
			default:
				System.out.println("Please enter a valid selection.");
			}
		} // END WHILE LOOP

	}

	@Override
	// This Works
	public boolean changeClientPassword(Client c, String verify) {

		if (verify.equals(c.getPassword()) || EMPLOYEEACCESSCODE.equals(verify)
				|| ADMINISTRATORACCESSCODE.equals(verify)) {
			s.reset();
			String pass, passVerify;
			boolean correct = false;
			do {
				System.out.println("Enter a pass phrase (NO SPACES): ");
				pass = s.next();
				s.reset();
				System.out.println("Please re-enter pass phrase: ");
				passVerify = s.next();
				if (pass.equals(passVerify)) {
					correct = true;
					c.changePassword(passVerify);
					System.out.println("SUCCESS: the password has been saved.");
				} else {
					System.out.println("Sorry the two pass phrases do not match.");
				}
			} while (!correct);

			return true;
		} else {
			System.out.println("FAIL: Invalid challenge password");
			return false;
		}
	}

	@Override
	// works
	public boolean linkAccount(Client c, Account a) {
		if (a.getAccountStatus()) {
			a.addHistory(new Transaction(-5, c.getClientID(), a.getAccountNumber(),
					"FAIL:Add Co-signator, account is frozen."));
			return false;
		}
		System.out.println("Please have Co-signator enter their credentials now: ");
		s.reset();
		String first, last, custPass;
		System.out.println("Please enter your given/first name");
		first = s.next();
		System.out.println("Please enter your family/last name");
		last = s.next();
		System.out.println("What is your Password?");
		custPass = s.next();
		System.out.println("We have your information as: \nFrist: " + first + "\nLast: " + last + "\nPassword: ******");
		Client client = bserv.checkClientLogin(first, last, custPass);
		if (client != null) {
			if (client.getClientStatus()) {
				if (client.getClientAccount() != c.getClientAccount()) {
					client.addAccount(a.getAccountNumber());
					a.addCoSignator(client.getClientID());
					bserv.updateClient(client);
					bserv.updateAccount(a);
					a.addHistory(new Transaction(-5, c.getClientID(), a.getAccountNumber(),
							"Success:Add Co-signator: " + client.getClientID()));
					return true;
				} else {
					//THIS WILL BE MADE INACTIVE
					System.out.println(
							"Unsuccessful. Client is already a Co-signator on account " + c.getClientAccount());
					a.addHistory(new Transaction(-5, c.getClientID(), a.getAccountNumber(),
							"FAIL:Add Co-signator, account is already linked: " + client.getClientID()));
					return false;
				}
			} else {
				System.out.println("Unsuccessful. Client does NOT have privlidges.");
				a.addHistory(new Transaction(-9, c.getClientID(), a.getAccountNumber(),
						"FAIL:Add Co-signator, client not active: " + client.getClientID()));
				return false;
			}
		} else {
			System.out.println("Invalid client credentials.");
			a.addHistory(new Transaction(-5, c.getClientID(), a.getAccountNumber(),
					"FAIL:Add Co-signator, invalid co-signator credentials: " + first + " " + last + " " + custPass));
			return false;
		}
	}

	@Override
	public void mutateName(Client c) {
		System.out.println("Do you want to change the given/first name? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			String firstName;
			boolean correct = false;
			do {
				System.out.println("Enter the Given/First Name: ");
				firstName = s.next();
				System.out.println(
						"We have the given/first name as: " + firstName + "\nIs this information correct? (Y/N)");
				if (s.next().toLowerCase().substring(0, 1).equals("y")) {
					correct = true;
				}
			} while (!correct);
			c.setClientFirstName(firstName);
		} else {
		}

		System.out.println("Do you want to change the family/last name? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			String lastName;
			boolean correct = false;
			do {
				System.out.println("Enter the Family/Last Name: ");
				lastName = s.next();
				System.out.println(
						"We have the family/last name as: " + lastName + "\nIs this information correct? (Y/N)");
				if (s.next().toLowerCase().substring(0, 1).equals("y")) {
					correct = true;
				}
			} while (!correct);
			c.setClientLastName(lastName);
		} else {
		}
	}// END MUTATENAME
}
