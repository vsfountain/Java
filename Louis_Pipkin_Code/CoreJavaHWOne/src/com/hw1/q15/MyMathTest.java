package com.hw1.q15;

public class MyMathTest {

	static int testNumOne = 6;
	static Double testNumTwo = 3.3d;
	
	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q15. Write a program that defines an interface having the 
		 * following methods: addition, subtraction, multiplication, 
		 * and division. Create a class that implements this interface 
		 * and provides appropriate functionality to carry out the 
		 * required operations. Hard code two operands in a test class 
		 * having a main method that calls the implementing class.
		 * 
		 */
		
		MyMathImplimented math = new MyMathImplimented();
		
		//addition
		System.out.println(testNumOne+" + "+testNumTwo+" is "+math.addition(testNumOne, testNumTwo));
		
		//subtraction
		System.out.println(testNumOne+" - "+testNumTwo+" is "+math.subtraction(testNumOne, testNumTwo));
				
		//multiplication
		System.out.println(testNumOne+" * "+testNumTwo+" is "+math.multiplication(testNumOne, testNumTwo));
				
		//division
		System.out.println(testNumOne+" / "+testNumTwo+" is "+math.division(testNumOne, testNumTwo));

	}

}
