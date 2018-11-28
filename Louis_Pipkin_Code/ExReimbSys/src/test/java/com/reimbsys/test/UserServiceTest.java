package com.reimbsys.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.testng.Assert;

import com.reimbsys.model.User;
import com.reimbsys.service.UserServiceImpl;

public class UserServiceTest {

	UserServiceImpl userv = Mockito.mock(UserServiceImpl.class);
	//UserServiceImpl userv = new UserServiceImpl();
	//User userv = Mockito.mock(UserServiceImpl.class);
	
	static User tstUser;
	
	@BeforeClass
	public static void beforeClass() {
		tstUser = new User("louispipkin", "000hash000");
		System.out.println("------BEFORE CLASS----------");
	}
	@Before
	public void beforeMethod() {
		System.out.println("-------before test----------");
	}
	@After
	public void afterMethod() {
		System.out.println("---------after test---------");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("-------AFTER CLASS--------");
	}

	@Test
	public void authTest() {
		System.out.println("Testing authTest");
		Mockito.when(userv.getUser("louispipkin")).thenReturn(tstUser);
		Mockito.when(userv.getHash("louispipkin", "password")).thenReturn("000hash000");
		Mockito.when(userv.authenticate("louispipkin", "password")).thenReturn(true);

	    //System.out.println(userv.authenticate("louispipkin", "password"));
		
		Assert.assertEquals(true, userv.authenticate("louispipkin", "password"));
		Assert.assertEquals(false, userv.authenticate("louispipkin", "111hash111"));
	}
	
	@Test
	public void getHashTest() {
		System.out.println("Testing getHashTest");
		Mockito.when(userv.getHash("louispipkin", "password")).thenReturn("000hash000");
		Mockito.when(userv.getHash("louispipkin", "111hash111")).thenReturn("111hash111");
		
		Assert.assertEquals(true, userv.getHash("louispipkin", "password").equals(tstUser.getPassword()));
		Assert.assertEquals(false, userv.getHash("louispipkin", "111hash111").equals(tstUser.getPassword()));
	}
	
}
