package com.ex.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This is a JUnit test class
 * 
 * JUnit provides static methods in the org.junit.Assert class to test for
 * certain conditions. These methods usually start with "assert" and let you
 * specify an error message, the expected result, and the actual result. If the
 * test fails, the "assert" method will throw an AssertionException.
 * 
 * @author Taylor Kemper
 *
 */

/*
 * To run test methods in a specified order, you must use the @FixMethodOrder
 * annotation. However, this is bad practice because unit tests should be independent
 * of each other. By ordering them, you are implying that the unit tests depend on
 * each other.
 */
//@FixMethodOrder(MethodSorters.DEFAULT)
public class CalculatorTest {
	
//	/*
//	 * Each test method should be annotated with @Test
//	 * 
//	 * Signature: public void method()
//	 */
	@Test
	public void multiplicationOfZeroShouldReturnZero() {
		System.out.println("Currently testing multiplicationOfZeroShouldReturnZero");
		Calculator tester = new CalculatorImpl();
		assertEquals("10 * 0 should return 0", 0, tester.multiply(10, 0));
		assertEquals("0 * 10 should return 0", 0, tester.multiply(0, 10));
		assertEquals("0 * 0 should return 0", 0, tester.multiply(0, 0));		

	}

//	/*
//	 * Each test method should be annotated with @Test
//	 * 
//	 * Signature: public void method()
//	 */
	@Test
	public void additionShouldReturnSum() {
		System.out.println("Currently testing additionShouldReturnSum");

		Calculator tester = new CalculatorImpl();
		assertEquals("3 + 4 should return 7", 7, tester.add(3, 4));
		assertEquals("10 + 20 should return 30", 30, tester.add(10, 20));
		assertEquals("-4 + -2 should return -6", -6, tester.add(-4, -2));
	}

//	/*
//	 * This method runs before EACH test method
//	 * 
//	 * Signature: public void method()
//	 */
	@Before
	public void beforeMethod() {
		System.out.println("\n***** Before each method *****");
	}

//	/*
//	 * This method runs after EACH test method
//	 * 
//	 * Signature: public void method()
//	 */
	@After
	public void afterMethod() {
		System.out.println("***** After each method *****");
	}

//	/*
//	 * This method runs ONCE - before the start of all tests in this class
//	 * 
//	 * Signature: public static void method()
//	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("----- BEFORE CLASS -----");
	}

//	/*
//	 * This method runs ONCE - after the start of all tests in this class
//	 * 
//	 * Signature: public static void method()
//	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("\n----- AFTER CLASS -----");
	}

	@Test(expected = IllegalArgumentException.class)
	public void xyzMethodShouldThrowIllegalArgumentException() {
		System.out.println("Currently testing xyzMethodShouldThrowIllegalArgumentException");

		Calculator tester = new CalculatorImpl();
		tester.xyzMethod();
		System.out.println("Right after xyzMethod() call");
	}

//	/*
//	 * This is stop the test after 3,000 milliseconds
//	 */
	@Test(timeout = 3000)
	public void timeMethodShouldTakeLessThan3000() {
		System.out
				.println("Currently testing timeMethodShouldTakeLessThan1000");

		Calculator tester = new CalculatorImpl();
		tester.timeMethod();
	}

	@Ignore
	@Test
	public void ignoreExample() {
		System.out.println("Ignored");
	}

	@Ignore("Reason for ignoring test method - This is an example")
	@Test
	public void ignoreExampleWithReason() {
		System.out.println("Ignored");
	}

	
	/*
	 * "Best Practices" example
	 */
//		Calculator calc;
	//	
//		@Before
//		public void setUp(){
//			calc = new CalculatorImpl();
//			
//		}
	//	
//		@After
//		public void tearDown(){
//			calc = null;
//		}
	//	
//		@Test
//		public void someMethod(){
//			calc.add(2, 4);
//		}
}
