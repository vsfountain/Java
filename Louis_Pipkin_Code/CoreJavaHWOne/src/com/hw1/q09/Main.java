package com.hw1.q09;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q9. Create an ArrayList which stores numbers 
		 * from 1 to 100 and prints out all the prime 
		 * numbers to the console.
		 * 
		 */
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		for (int i=1; i<=100; i++) {
			nums.add(i);
		}
		
		for (int j: nums) {
			if (SloppyPrimer.isPrime(j)) {
				System.out.println(j);
			}
		}
	}
	
}
