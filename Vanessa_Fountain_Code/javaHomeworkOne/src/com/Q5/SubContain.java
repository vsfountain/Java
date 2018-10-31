package com.Q5;

public class SubContain {
/*
 * Write a substring method that accepts a string str and an integer idx 
 * and returns the substring contained between 0 and idx-1 inclusive
 * Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.

 */
	
	
	static String contains(String str, int num){
		//Checks number is not less than 0
		if (num < 0) {
            throw new StringIndexOutOfBoundsException(num);
        }
		//if num is greater than string length just return the string
        if (num > str.length()) {
        	return str;
        }
		char[] arr = new char[num+1];
		str.getChars(0, num, arr, 0);
		str = String.valueOf(arr);
		//System.out.println(str.getClass());
        return String.valueOf(arr);
	}
	
	public static void main(String[] args) {
		String str = "Hello World";
		int idx = 1;
		System.out.println(contains(str,idx));
		
	}


}
