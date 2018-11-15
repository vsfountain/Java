package com.users;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.users.User;

public class userTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		User u = new User("a", "b", "c", "d", 1 );
		
		assertNotNull(u);
		assertEquals("a", u.getFirstName());
		assertEquals("b", u.getLastName());
		assertEquals("c", u.getEmail());
		assertEquals("d", u.getPassword());
		assertEquals(1, u.getAccountId());
	}

}
