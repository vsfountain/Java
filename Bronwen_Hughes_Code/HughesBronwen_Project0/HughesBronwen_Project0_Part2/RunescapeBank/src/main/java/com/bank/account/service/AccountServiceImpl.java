package com.bank.account.service;

import java.util.List;

import com.bank.account.dao.AccountDAO;
import com.bank.account.dao.AccountDAOImpl;
import com.bank.account.model.Account;

public class AccountServiceImpl implements AccountService {

	AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public List<Account> getAllAccounts() {
		return accountDAO.selectAllAccount();
	}

	@Override
	public int addAccount(Account account) {
		accountDAO.insertAccount(account);
		return 0;
	}

	@Override
	public int createAccountDB() {
		accountDAO.createAccountDB();
		return 0;
	}

	@Override
	public Account getAccountFromCustomerId(int customerId) {
		return accountDAO.selectAccountByCustomerId(customerId);
	}

	@Override
	public Account getAccountFromId(int accountid) {
		// TODO Auto-generated method stub
		return accountDAO.selectAccountById(accountid);
	}

	@Override
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDAO.updateAccount(account);
	}

	@Override
	public int deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDAO.deleteAccount(account);
	}

}