package com.banker.dao;

import java.util.ArrayList;
import java.util.Map;

import com.banker.model.accounts.Account;
import com.banker.model.users.User;

public interface BankerDao {
		//CREATE
		public int insertUser(User u);
		public int insertAccount(Account a, User u);
		//public int insertAccount(Account a, User u1, User u2);
		public int insertRef(Account a, User u);
		public int insertUnapproved(Account a);
		
		//READ
		public Map<String,User> selectAllUsers();
		public ArrayList<Account> selectAllAccounts();
		public Account selectAccountById(int id);
		public User selectUserByUsername(String userid);
		//public ArrayList<Account> selectAccountsByUsername(String userid);
		public ArrayList<Account> selectUnapprovedAccounts();
		public ArrayList<User> selectOwners(Account a);
		
		//UPDATE
		public int updateUser(User u);
		public int updateAccount(Account a);
		public int commit();
		
		//DELETE
		public int deleteUser(User u);
		public int deleteAccount(Account a);
		public int deleteUnapproved(int aid);
}
