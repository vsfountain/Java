package com.compute.factorial;
/**
 * Q4. Write a program to compute N factorial.
 * @author Kristen Kavanagh
 * @version 10/29/2018
 *
 */

public class NFactorial {

	public static void main(String[] args) {
		int marbles, fact = 1;
		int number = 9;
		for (marbles = 1; marbles <= number; marbles++) {
			fact = fact * marbles;

		}
		System.out.print("Factorial of  " + number + "  is:  " + fact);

	}

}
