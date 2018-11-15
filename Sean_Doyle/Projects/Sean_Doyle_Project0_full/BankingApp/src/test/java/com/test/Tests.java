package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.profiles.Account;
import com.profiles.Client;
import com.service.BankService;
import com.service.BankServiceImplementation;


public class Tests {
	public BankService bserv = new BankServiceImplementation();
	//Client c = Mockito.mock(Client.class);
	
	@Before
	public void BeforeTest() {
		bserv.wipeDB("Sp00d3rMan");
		//bserv.wipeDB("Spood3rMan");//this proves the string must be valid
	}
	@After
	public void AfterTest() {
		bserv.wipeDB("Sp00d3rMan");
		//to make sure the db is set-up for banking
	}
	
	
	@Test
	public void checkStoreClient() {
		//need to figure out how to mock the constructor
		//make sure to wipe DB
		Client c = new Client();
		c.changePassword("buzz");
		c.setClientFirstName("sean");
		c.setClientLastName("doyle");
		c.addAccount(700);
		c.activateClient("Fluffy");
        assertEquals("bad getClientID", 0, c.getClientID());
        assertEquals("bad getGivenName()", "sean", c.getGivenName());
        assertEquals("bad getFamilyName()", "doyle", c.getFamilyName());
        assertEquals("bad getPassword()", "buzz", c.getPassword());
		assertEquals("whoops client not added", 1, bserv.storeClient(c));
		assertEquals("bad checkClientLogin()", c.toString(), bserv.checkClientLogin("sean", "doyle", "buzz").toString());
	}

	
	@Test
	public void checkStoreAccout() {
		//make sure to wipe DB
		Account a = new Account(83.23);
		Assert.assertEquals(83.23, a.getAccountBalance(), 0.005);
		assertEquals("bad accountNum", 666, a.getAccountNumber());
		assertFalse("bad constructor",a.getAccountStatus());
		assertEquals("whoops account not added", 1, bserv.storeAccount(a));
		assertEquals("bad lookUpAccount()", a.toString(), bserv.lookUpAccount(666).toString());
		assertEquals("bad account DAO deposit",1, bserv.deposit(a));
		
		Account a2 = new Account(72.13);
		Assert.assertEquals(72.13, a2.getAccountBalance(), 0.005);
		assertEquals("bad accountNum", 667, a2.getAccountNumber());
		assertFalse("bad constructor",a2.getAccountStatus());
		assertEquals("whoops account not added", 1, bserv.storeAccount(a2));
		assertEquals("bad lookUpAccount()", a2.toString(), bserv.lookUpAccount(667).toString());
		assertEquals("bad lookUpAccount()", a.toString(), bserv.lookUpAccount(666).toString());
		
		
	}

	@Test
	public void repopulateAccountsTest() {
		Account a = new Account(83.23);
		bserv.storeAccount(a);
		Account a2 = new Account(72.13);
		bserv.storeAccount(a2);
		bserv.wipeDB("Sp00d3rMan");
		assertEquals("wipeAccounts failed", 0, bserv.repopulateAccounts().size());
	}
	@Test
	public void testDAOwithdraw() {
		Client c = new Client();
		bserv.storeClient(c);
		Client c2 = new Client();
		bserv.storeClient(c2);
		bserv.wipeDB("Sp00d3rMan");
		assertEquals("wipeClients failed", 0, bserv.repopulateClients().size());
	}

}
