package com.example.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/* What is JUnit?
 * 
 * JUnit is a testing framework.
 * Specifically, it's a unit testing framework.
 * 
 * What....is unit testing?
 * Unit testing is testing a small portion of your
 * program. Usually, a method. Method is a unit.
 * (as opposed to integration testing)
 * 
 * JUnit is important for Test Driven Development (TDD).
 * 
 * TDD is writing tests before you write code.
 * Benefits of TDD:
 * 		You create a detailed specification of what you
 * 			want your method to do.
 * 		Requires you to think about what you want from
 * 			each piece of code.
 */

public class CalculatorTest {

	@Test
	public void multiplicationOfZeroShouldReturnZero() {
		System.out.print("Currently testing multiplication");
		Calculator tester = new Calculator();
		assertEquals("10*0 should return 0", 0, tester.multiply(10, 0));
		assertEquals("0*10 should return 0", 0, tester.multiply(0, 10));
		assertEquals("0*0 should return 0", 0, tester.multiply(0, 0));
	}
	
	@Test
	public void additionShouldReturnSum() {
		System.out.print("Currently testing addition");
		Calculator tester = new Calculator();
		assertEquals("3+4 should return 7", 7, tester.add(3, 4));
		assertEquals("10+20 should return 30", 30, tester.add(10, 20));
		assertEquals("-6-2 should return -8", -8, tester.add(-6, -2));
	}
	
	@Before
	public void beforeMethod() {
		System.out.println("\n********Before each method*******");
	}
	
	@After
	public void afterMethod() {
		System.out.println("\n********After each method*******");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("\n------------BEFORE CLASS---------");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("\n------------AFTER CLASS---------");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void xyzMethodShouldThrowIllegalArgumentException() {
		System.out.print("currently in exception method");
		Calculator tester = new Calculator();
		tester.xyzMethod();
		System.out.println("after call in exception method");
	}
	
	@Test(timeout = 3000)//milliseconds
	public void timeMethod() {
		System.out.println("currently in time method");
		Calculator tester = new Calculator();
		tester.timeMethod();
	}
	
	@Ignore
	@Test
	public void ignoreExample() {
		System.out.println("ignored");
	}
}
