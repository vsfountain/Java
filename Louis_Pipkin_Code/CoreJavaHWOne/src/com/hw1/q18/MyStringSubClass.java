package com.hw1.q18;

public class MyStringSubClass extends MyStringSuperClass {



	@Override
	boolean anyUpper(String inStr) { 
		/*
		 * return true when the first upper case character is found
		 */
		for (int i=0; i<inStr.length(); i++) {
			if (Character.isUpperCase(inStr.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	String lowerToUpper(String inStr) {
		//this will eventually be our return string
		char[] charArr = new char[inStr.length()];
		
		for (int i=0; i<inStr.length(); i++) {
			if (Character.isUpperCase(inStr.charAt(i))) {
				charArr[i] = inStr.charAt(i);
			}else {
				//use toUpperCase on any lower case characters
				charArr[i] = Character.toUpperCase(inStr.charAt(i));
			}
		}
		//create a new string from the char array
		return new String(charArr);
	}

	@Override
	void add10AndPrint(String inStr) {
		int num = Integer.parseInt(inStr) + 10;
		System.out.println(num);
	}
}
