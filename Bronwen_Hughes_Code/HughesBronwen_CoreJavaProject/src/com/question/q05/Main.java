package com.question.q05;

import java.util.Scanner;

public class Main {
	// make a substring of a string so like you wanted a string up to a certain
	// index of 5

	public static void main(String[] args) {

		Scanner keyboard;
		String testString;
		int testInt;

		keyboard = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		testString = keyboard.next();

		System.out.print("Please enter a number: ");
		testInt = Integer.parseInt(keyboard.next());

		System.out.println(subString(testString, testInt));

		keyboard.close();
	}

	public static String subString(String str, int idx) {

		char[] testChar;
		testChar = str.toCharArray();
		String newStr = "";

		for (int i = 0; i < idx; i++) {
			newStr += testChar[i];
		}

		return newStr;
	}

	// svc building ud id number
}
