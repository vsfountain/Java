package com.bank.account.dao;

import java.util.List;

import com.bank.account.model.Account;
import com.bank.customer.model.Customer;

public interface AccountDAO {
	
	public int createAccountDB();

	public int insertAccount(Account a);

	public List<Account> selectAllAccount();

	public Account selectAccountById(int id);

	public Account selectAccountByCustomerId(int customerId);

	public int updateAccount(Account a);

	public int deleteAccount(Account a);
}
