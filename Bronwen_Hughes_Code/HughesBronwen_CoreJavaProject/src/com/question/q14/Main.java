package com.question.q14;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please input a number from 1 to 3: " );
		int choice = Integer.parseInt(scan.next());
		
		switch(choice) {
		case 1:
			System.out.print("Enter the number you want to squareroot: ");
			int num = Integer.parseInt(scan.next());
			System.out.println(Math.sqrt(num));
			break;
		case 2:
			System.out.println("Today's date is: " + Calendar.getInstance().getTime());
			break;
		case 3:
			// split the following string and store it in a string array
		}
	}
}
