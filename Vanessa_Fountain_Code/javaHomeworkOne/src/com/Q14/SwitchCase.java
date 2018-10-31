package com.Q14;

import java.util.Calendar;

/*
 * 	Case 1: Find the square root of a number using the Math class method. 
	Case 2: Display today’s date.
	Case 3: Split the following string and store it in a sting array. 
		“I am learning Core Java”

 */

public class SwitchCase {
	public static void main(String[] args) {
		int x = 2;
		Calendar date = Calendar.getInstance();
		
		switch(x) {
		case 1:
			System.out.println(Math.sqrt(9));
			break;
		case 2:
			System.out.println(date.getTime());
			break;
		case 3:
			System.out.println("I am learning Core Java");
			break;
		}
		//System.out.println(x);
	}

}
