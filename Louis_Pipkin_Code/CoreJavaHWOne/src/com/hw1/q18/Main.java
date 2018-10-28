package com.hw1.q18;

public class Main {
	
	public static void main(String[] args) {
		/*
		 * Question Text
		 * 
		 * Q18. Write a program having a concrete subclass that inherits 
		 * three abstract methods from a superclass. Provide the following 
		 * three implementations in the subclass corresponding to the 
		 * abstract methods in the superclass:
		 * 	
		 * 	1. Check for uppercase characters in a string, and return ‘true’ 
		 * 		or ‘false’ depending if any are found.
		 *  2. Convert all of the lower case characters to uppercase in the 
		 *  	input string, and return the result.
		 *  3. Convert the input string to integer and add 10, output the 
		 *  result to the console.
		 * 
		 */

		MyStringSubClass s = new MyStringSubClass();
		
		String testStringOne = "this string does not have any uppercase."; 
		String testStringTwo = "This string Does have a few."; 
		String testStringThree = "This ONE is a LittLe mOrE CoplicaTed.";
		String testStringFour = "928772"; 
		
		//test anyUpper
		System.out.println("Does this string have any upper case? "+testStringOne);
		System.out.println("Answer: "+s.anyUpper(testStringOne)); //false
		System.out.println("Does this string have any upper case? "+testStringTwo);
		System.out.println("Answer: "+s.anyUpper(testStringTwo)); //true
		
		//test lowerToUpper
		System.out.println("Now this string to all uppercase: "+testStringThree);
		System.out.println("Here: "+s.lowerToUpper(testStringThree));
		
		//test add10AndPrint
		System.out.println("Now this string plus 10: "+testStringFour);
		s.add10AndPrint(testStringFour);
		
	}
	
}
