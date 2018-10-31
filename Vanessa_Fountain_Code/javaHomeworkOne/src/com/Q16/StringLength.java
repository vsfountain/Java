package com.Q16;

import java.util.Scanner;

/*
 * Write a program to display the number of characters for a string input. 
 * The string should be entered as a command line argument using (String [ ] args).
 */
public class StringLength {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println((char)27 + "[36mEnter String: ");
		String sentence = scanner.nextLine();
		int Len = sentence.length()-1;
		//System.out.println(sentence.length()-1);
		System.out.printf((char)27 + "[35mString Length is: %d", Len);
		
	}

}
