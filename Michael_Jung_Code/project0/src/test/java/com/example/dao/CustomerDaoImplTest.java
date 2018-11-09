package com.example.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class CustomerDaoImplTest {

	static CustomerDaoImpl tester;
	
	@BeforeClass
	public static void beforeClass() {
		tester=new CustomerDaoImpl();
		
	}
	
	
	
	@Test
	void test() {
		//fail("Not yet implemented");
		
		assertEquals("", "customer1", tester.selectCustomerByName("customer1"));
		
		
	}

}
