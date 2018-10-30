package com.switchcase.squareroot;

import java.util.Scanner;

/**
 * Q14. Write a program that demonstrates the switch case. Implement the following
functionalities in the cases:
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.

“I am learning Core Java”
 * 
 * @author Kristen Kavanagh 
 * @version 10/29/2018
 *
 */

public class switchcase {
	Scanner s = new Scanner(System.in);
	int i =input.nextLine();
	switch(int i = 1; i <= comb; i++ );{
	   case 1 :
		   double root = Math.sqrt(value);
	      break; 
	   
	   case 2 :
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); 
	      break; 
	   

	   case 3:
		   String s1= "['i', 'am', 'learning', 'Core', 'Java']";

	       String[]  array = s1.split(",");
	       for(int i=0;i<array.length;i++)
	       {
	           System.out.println(array[i]);
	       }
	   
	}}

