package com.service;

import java.util.ArrayList;

import com.profiles.Account;
import com.profiles.Client;
import com.profiles.Transaction;

public interface BankService {
	public ArrayList<Client> repopulateClients();
	public ArrayList<Account> repopulateAccounts();
	
	public int storeClient(Client c);
	public void updateClient(Client c);
	public Client checkClientLogin(String first, String last, String password);
	
	public int storeAccount(Account a);
	public Account getAccount(int accNum);
	public int deposit(Account a);
	public int withdraw(Account a);
	public void updateAccount(Account a);
	public Account lookUpAccount(int accountNumber);
	
	public ArrayList<Integer> getAccountNums();
	
	public int storeTransaction(Transaction t);
	
	
	public boolean deposit(Client c, Account a);
	public boolean withdraw(Client c, Account a);
	public boolean transfer(Client c, Account a);
	
	public ArrayList<Integer> getClients(String p);
	
	public void wipeDB(String verify);
	
	
	//public void accountEditor(ArrayList<Account> accounts, String verify, ArrayList<Client> clients, int index);
	
	//public void clientEditor(ArrayList<Account> accounts, String verify, ArrayList<Client> clients, int index);
}
