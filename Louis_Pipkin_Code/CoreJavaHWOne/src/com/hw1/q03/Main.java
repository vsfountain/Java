package com.hw1.q03;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q3. Reverse a string without using a temporary variable.  
		 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
		 * 
		 */

		String tstStr = "This is my testing string!";
		
		System.out.println(tstStr);
		
		tstStr = MyStringMethods.revString(tstStr);
		
		System.out.println(tstStr);
	}

}
