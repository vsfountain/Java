package com.hw1.q06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q6. Write a program to determine if an integer 
		 * is even without using the modulus operator (%)
		 */
		
		String input;
		int number;
		
		Scanner scanner = new Scanner(System.in);
		
		//get n from the user
		System.out.print("Enter a number for n: ");
		input = scanner.nextLine(); 
		number = Integer.parseInt(input);
		
		System.out.println("Is "+number+" even? Answer: "+isEven(number));

		scanner.close();
	}
	
	public static boolean isEven(int n) {
		/*
		 * An even number divided by two and then 
		 * multiplied by two will always equal itself.
		 *  
		 */
		return ((n / 2) * 2 == n); 
	}
}
