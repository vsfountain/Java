package com.simulate.Kavanagh.bank.dao;

import java.util.List;

import com.simulate.Kavanagh.bank.model.Account;


public interface AccountDao {
	/**
	 * CRUD methods only
	 */
	//create
	public int insertAccount(Account a);
	//read
	public List<Account>selectAllAccount();
	public Account selectAccountByAccountNumber (int accountNumber);
	public Account selectAccountBystatus(String status);
//	public Customer selectCustomerByLastName (String lastName);
//	public Customer selectCustomerByAddress (char address);
//	public List<Customer>selectByusername(char userName);
//	public List<Customer>selectCustomerByincome(double income);

//	public List<Customer>selectCustomerByCity(String city);
//	public List<Customer>selectCustomerByState(String state);
//	public Customer selectCustomerByPostalCode (char postalCode);
//	public Customer selectCustomerByTelePhoneNumber(char telePhoneNumber);
//	public Customer selectCustomerByCustomerEmail( char customerEmail);
//	public Customer selectCustomerByPassWord(char passWord);	
//	//update
public int updateAccount(Account a);
//	//Delete
public int deleteAccount(Account a);

}






