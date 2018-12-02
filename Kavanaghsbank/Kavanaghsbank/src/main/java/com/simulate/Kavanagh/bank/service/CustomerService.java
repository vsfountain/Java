package com.simulate.Kavanagh.bank.service;

import java.util.List;

import com.simulate.Kavanagh.bank.model.Customer;

/**
 * @author Kristen Kavanagh
 * @version 11/5/2018
 *
 */
public interface CustomerService {
	public List<Customer> getAllCustomer();

	//public List<Customer> selectAllCustomer();

public List<Customer>getAllCustomer(String username);
public int createCustomer(Customer client );
public Customer getcustomerByusername(String userName);

public Customer getCustomerByuserName(String userName);
public static Customer getCustomerByusername(String username) {
	return null;
}

List<Customer> selectAllCustomer();

}
