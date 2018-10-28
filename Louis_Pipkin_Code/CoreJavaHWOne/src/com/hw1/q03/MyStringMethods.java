package com.hw1.q03;

public class MyStringMethods {

	public static String revString(String inStr) {
		/*
		 * Tail recursion
		 * Recursivly return all the inStr's characters starting 
		 * from the last character. Build the return string with
		 * the + operator between recursive calls.   
		 */
		if(inStr.length()==1) {	//We have the final character
			return inStr;
		}else {
			//return the current character + the recursive call
			//revString(substring until the current character)
			return inStr.charAt(inStr.length()-1) + revString(inStr.substring(0, inStr.length()-1));
		}
	}
	
}
