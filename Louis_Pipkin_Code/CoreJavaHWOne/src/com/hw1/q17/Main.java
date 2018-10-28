package com.hw1.q17;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question Text
		 * 
		 * Q17. Write a program that calculates the simple interest 
		 * on the principal, rate of interest and number of years 
		 * provided by the user. Enter principal, rate and time through 
		 * the console using the Scanner class.
		 * 
		 * 		Interest = Principal* Rate* Time
		 * 
		 */
		
		double principal;
		double rate;
		int years;
		
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a the principal: ");
		input = scanner.nextLine(); 
		principal = Double.parseDouble(input);
		
		System.out.print("Enter a the rate of interest: ");
		input = scanner.nextLine(); 
		rate = Double.parseDouble(input);
		
		System.out.print("Enter a the number of years: ");
		input = scanner.nextLine(); 
		years = Integer.parseInt(input);
		
		System.out.println("The interest is : "+compPrincipal(principal, rate, years));
		
		scanner.close();
	}

	public static double compPrincipal(double pr, double rate, int years) {
		/*
		 * Interest = Principal* Rate* Time
		 */
		
		return (pr * rate * years);
	}
}
