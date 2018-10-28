package com.hw1.q05;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q5. Write a substring method that accepts a string str 
		 * and an integer idx and returns the substring contained 
		 * between 0 and idx-1 inclusive. Do NOT use any of the existing 
		 * substring methods in the String, StringBuilder, or StringBuffer APIs
		 * 
		 */
		
		String tstStr = "This is my test string!";
		
		System.out.println(mySubString(tstStr, 11));
	}

	public static String mySubString(String str, int idx) {
		String retStr = "";	//start building with an empty string
		
		for(int i=0; i<idx; i++) {
			retStr = retStr + str.charAt(i);	//continuously add the current character to ""
		}
		
		return retStr;
	}
}
