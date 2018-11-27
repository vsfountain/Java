package com.jwjibilian.usertest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;

class UserTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
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
