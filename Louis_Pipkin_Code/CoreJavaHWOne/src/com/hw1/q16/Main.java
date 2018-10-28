package com.hw1.q16;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question Text
		 * 
		 * Q16. Write a program to display the number of characters 
		 * for a string input. The string should be entered as a 
		 * command line argument using (String [ ] args).
		 * 
		 */
		
		int numChars = 0;
		
		for(int i = 0; i < args.length; i++) {
			//if the input string has whitespace account for the characters removed by split(' ') 
            if ((args.length > 1) && (i < args.length-1)) { 
            	numChars += args[i].length();
            	numChars++; 					//inc counter for whitespace
            }else {
            	numChars += args[i].length();
            }
		}

		System.out.println("The input string was "+numChars+" characters long.");
	}

}
