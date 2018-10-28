package com.hw1.q14;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q14. Write a program that demonstrates the switch case. 
		 * Implement the following functionalities in the cases: 
		 * 		Case 1: Find the square root of a number using the Math 
		 * class method. 
		 * 		Case 2: Display today’s date.
		 * 		Case 3: Split the following string and store it in a 
		 * sting array.
		 * 		“I am learning Core Java”
		 * 
		 */
		
		for (int i=1; i<5; i++) {
			System.out.println("Case "+i+" is :");
			mySwitch(i);
		}
		
	}

	public static void mySwitch(int inCase) {
		//switch syntax showcase
		switch(inCase) {
		case 1:
			System.out.println("The square root of 144 is "+Math.sqrt(144));
			break;
		case 2:
			Date date = new Date();		//raw date, no formating
			System.out.println(date);
			break;
		case 3:
			System.out.println("I am learning Core Java");
			break;
		default:	//the bare minimum of error checking
			System.out.println("No such case.");
		}
		
	}
	
}
