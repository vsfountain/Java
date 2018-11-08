package com.service;

import java.util.ArrayList;

import com.profiles.Account;
import com.profiles.Client;

public interface EmployeeService {

	public void doWork(String verify);

	public void viewAllClients(ArrayList<Client> clients);

	public void viewPendingClients(ArrayList<Client> clients);

	public void approveSinglePending(Client client, ArrayList<Account> accounts, ArrayList<Client> clients,
			String verify);

	public void approveAllPending(ArrayList<Client> clients, ArrayList<Account> accounts, String verify);

	public void viewAllAccounts(ArrayList<Account> accounts);

	public void viewFrozenAccounts(ArrayList<Account> accounts);
	
	public void mutateName(Client c);
	
	public boolean toggleApproval(Client c, String verify);
	
	public void clientEditor(ArrayList<Account> accounts, String verify, ArrayList<Client> clients, int clientNum);
	
	public void accountEditor(ArrayList<Account> accounts, String verify, ArrayList<Client> clients, int accountNum);

	/*
	 * 
	 * 
	 * 
	 * protected void freezeAccount(Account toFreeze) {
	 * toFreeze.setFreeze(EMPLOYEEACCESSCODE); }
	 * 
	 * protected static void approveSinglePending(Client client, ArrayList<Account>
	 * accounts, ArrayList<Client> clients) { // client.activateAccount(); if
	 * (client.getJointID() == -1 && client.getClientAccount() == -1) {
	 * accounts.add(new Account(client)); } else { if (client.getJointID() != -1 &&
	 * client.getClientAccount() == -1) { accounts.add(new Account(client,
	 * clients.get(client.getJointID()))); } } client.activateAccount();
	 * 
	 * }
	 * 
	 * protected static void approveAllPending(ArrayList<Client> clients,
	 * ArrayList<Account> accounts) { for (Client c : clients) {
	 * approveSinglePending(c, accounts, clients); } }
	 * 
	 * protected static void viewAllClients(ArrayList<Client> clients) { for (Client
	 * c : clients) { System.out.println(c.toString()); } }
	 * 
	 * protected static void viewPendingClients(ArrayList<Client> clients) { for
	 * (Client c : clients) { if (!c.getClientStatus()) {
	 * System.out.println(c.toString()); } } }
	 * 
	 * protected static void viewAllAccounts(ArrayList<Account> accounts) { for
	 * (Account a : accounts) { System.out.println(a.toString()); } }
	 * 
	 * protected static void viewFrozenAccounts(ArrayList<Account> accounts) { for
	 * (Account a : accounts) { if (!a.getAccountStatus()) {
	 * System.out.println(a.toString()); } } }
	 */
}
