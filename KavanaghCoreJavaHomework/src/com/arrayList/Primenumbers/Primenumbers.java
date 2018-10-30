package com.arrayList.Primenumbers;

/**
 * Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all
 * the prime numbers to the console.
 * 
 * @author Kristen Kavanagh
 * @version 10/29/2018
 *
 */

public class Primenumbers {

	public static void main(String[] args) {
		System.out.println("the prime numbers from 1 to 100 are: ");

		for (int index = 2; index < 100; index++) {
			if (index % 2 != 0 && index % 3 != 0)
				System.out.print(index + " ");
		}

	}
}
