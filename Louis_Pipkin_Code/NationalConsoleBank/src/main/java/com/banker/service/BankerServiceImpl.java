package com.banker.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.banker.Main;
import com.banker.dao.BankerDao;
import com.banker.dao.BankerDaoImpl;
import com.banker.model.accounts.Account;
import com.banker.model.accounts.Joint;
import com.banker.model.accounts.Personal;
import com.banker.model.users.Admin;
import com.banker.model.users.Associate;
import com.banker.model.users.Client;
import com.banker.model.users.User;

public class BankerServiceImpl implements BankerService {

	final static Logger logger = Logger.getLogger(Main.class);
	
	private BankerDao bank = new BankerDaoImpl();

	@Override
	public User getUser(String userid) {
		logger.info("Running getUser Service.");
		
		return bank.selectUserByUsername(userid);
	}

	@Override
	public Map<String, User> getAllUsers() {
		logger.info("Running getAllUser Service.");
		
		return bank.selectAllUsers();
	}

	@Override
	public ArrayList<Account> getAllAccounts() {
		logger.info("Running getAllAccounts Service.");
		
		ArrayList<Account> arr =  bank.selectAllAccounts();
		//System.out.println("in service, all accounts: "+arr);
		Map<Integer, Account> map = new HashMap<>();
		//System.out.println("here?");
		//find the existing joint accounts and add owners
		for (Account a: arr) {
			if (a instanceof Personal) {
				//add personal account to map
				map.put(a.getAccountid(), a);
			} else {
					//chech if joint account is already in map by its index
				if (map.containsKey(a.getAccountid())) {
					//get joint from map by index and cast to reach addOwner function in joint class
					((Joint) map.get(a.getAccountid())).addOwner(((Joint) a).getOwner(0));
					
				} else {
					//add joint account to map
					map.put(a.getAccountid(), a);
				}
			}
		}
		//return the values of the map
		return new ArrayList<Account>(map.values());
	}
	@Override
	public ArrayList<Account> getUsersAccounts(String userid) {
		logger.info("Running getUserAccounts Service.");
		
		ArrayList<Account> arr1 = bank.selectAllAccounts();
		ArrayList<Account> arr2 = new ArrayList<>();;
		
		for (Account a1: arr1) {
			if (a1 instanceof Personal) {
				if (userid.equals(((Personal) a1).getOwner())) {
					arr2.add(a1);
				}
			} else {
				if (userid.equals(((Joint) a1).getOwner(0))) {
					arr2.add(a1);
				}
			}
		}
		
		return arr2;
	}

	@Override
	public ArrayList<User> getAccountOwners(Account a) {
		logger.info("Running getAccountOwners Service.");
		
		return bank.selectOwners(a);
	}

	@Override
	public void addUser(String userid, String pass, String type) {
		logger.info("Running addUser Service.");
		
		User u = new User();
		
		if ("client".equals(type)) {
			u = new Client(userid, pass);
		} else if ("associate".equals(type)) {
			u = new Associate(userid, pass);
		} else if ("admin".equals(type)) {
			u = new Admin(userid, pass);
		}
		
		bank.insertUser(u);
	}

	@Override
	public void addAccount(User u) {
		logger.info("Running addAccount(User) Service.");
		
		Account a = new Personal(0, u.getUserName());
		int id = bank.insertAccount(a, u);
		a.setAccountid(id);
		//bank.insertRef(a, u);
	}

	@Override
	public void addAccount(User u1, User u2) {
		logger.info("Running addAccount(User, User) Service.");
		
		System.out.println(u1+ " "+u2);
		ArrayList<String> als = new ArrayList<>();
		als.add(u1.getUserName());
		als.add(u2.getUserName());	
		Joint j = new Joint(0, als);
		int id = bank.insertAccount(j, u1);
		j.setAccountid(id);
		bank.insertRef(j, u2);
	}

	@Override
	public void approveAccount(int accountid) {
		logger.info("Running approveAccount Service.");
		
		bank.deleteUnapproved(accountid);
	}

	@Override
	public void removeUser(User u) {
		logger.info("Running removeUser Service.");
		
		bank.deleteUser(u);
	}

	@Override
	public void removeAccount(Account a) {
		logger.info("Running removeAccount Service.");
		
		bank.deleteAccount(a);
	}

	@Override
	public boolean isUser(String userid) {
		logger.info("Running isUser Service.");
		
		Map<String, User> users = bank.selectAllUsers();
		//System.out.println(users);
		if (users.containsKey(userid)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isApproved(int accountid) {
		logger.info("Running isApproved Service.");
		
		ArrayList<Account> unapproved = bank.selectUnapprovedAccounts();
		
		for (Account a: unapproved) {
			if (accountid == a.getAccountid()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ArrayList<Account> getUnapprovedAccounts() {
		logger.info("Running getUnapprovedAccounts Service.");
		
		ArrayList<Account> arr =  bank.selectUnapprovedAccounts();
		//System.out.println("in service, all accounts: "+arr);
		Map<Integer, Account> map = new HashMap<>();
		//System.out.println("here?");
		//find the existing joint accounts and add owners
		for (Account a: arr) {
			if (a instanceof Personal) {
				//add personal account to map
				map.put(a.getAccountid(), a);
			} else {
					//chech if joint account is already in map by its index
				if (map.containsKey(a.getAccountid())) {
					//get joint from map by index and cast to reach addOwner function in joint class
					((Joint) map.get(a.getAccountid())).addOwner(((Joint) a).getOwner(0));
					
				} else {
					//add joint account to map
					map.put(a.getAccountid(), a);
				}
			}
		}
		//return the values of the map
		return new ArrayList<Account>(map.values());
	}

	@Override
	public int syncAccount(Account a) {
		logger.info("Running syncAccout Service.");
		
		return bank.updateAccount(a);
	}

	@Override
	public int commit() {
		logger.info("Running commit Service.");
		
		return bank.commit();
	}

}
