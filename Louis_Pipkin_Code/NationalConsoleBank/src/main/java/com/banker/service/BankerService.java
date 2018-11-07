package com.banker.service;

import java.util.ArrayList;
import java.util.Map;

import com.banker.model.accounts.Account;
import com.banker.model.users.User;

public interface BankerService {
	
	//getters
	public User getUser(String userid);
	public Map<String, User> getAllUsers();
	public ArrayList<Account> getAllAccounts();
	public ArrayList<Account> getUsersAccounts(String userid);
	public ArrayList<User> getAccountOwners(Account a);
	public ArrayList<Account> getUnapprovedAccounts();
	
	//setters
	public void addUser(String userid, String pass, String type);
	public void addAccount(User u);
	public void addAccount(User u1, User u2);
	public void approveAccount(int accountid);
	public int syncAccount(Account a);
	
	//deleters?
	public void removeUser(User u);
	public void removeAccount(Account a);

	//???
	public boolean isUser(String userid);
	public boolean isApproved(int accountid);
	public int commit();
	
}
