/**
 * 
 */
package com.hw1.q14;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

/**
 * @author JohnJosephSavath
 *
 *Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
	Case 1: Find the square root of a number using the Math class method. 
	Case 2: Display today’s date.
	Case 3: Split the following string and store it in a string array. 
		“I am learning Core Java”
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	static char option ='\0';
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do {
			
			System.out.println("Enter a case A,B, or C.");
			Scanner scanner = new Scanner(System.in);
			option = scanner.next().charAt(0);
			
			switch(option) {
			case 'A':
				int x = 4;
			Math.sqrt(x);
			break;
			case 'B':
				Date date = new Date();
				System.out.println(date);
			break;
			case 'C':
				
				String s = "I am learning Core Java";
				String[] s2 = s.split("g");
				System.out.println(s2[0] + s2[1]);//print the two arrays that were stored in s2
			break;
			}
			
		}while(true);
	}

}
