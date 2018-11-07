package com.utility;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.*;

import controller.dataio.ScannerInt;
import controller.services.UserService;
import controller.services.UserServicesImpl;
import controller.task.Utility;
import model.accounts.Account;
import model.users.User;

public class UtilityTest {
	
	

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
	public void withdrawTest() {
		ScannerInt scanner;
		UserService services;
		
		scanner = Mockito.mock(ScannerInt.class);
		services = Mockito.mock(UserServicesImpl.class);
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		User u = new User("x", "x", "x","x", 0);
		Account a= new Account("Savings", 1, 55);
		accounts.add(a);
		u.addAccount(a);

		Mockito.when(scanner.scanInt()).thenReturn(1).thenReturn(50);
		//when(services.getAccounts(any(Integer.class))).thenReturn(accounts);
		Mockito.when(services.getAccounts(0)).thenReturn(accounts);
		
		Utility.withdraw(u);
		
		Mockito.verify(scanner, times(2)).scanInt();
		Mockito.verify(services, times(1)).getAccounts(any(Integer.class));
		assertEquals(5,a.getBalance());
		assertEquals(u.getAccounts().get(0), a);
		
		
	}

}
