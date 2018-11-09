package com.example.service;

import java.util.List;

import com.example.model.Account;
import com.example.model.Customer;

public interface AccountService {

	
	public List<Account> getAllAccount();
	
	public String getAccountName(String name);
	
	public int createAccount(Customer c);
	
	public Account getAccount(String name);
	
	
	
	//
	
	public int createJointAccount(Customer c, Customer jointCustomer);
	
	//
	
	public List<Account> getAllCustomerAccount(Customer c);
	
	
	
	//
	
	public int updateAccount(Account a);
	
}
