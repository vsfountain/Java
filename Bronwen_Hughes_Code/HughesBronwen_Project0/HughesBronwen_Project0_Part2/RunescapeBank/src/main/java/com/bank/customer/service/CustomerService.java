package com.bank.customer.service;

import java.util.List;

import com.bank.account.model.Account;
import com.bank.customer.model.Customer;

public interface CustomerService {
	public int createCustomerDB();
	public List<Customer> getAllCustomers();
	public int addCustomer(Customer c);
	public Customer getCustomerFromUsername(String username);
	public Customer getCustomerFromAccount(Account account);
	public int deleteCustomer(Customer c);
	public Customer getCustomerFromId(int id);
}
