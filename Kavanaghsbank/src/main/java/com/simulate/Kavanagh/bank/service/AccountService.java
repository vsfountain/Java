package com.simulate.Kavanagh.bank.service;

import java.util.List;

import com.simulate.Kavanagh.bank.model.Account;
import com.simulate.Kavanagh.bank.model.Customer;

/**
 * 
 * @author Kristen Kavanagh
 * @version 11/5/2018
 *
 */
public interface AccountService {
	public List<Account>getAllAccount();

	public void CreateAccount(Customer newCustomer);
	public List<Account> getAccountByClientId(int client_id);
	public List<Account> getAccountByAccountNumber(double accountNumber);
	public Account deposit(Double depositamountDouble, Account accts);
	public Account update (Account updateAccount);
	public Account withdraw(Double withdrawamountDouble, Account accts);

	//public Account getAccountByClientId(int client_id);
	
	
}
