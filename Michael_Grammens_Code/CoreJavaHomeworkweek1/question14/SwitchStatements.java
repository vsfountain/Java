package com.homework.question14;

import java.util.*;

public class SwitchStatements {
	public static void main(String[] args) {
		System.out.println("Enter case number: 1,2,3");
		Scanner input = new Scanner(System.in);
		try {
			int caseNum = input.nextInt();
			switch(caseNum) {
			case 1:
				System.out.println("The square root of 4 is: " + Math.sqrt(4));
				break;
			case 2:
				Date todaysDate = new Date();
				System.out.println("Today's date is: " + todaysDate);
				break;
			case 3:
				System.out.println("Splitting the following string: I am learning Core Java. Please wait....");
				String mainString = "I am learning Core Java";
				String[] stringArray = mainString.split(" ");
				System.out.println("After split, the array looks like: " + Arrays.toString(stringArray));
			}
			
		}
		catch(Exception e){
			System.out.println("Thats the wrong input, try again please.");
		}
		input.close();
	}
}
