package com.banker.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.banker.model.accounts.Account;

public class AccountTest {

	static Account atester;
	static Account btester;
	
	@BeforeClass
	public static void beforeClass() {
		atester = new Account(333);
		btester = new Account(222);
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
	public void depositTest() {
		System.out.println("inside deposit test");
	
		assertEquals("Deposite of 33 should return true",  true, atester.deposit(33));
		assertEquals("Deposite of -12 should return false",  false, atester.deposit(-12));
	}
	
	
	@Test
	public void withdrawlTest() {
		System.out.println("inside withdrawal test");
	
		assertEquals("Withdraw of 33 should return true",  33, atester.withdrawal(33));
		assertEquals("Deposite of -12 should return false",  0, atester.withdrawal(-12));
		assertEquals("Deposite of 1000000 should return false",  0, atester.withdrawal(1000000));
	}
	
	@Test
	public void transferTest() {
		System.out.println("inside transfer test");
	
		assertEquals("Withdraw of 33 should return true",  true, atester.transfer(111, btester));
		assertEquals("Deposite of -12 should return false",  false, atester.transfer(-33, btester));
		assertEquals("Deposite of 1000000 should return false",  false, atester.transfer(1000000, btester));
	}
	
}
