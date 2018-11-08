package com.dao.account;

import java.util.ArrayList;

import com.profiles.Account;

public interface AccountDAO {
	//CREATE
	public int insertAccount(Account a);
	
	//READ
	public ArrayList<Account> selectAllAccounts();
	public Account getAccount(int accNum);
	public ArrayList<Integer> getAccountNums();
	
	//UPDATE
	public int updateAccount(Account a);
	public int deposit(Account a);
	public int withdraw(Account a);
	
	//DELETE
	public int deleteAccount(Account a);

}
