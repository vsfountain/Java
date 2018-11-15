package com.service;

import java.util.ArrayList;

import com.profiles.Account;
import com.profiles.Client;

public interface AccountService {
	public boolean deposit(Client c, Account a);

	public boolean withdraw(Client c, Account a);
	
	public boolean transfer(Client c, Account a1, Account a2);
	
	public void mutateBalance(Account a, ArrayList<Account> accounts);
	

	/*
	 * 
	 * 
	 * protected void setClientID(String verify, int clientID) { if
	 * (verify.equals(ADMINISTRATORACCESSCODE)) { this.myPerson = clientID;
	 * System.out.println("SUCCESS: you have change the main client ID."); } else {
	 * System.out.println("FAIL: Invalid ADMIN access code"); } }
	 * 
	 * private boolean transfer(Account account, boolean intoThis) { return false; }
	 * 
	 * protected void mutateBalance(Scanner s) {
	 * System.out.println("Please choose from the list of options below:");
	 * System.out.
	 * println("A: Deposit Funds.\nB: Withdraw Funds.\nC: Transfer Funds.\nD: CANCEL TRANSACTION"
	 * ); switch (s.next().toLowerCase().substring(0, 1)) { case "a": deposit(s);
	 * mutateBalance(s); break; case "b": withdrawl(s); mutateBalance(s); break;
	 * case "c": transfer(new Account(), true);// IDK how to do atm
	 * mutateBalance(s); break; case "d": break; default:
	 * System.out.println("Please enter valid option."); mutateBalance(s); } }
	 * 
	 * private void setAccountNumber(int newAccNum) { this.accountNumber =
	 * newAccNum;// THIS IS A TERRIBLE IDEA BTW }
	 * 
	 * private boolean addJointHolder(Scanner s, ArrayList<Client> clients) { if
	 * (!this.jointly) { System.out.
	 * println("Do you wish to add an existing client to this account? (Y/N)"); if
	 * (s.next().toLowerCase().substring(0, 1).equals("y")) { System.out.
	 * println("Enter the client ID of the client to join with this account: "); int
	 * clientID = s.nextInt(); Client temp = null; for (Client c : clients) { if
	 * (c.getClientID() == clientID) { temp = c; break; } } if (temp != null) { if
	 * (temp.getClientAccount() == -1) { this.myJointPerson = temp.getClientID();
	 * this.jointly = true;
	 * System.out.println("SUCCESS: client added as joint holder");
	 * bserv.addJoint(this, temp); return true; } else {
	 * System.out.println("FAIL: client already has an account"); return false; } }
	 * else { System.out.println("FAIL: Invalid client ID"); return false; } } else
	 * { System.out.println("Follow the below steps to add a NEW Joint Holder");
	 * Client.clientCreator(clients);
	 * System.out.println("SUCCESS: new client added as joint holder"); return true;
	 * } } else {
	 * System.out.println("FAIL: Joint user already exists, CANNOT modify");// Will
	 * fix for Part 1 return false; } }
	 * 
	 * protected static void accountEditor(ArrayList<Account> accounts, String
	 * verify, ArrayList<Client> clients, int accountNum) { if
	 * (EMPLOYEEACCESSCODE.equals(verify) || ADMINISTRATORACCESSCODE.equals(verify))
	 * { Account account = accounts.get(accountNum); s.reset(); int index = 0;
	 * boolean toClose = false; UncleJesse: while (!toClose) {
	 * System.out.println("Please choose from the list of options below:");
	 * System.out.println("A: Edit client ID(s).    \nB: Edit account Balance. ");
	 * System.out.println("C: Edit account number.     \nD: Add Joint Client. ");
	 * System.out.
	 * println("E: Get Transaction History.    \nF: Check/Edit frozen status.    \nG: CANCEL"
	 * ); switch (s.next().toLowerCase().substring(0, 1)) { case "a": int[] ids =
	 * account.getClientIDs();
	 * System.out.println("Choose which client ID to modify: "); index =
	 * s.nextInt(); if (index == ids[0] || (ids.length > 1 && ids.length > 1 &&
	 * index == ids[1])) { toClose = true; } else {
	 * System.out.println("Invalid client ID"); } break; case "b":
	 * account.mutateBalance(s); break; case "c":
	 * System.out.println("Account number is: " + account.getAccountNumber()); if
	 * (ADMINISTRATORACCESSCODE.equals(verify)) {
	 * System.out.println("Please enter new account number: ");
	 * account.setAccountNumber(s.nextInt()); } System.out.println(
	 * "Account numbers can only be changed with ADMIN privlidges, please login again as an ADMIN."
	 * ); break; case "d": account.addJointHolder(s, clients); break; case "e":
	 * System.out.println("Transaction History: \n" + account.getHistory()); break;
	 * case "f": // Frozen Account = Cancelled Account
	 * System.out.println(account.getAccountStatus());
	 * System.out.println("Would you like to change Cancelled Status? (Y/N)"); if
	 * (s.next().toLowerCase().substring(0, 1).equals("y")) {
	 * account.toggleFreeze(verify); } break; case "g": toClose = true;
	 * 
	 * break UncleJesse; default: System.out.println("Invalid selection"); } } }
	 * else { System.out.println("ACCESS DENIED: Invalid Employee / Admin Code"); }
	 * }
	 * 
	 * 
	 * 
	 * protected void setFreeze(String verify) { if
	 * (verify.equals(ADMINISTRATORACCESSCODE)) { this.isFrozen = true; } else {
	 * System.out.println(
	 * "Employee, the pass phrase you have enter is incorrect and The account has not been Frozen."
	 * ); } }
	 * 
	 * private void setThaw(String verify) { if
	 * (verify.equals(ADMINISTRATORACCESSCODE)) { this.isFrozen = false; } else {
	 * System.out.println(
	 * "Administrator, the pass phrase you have enter is incorrect and The account has not been UnFrozen."
	 * ); } }
	 * 
	 * protected void toggleFreeze(String verify) { if (this.isFrozen) {
	 * setThaw(verify); } else { setFreeze(verify); } }
	 * 
	 * }
	 */
}
