package com.example.dao;

import java.util.List;

import com.example.model.Customer;

public interface CustomerDao {

	//CREATE
	public int insertCustomer(Customer c);
	//READ
	public List<Customer> selectAllCustomer();
	public Customer selectCustomerById(int id);
	public Customer selectCustomerByName(String name);
	//UPDATE
	public int updateCustomer(Customer c);
	//DELETE
	public int deleteCustomer(Customer c);
	
	
}
