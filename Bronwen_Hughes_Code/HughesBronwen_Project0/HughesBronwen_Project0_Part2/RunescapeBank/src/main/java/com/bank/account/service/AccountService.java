package com.bank.account.service;

import java.util.List;

import com.bank.account.model.Account;

public interface AccountService {
	public int createAccountDB();
	public List<Account> getAllAccounts();
	public int addAccount(Account account);
	public Account getAccountFromId(int accountid);
	public Account getAccountFromCustomerId(int customerId);
	public int updateAccount(Account account);
	public int deleteAccount(Account account);
}
