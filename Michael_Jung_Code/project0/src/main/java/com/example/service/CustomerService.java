package com.example.service;

import java.util.List;

import com.example.model.Customer;
//
public interface CustomerService {

	public List<Customer> getAllCustomer();
	
	public String getCustomerName(String name);
	
	public int createCustomer(Customer c);
	
	public Customer getCustomer(String name);
	
	public Customer getCustomerById(int id);
}
