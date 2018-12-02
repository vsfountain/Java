package com.simulate.Kavanagh.bank.dao;

import java.util.List;

import com.simulate.Kavanagh.bank.model.Account;

public interface AccountDao {
	/**
	 * CRUD methods only
	 */
	// create
	public int insertAccount(Account accountBank);

	// read
	public List<Account>selectAllAccount();

	public List <Account> selectAccountByAccountNumber(int accountNumber);

	public Account selectAccountBystatus(String status);

	public List<Account> selectAccountByclient_id(int client_id);

	public Account selectAccountByAccountBalance(double accountBalance);

	public Account selectAccountByInterestEarned(double interestEarned);

	public Account selectAccountByDescription(String description);

//update
	public int updateAccount(Account accountBank);

//	//Delete
	public int deleteAccount(Account accountBank);

	Account selectAllAccountByClient_id(int client_id);

}
