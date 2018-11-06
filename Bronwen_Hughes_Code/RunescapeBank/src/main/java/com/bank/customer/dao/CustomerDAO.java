package com.bank.customer.dao;

import java.util.List;

import com.bank.account.model.Account;
import com.bank.customer.model.Customer;

public interface CustomerDAO {
	
	public int insertCustomer(Customer c);
	
	public int createCustomerDB();
	public List<Customer> selectAllCustomers();
	public Customer selectCustomerById(int id);
	public Customer selectCustomerByUsername (String username);
	public Customer selectCustomerByAccount (Account a);
	
	public int updateCustomer(Customer c);
	
	public int deleteCustomer(Customer c);
}
