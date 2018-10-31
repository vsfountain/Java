/**
 * 
 */
package com.hw1.q17;

import java.util.Scanner;

/**
 * @author JohnJosephSavath
 *
 *Q17. Write a program that calculates the simple interest on the principal, 
 *		rate of interest and number of years provided by the user. 
 *		Enter principal, rate and time through the console using the Scanner class.
		Interest = Principal* Rate* Time
 *
 *
 *		
 */
public class Main {

	/**
	 * @param args
	 */
	
	static float principal, rate, time, interest, si;
	
	static void rateOfInterest() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the principal");
		principal = sc.nextFloat();
		System.out.println("Enter the rate");
		rate = sc.nextFloat(); 
		System.out.println("Enter the time");
		time = sc.nextFloat();
		interest = principal*rate*time;
		System.out.println("The interest is : "+interest);
		}
	


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		rateOfInterest();
		 

	}

}
