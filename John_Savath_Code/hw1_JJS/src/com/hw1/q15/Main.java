/**
 * 
 */
package com.hw1.q15;

/**
 * @author JohnJosephSavath
 *
 *Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  
 *Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
 *Hard code two operands in a test class having a main method that calls the implementing class.
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculate calculate = new Calculate();
		
		int a = 15;
		int b = 5;
		
		System.out.println(calculate.multiply(a, b));
		System.out.println(calculate.divide(a, b));
		System.out.println(calculate.add(a, b));
		System.out.println(calculate.subtract(a, b));
		
		
		
	}



}
