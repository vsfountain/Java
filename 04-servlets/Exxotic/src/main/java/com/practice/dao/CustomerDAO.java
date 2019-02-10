package com.practice.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.model.Customer;

@Repository("CustomerDAO")
@Transactional
public class CustomerDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Autowired
	private SessionFactory sesfact;
	
	public void insertCustomer(Customer customer) {
		sesfact.getCurrentSession().save(customer);
	}

	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		return sesfact.getCurrentSession().createQuery("From customer", Customer.class).list();
	}
	
	

}
