package com.example.service;

import java.util.List;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	
	private CustomerDao customer = new CustomerDaoImpl();
	
	
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		
		return customer.selectCustomerById(id);
		
		//return null;
	}
	
	
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		
		/*Customer c = new Customer(null, "customer1", "customer1", "customer1", "customer1");
		customer.insertCustomer(c);*/
		
		return customer.selectAllCustomer();
	}


	@Override
	public String getCustomerName(String name) { //name stands for username
		// TODO Auto-generated method stub
		
		Customer c = customer.selectCustomerByName(name);
		if(c == null) {
			return "";
		}
		String customerName = c.getUsername();
		//System.out.println(customerName);
		return customerName;
	}


	@Override
	public int createCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		return customer.insertCustomer(c);
		//return 0;
	}


	@Override
	public Customer getCustomer(String name) {
		// TODO Auto-generated method stub
		
		return customer.selectCustomerByName(name);
		
		
		//return null;
	}


	

}
