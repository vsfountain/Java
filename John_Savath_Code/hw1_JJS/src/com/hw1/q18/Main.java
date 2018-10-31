/**
 * 
 */
package com.hw1.q18;

/**
 * @author JohnJosephSavath
 *
 *Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass.  
 *	Provide the following three implementations in the subclass 
 *	corresponding to the abstract methods in the superclass: 
 *
 *	Check for uppercase characters in a string, 
 *	and return ‘true’ or ‘false’ depending if any are found.
	
	Convert all of the lower case characters 
	to uppercase in the input string, and return the result. 
	
	Convert the input string to integer 
	and add 10, output the result to the console.
 *
 *Create an appropriate class having a main method to test the above setup.
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test checkCaseOfStringUp method
		ChildClass upperCaseCheck = new ChildClass();
		
		String checkThisString = "akdfjasdfasdf";
		String checkThisString2 = "lkjkljlklkSSSSSSSSSS";
		
		System.out.println(upperCaseCheck.checkCaseOfStringUp(checkThisString));
		
		//test convertThisCase method
		
		ChildClass convertThisCase = new ChildClass();
		
		String convertThisCase2 = "asdfasdf";
		
		System.out.println(convertThisCase.cvtCase(convertThisCase2));
		
		//test convertToInt method
		ChildClass convertToInt = new ChildClass();
		
		String convertToInt2 = "8";
		
		System.out.println(convertToInt.cvtStToint(convertToInt2));

	}

}
