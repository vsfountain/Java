package com.bank.customer.service;

import java.util.List;

import com.bank.account.model.Account;
import com.bank.customer.dao.CustomerDAO;
import com.bank.customer.dao.CustomerDAOImpl;
import com.bank.customer.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.selectAllCustomers();
	}

	@Override
	public int createCustomerDB() {
		customerDAO.createCustomerDB();
		return 0;
	}

	@Override
	public int addCustomer(Customer c) {
		customerDAO.insertCustomer(c);
		return 0;
	}

	@Override
	public Customer getCustomerFromUsername(String username) {
		// TODO Auto-generated method stub
		return customerDAO.selectCustomerByUsername(username);
	}

	@Override
	public Customer getCustomerFromAccount(Account account) {
		// TODO Auto-generated method stub
		return customerDAO.selectCustomerByAccount(account);
	}

	@Override
	public int deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		return customerDAO.deleteCustomer(c);
	}

	@Override
	public Customer getCustomerFromId(int id) {
		// TODO Auto-generated method stub
		return customerDAO.selectCustomerById(id);
	}
	


}
