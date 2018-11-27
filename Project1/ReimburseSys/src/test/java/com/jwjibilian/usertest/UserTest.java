package com.jwjibilian.usertest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;

class UserTest {

	@BeforeClass
	static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	static void tearDownAfterClass() throws Exception {
	}

	@Before
	void setUp() throws Exception {
	}

	@After
	void tearDown() throws Exception {
	}

	@Test
	void userTest() {
		int id =1;
		String userName = "uname";
		String password = "pword";
		String firstName = "fname";
		String lastname = "lname";
		String email = "email";
		ArrayList<Reimbursement> reiburse = new ArrayList<Reimbursement>();
		User u = new User(id, userName, password, firstName, lastname, email, reiburse);
		
		
		assertEquals(userName, u.getUserName());

		assertEquals(id, u.getId());
		assertEquals(password, u.getPassword());
		assertEquals(firstName, u.getFirstName());
		assertEquals(lastname, u.getLastname());
		assertEquals(email, u.getEmail());
		
		assertTrue(reiburse.equals(u.getReiburse()));
		
		
	}

}
