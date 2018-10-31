package com.Q17;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time
 */

public class InterestRate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//ask for the principal from user
		System.out.println((char)27 + "[35mEnter the Principal");
		Integer Principal = Integer.parseInt(scanner.nextLine());
		//ask for rate frm user
		System.out.println((char)27 + "[35mEnter the Rate percent");
		double Rate = Double.parseDouble(scanner.nextLine());
		Rate = Rate/100;
		//ask for time in years from user
		System.out.println((char)27 + "[35mEnter the number of years");
		Integer Time = Integer.parseInt(scanner.nextLine());
		
		double Interest = (Principal * Rate * Time);
		System.out.printf((char)27 + "[35mThe Interest is: " + Interest );
		//System.out.println(Interest);

	}

}
