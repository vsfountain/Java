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

	public Account selectAccountByAccountNumber(int accountNumber);

	public Account selectAccountBystatus(String status);

	public Account selectAccountByclient_id(int client_id);

	public Account selectAccountByAccountBalance(double accountBalance);

	public Account selectAccountByInterestEarned(double interestEarned);

	public Account selectCustomerByDescription(char description);

//update
	public int updateAccount(Account accountBank);

//	//Delete
	public int deleteAccount(Account accountBank);

}
