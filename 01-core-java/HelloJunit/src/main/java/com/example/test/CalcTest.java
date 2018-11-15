package com.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.pojo.Calculator;


/*
 * JUnit is an automatic testing framework.
 * 
 * What is a unit testing?
 * 		A "unit" in java is a method. Unit testing tests your method functionality
 * 	independent of the rest of your application.
 * 
 * What is integration testing?
 * 		Testing how the units of your application work together.
 * 
 * There is also security testing, api testing, code quality testing, etc.
 * 
 */
//@FixMethodOrder(MethodSorters.DEFAULT)
public class CalcTest {

	static Calculator tester;
	
	@BeforeClass
	public static void beforeClass() {
		tester= new Calculator();
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
	
	@Ignore("an ignore comment")
	@Test(timeout= 3000)
	public void timeMethod() {
		System.out.println("inside time test");
		tester.timeMethod();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void xyzMethod() {
		System.out.println("inside xyz method");
		
		tester.xyzMethd();
	}
	
	
	@Test
	public void multipicationTest() {
		System.out.println("inside mult test");
		//Calculator tester= new Calculator();
	
		assertEquals("10*0 should return 0",  0, tester.multiply(10, 0));
		assertEquals("0*10 should return 0",  0, tester.multiply(0, 10));
		assertEquals("0*0 should return 0",  0, tester.multiply(0, 0));
	}
	
	@Test
	public void addition() {
		System.out.println("inside add");
		//Calculator tester= new Calculator();
		assertEquals("stuff", 7, tester.add(1, 6));
		assertEquals("8+1", 9, tester.add(1, 8));
	}
	
	
	
}
