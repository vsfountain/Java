package com.simulate.Kavanagh.bank.dao;

import java.util.List;

import com.simulate.Kavanagh.bank.model.Customer;
/**
 * @author Kristen Kavanagh
 * @version 11/4/2018
 *
 */
public interface CustomerDao {

	/**
	 * CRUD methods only
	 */
	//create
	public int insertCustomer(Customer client);
	//read
	public List<Customer>selectAllCustomer();
	public Customer selectCustomerById (int client_id);
	public Customer selectCustomerByFirstName (String firstName);
	public Customer selectCustomerByLastName (String lastName);
	public Customer selectCustomerByAddress (String address);
	public Customer selectByusername(String userName);
	public Customer selectCustomerBypassWord(String passWord);
	public List<Customer>selectCustomerByincome(double income);
	public List<Customer>selectCustomerByCreditScore(int creditScore);
	public List<Customer>selectCustomerByCity(String city);
	public List<Customer>selectCustomerByState(String state);
	public Customer selectCustomerByPostalCode (int postalCode);
	public Customer selectCustomerByTelePhoneNumber(int telePhoneNumber);
	public Customer selectCustomerByCustomerEmail( String customerEmail);
	//public Customer selectCustomerByPassWord(String passWord);	
	//update
	public int updateCustomer(Customer client);
	//Delete
	public int deleteCustomer(Customer client);

}



