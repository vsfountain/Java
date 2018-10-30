package com.string.substring;

/**
 * Q5. Write a substring method that accepts a string str and an integer idx and returns the
substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
substring methods in the String, StringBuilder, or StringBuffer APIs.
 */
import java.util.Scanner;

public class subString {

	public subString() {
	}

	public static void main (String str, int idx) {
Scanner input = new Scanner(System.in);
System.out.println("Please enter the value of an item eg Chair 20");
String str = input.nextLine();

for (int i = 0; i < idx; i++) {
	   //char thisChar = item.charAt(i);
	char[] thisChar = str.toCharArray();
     //subStringArray [i] = str.toCharArray();
	}
//String.valueOf(thisChar);
//String substring = new String subStringArray;
//return subString;
	}
}