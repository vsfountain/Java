//Author: Sean Doyle
//Date Created: 2018/10/24

//This class stores the information about the bank account

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Account implements Serializable {
	/**
	 * 
	 */
	static Scanner s = new Scanner(System.in);
	private static final long serialVersionUID = -8409567036769111821L;
	private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";
	private double balance;
	private int myPerson;
	private static int accountCount = 666;
	private int accountNumber;
	private boolean jointly = false;
	private int myJointPerson;
	private ArrayList<Transaction> history = new ArrayList<>();
	private boolean isFrozen = false;

	Account(Client client) {
		// This constructor is for clients filing solo
		this.accountNumber = accountCount++;
		this.balance = 0.0;
		this.myPerson = client.getClientID();
		client.linkAccount(this, EMPLOYEEACCESSCODE);
		history.add(new Transaction(0.0, this.myPerson, false));
	}

	Account(Client client, Client joint) {
		// This constructor is for clients filing jointly
		this.accountNumber = accountCount++;
		this.balance = 0.0;
		this.myPerson = client.getClientID();
		client.linkAccount(this, EMPLOYEEACCESSCODE);
		this.myJointPerson = joint.getClientID();
		joint.linkAccount(this, EMPLOYEEACCESSCODE);
		this.jointly = true;
		history.add(new Transaction(0.0, this.myPerson, this.myJointPerson));
	}

	protected boolean getAccountStatus() {
		return this.isFrozen;
	}

	protected double getAccountBalance() {
		return this.balance;
	}

	protected boolean checkJoint() {
		return this.jointly;
	}

	protected int getJointID() {
		return this.myJointPerson;
	}

	protected void setFreeze(String verify) {
		if (verify.equals(ADMINISTRATORACCESSCODE)) {
			this.isFrozen = true;
		} else {
			System.out.println(
					"Employee, the pass phrase you have enter is incorrect and The account has not been Frozen.");
		}
	}

	private void setThaw(String verify) {
		if (verify.equals(ADMINISTRATORACCESSCODE)) {
			this.isFrozen = false;
		} else {
			System.out.println(
					"Administrator, the pass phrase you have enter is incorrect and The account has not been UnFrozen.");
		}
	}

	protected void toggleFreeze(String verify) {
		if (this.isFrozen) {
			setThaw(verify);
		} else {
			setFreeze(verify);
		}
	}

	private ArrayList<Transaction> getHistory() {
		return this.history;
	}

	protected int getAccountNumber() {
		return this.accountNumber;
	}

	protected boolean deposit(double amount, Client client) {
		if (amount < 0.0) {
			System.out.println("You have entered an invalid amount.");
			history.add(new Transaction(amount, client.getClientID(), "FAIL: Deposit, Invalid Amount"));
			return false;
		}
		if (client.getClientStatus()) {
			System.out.println("Your account is Frozen.");
			history.add(new Transaction(amount, client.getClientID(), "FAIL: Deposit, Account Not-Active"));
		}
		if (verifyID(client)) {
			balance += amount;
			history.add(new Transaction(amount, client.getClientID(), "Success: Deposit"));
			return true;
		} else {
			System.out.println("Invalid Credentials.");
			history.add(new Transaction(amount, client.getClientID(), "FAIL: Deposit, Invalid Credentials"));
			return false;
		}
	}

	protected boolean withdraw(double amount, Client client) {
		if (amount <= 0.0) {
			System.out.println("You have entered an invalid amount.");
			history.add(new Transaction(amount, client.getClientID(), "FAIL: Withdrawl, Invalid Amount"));
			return false;
		}
		if (!client.getClientStatus()) {
			System.out.println("Your account is Frozen.");
			history.add(new Transaction(amount, client.getClientID(), "FAIL: Withdrawl, Account Not-Active"));
		}
		if (verifyID(client)) {
			if (amount > this.balance) {
				System.out.println("You do not have sufficient funds. Your balance is: $" + this.balance);
				history.add(new Transaction(amount, client.getClientID(), "FAIL: Withdrawl, Insufficient Funds"));
				return false;
			}
			balance -= amount;
			history.add(new Transaction(amount, client.getClientID(), "Success: Withdrawl"));
			return true;
		} else {
			System.out.println("Invalid Credentials.");
			history.add(new Transaction(amount, client.getClientID(), "FAIL: Withdrawl, Invalid Credentials"));
			return false;
		}
	}

	private boolean verifyID(Client client) {
		if (client.getClientID() == this.myPerson) {
			return true;
		} else if (jointly && client.getClientID() == this.myJointPerson) {
			return true;
		} else {
			System.out.println("You have entered an invalid Client ID number.");
			return false;
		}
	}

	private String getClientIDString() {
		if (jointly) {
			return "Holder One: " + this.myPerson + "\tJoint Holder: " + this.myJointPerson;
		} else {
			return "Holder: " + this.myPerson;
		}
	}

	private int[] getClientIDs() {
		System.out.println(getClientIDString());
		if (jointly) {
			return new int[] { this.myPerson, this.myJointPerson };
		} else {
			return new int[] { this.myPerson };
		}
	}

	private Account() {
		// this is for BS use
		this.balance = 0.0;
		this.myPerson = -99;
		this.myJointPerson = -98;
		this.jointly = true;
		history.add(new Transaction(0.0, this.myPerson, this.myJointPerson));
	}

	protected void setClientID(String verify, int clientID) {
		if (verify.equals(ADMINISTRATORACCESSCODE)) {
			this.myPerson = clientID;
			System.out.println("SUCCESS: you have change the main client ID.");
		} else {
			System.out.println("FAIL: Invalid ADMIN access code");
		}
	}

	private boolean deposit(Scanner s) {
		System.out.println("Please enter amount to Deposit: $");
		double amount = s.nextDouble();
		if (amount <= 0.0) {
			System.out.println("You have entered an invalid amount.");
			history.add(new Transaction(amount, -256, "FAIL: Deposit, Invalid Amount"));
			return false;
		}
		this.balance += amount;
		System.out.println("Success! New Balance is: $" + this.balance);
		history.add(new Transaction(amount, -256, "SUCCESS: Deposit"));
		return true;
	}

	private boolean withdrawl(Scanner s) {
		System.out.println("Please enter amount to withdraw: $");
		double amount = s.nextDouble();
		if (amount <= 0.0) {
			System.out.println("You have entered an invalid amount.");
			history.add(new Transaction(amount, -256, "FAIL: Withdrawl, Invalid Amount"));
			return false;
		}
		if (amount > this.balance) {
			System.out.println("Insufficient funds. Balance is: $" + this.balance);
			history.add(new Transaction(amount, -256, "FAIL: Withdrawl, Insufficient Funds"));
			return false;
		} else {
			balance -= amount;
			System.out.println("Success. New Balance is: $" + this.balance);
			history.add(new Transaction(amount, -256, "Success: Withdrawl"));
			return true;
		}
	}

	private boolean transfer(Account account, boolean intoThis) {
		return false;
	}

	protected void mutateBalance(Scanner s) {
		System.out.println("Please choose from the list of options below:");
		System.out.println("A: Deposit Funds.\nB: Withdraw Funds.\nC: Transfer Funds.\nD: CANCEL TRANSACTION");
		switch (s.next().toLowerCase().substring(0, 1)) {
		case "a":
			deposit(s);
			mutateBalance(s);
			break;
		case "b":
			withdrawl(s);
			mutateBalance(s);
			break;
		case "c":
			transfer(new Account(), true);// IDK how to do atm
			mutateBalance(s);
			break;
		case "d":
			break;
		default:
			System.out.println("Please enter valid option.");
			mutateBalance(s);
		}
	}

	private void setAccountNumber(int newAccNum) {
		this.accountNumber = newAccNum;// THIS IS A TERRIBLE IDEA BTW
	}

	private boolean addJointHolder(Scanner s, ArrayList<Client> clients) {
		if (!this.jointly) {
			System.out.println("Do you wish to add an existing client to this account? (Y/N)");
			if (s.next().toLowerCase().substring(0, 1).equals("y")) {
				System.out.println("Enter the client ID of the client to join with this account: ");
				int clientID = s.nextInt();
				Client temp = null;
				for (Client c : clients) {
					if (c.getClientID() == clientID) {
						temp = c;
						break;
					}
				}
				if (temp != null) {
					if (temp.getClientAccount() == -1) {
						this.myJointPerson = temp.getClientID();
						this.jointly = true;
						System.out.println("SUCCESS: client added as joint holder");
						return true;
					} else {
						System.out.println("FAIL: client already has an account");
						return false;
					}
				} else {
					System.out.println("FAIL: Invalid client ID");
					return false;
				}
			} else {
				System.out.println("Follow the below steps to add a NEW Joint Holder");
				Client.clientCreator(clients);
				System.out.println("SUCCESS: new client added as joint holder");
				return true;
			}
		} else {
			System.out.println("FAIL: Joint user already exists, CANNOT modify");// Will fix for Part 1
			return false;
		}
	}

	protected static void accountEditor(ArrayList<Account> accounts, String verify, ArrayList<Client> clients, int accountNum) {
		if (EMPLOYEEACCESSCODE.equals(verify) || ADMINISTRATORACCESSCODE.equals(verify)) {
			Account account = accounts.get(accountNum);
			s.reset();
			int index = 0;
			boolean toClose = false;
			UncleJesse:
			while (!toClose) {
				System.out.println("Please choose from the list of options below:");
				System.out.println("A: Edit client ID(s).    \nB: Edit account Balance. ");
				System.out.println("C: Edit account number.     \nD: Add Joint Client. ");
				System.out.println("E: Get Transaction History.    \nF: Check/Edit frozen status.    \nG: CANCEL");
				switch (s.next().toLowerCase().substring(0, 1)) {
				case "a":
					int[] ids = account.getClientIDs();
					System.out.println("Choose which client ID to modify: ");
					index = s.nextInt();
					if (index == ids[0] || (ids.length > 1 && ids.length > 1 && index == ids[1])) {
						toClose = true;
					} else {
						System.out.println("Invalid client ID");
					}
					break;
				case "b":
					account.mutateBalance(s);
					break;
				case "c":
					System.out.println("Account number is: " + account.getAccountNumber());
					if (ADMINISTRATORACCESSCODE.equals(verify)) {
						System.out.println("Please enter new account number: ");
						account.setAccountNumber(s.nextInt());
					}
					System.out.println(
							"Account numbers can only be changed with ADMIN privlidges, please login again as an ADMIN.");
					break;
				case "d":
					account.addJointHolder(s, clients);
					break;
				case "e":
					System.out.println("Transaction History: \n" + account.getHistory());
					break;
				case "f":
					// Frozen Account = Cancelled Account
					System.out.println(account.getAccountStatus());
					System.out.println("Would you like to change Cancelled Status? (Y/N)");
					if (s.next().toLowerCase().substring(0, 1).equals("y")) {
						account.toggleFreeze(verify);
					}
					break;
				case "g":
					toClose = true;
					
					break UncleJesse;
				default:
					System.out.println("Invalid selection");
				}	
			}
		} else {
			System.out.println("ACCESS DENIED: Invalid Employee / Admin Code");
		}
	}

	@Override
	public String toString() {
		return "\nAccount [balance=" + balance + ", myPerson=" + myPerson + ", accountNumber=" + accountNumber
				+ ", jointly=" + jointly + ", myJointPerson=" + myJointPerson + ", history=" + history + ", isFrozen="
				+ isFrozen + "]";
	}

}
