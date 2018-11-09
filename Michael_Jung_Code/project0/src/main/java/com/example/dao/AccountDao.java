package com.example.dao;

import java.util.List;

import com.example.model.Account;

public interface AccountDao {

	//CREATE
	public int insertAccount(Account a);
	//READ
	public List<Account> selectAllAccount();
	public Account selectAccountById(int id);
	public Account selectAccountByName(String name);
	//UPDATE
	public int updateAccount(Account a);
	//DELETE
	public int deleteAccount(Account a);
	
	
	
	//
	public int insertJointAccount(Account a);
	
	
}
