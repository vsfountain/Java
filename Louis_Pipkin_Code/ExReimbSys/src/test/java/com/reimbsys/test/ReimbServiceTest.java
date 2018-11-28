package com.reimbsys.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.testng.Assert;

import com.reimbsys.dao.ReimbDaoImpl;
import com.reimbsys.model.Reimbursement;
import com.reimbsys.model.User;
import com.reimbsys.service.ReimbServiceImpl;

public class ReimbServiceTest {

	ReimbServiceImpl rserve = Mockito.mock(ReimbServiceImpl.class);
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
	public void getTypesTest() {
		System.out.println("Testing getTypesTest");
		Mockito.when(rserve.getTypes()).thenReturn(new HashMap<String, Integer>());

	    //System.out.println(userv.authenticate("louispipkin", "password"));
		
		assertThat("Fails if type of map", rserve.getTypes(), is(not(0)));
		assertThat("Fails if not type of map", rserve.getTypes(), is(new HashMap<String, Integer>()));
	}
	
	@Test
	public void getReimbByUserNameTest() {
		System.out.println("Testing getReimbTest");
		Mockito.when(rserve.getReimbByUserName(tstUser.getUsername())).thenReturn(new HashMap<String, Reimbursement>());

	    //System.out.println(userv.authenticate("louispipkin", "password"));
		
		assertThat("Fails if type of map", rserve.getReimbByUserName(tstUser.getUsername()), is(not(true)));
		assertThat("Fails if not type of map", rserve.getReimbByUserName(tstUser.getUsername()), is(new HashMap<String, Reimbursement>()));
	}
	
	@Test
	public void getReimbByIdTest() {
		System.out.println("Testing getReimbTest");
		Mockito.when(rserve.getReimbById(0)).thenReturn(new Reimbursement());

	    //System.out.println(userv.authenticate("louispipkin", "password"));
		
		assertThat("Fails if new reimbursement", rserve.getReimbById(0), is(not(0)));
	}
}
