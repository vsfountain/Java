package com.hw1.q19;

import java.util.ArrayList;

import com.hw1.q09.SloppyPrimer;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question Text
		 * 
		 * Q19. Create an ArrayList and insert integers 1 through 10. 
		 * Display the ArrayList. Add all the even numbers up and 
		 * display the result. Add all the odd numbers up and display 
		 * the result. Remove the prime numbers from the ArrayList and 
		 * print out the remaining ArrayList.
		 * 
		 */

		ArrayList<Integer> nums = new ArrayList<>();
		
		int even = 0;
		int odd = 0;
		
		for (int i=1; i<=10; i++) {
			nums.add(i);
		}
		
		//loop over a copy of the array list so we can remove the primes in the loop
		//next time just use an iterator
		for (int j: new ArrayList<>(nums)) {
			if (j%2 == 0) {
				even+=j;	//adding up the evens
			}else {
				odd+=j;		//adding up the odds
			}
			if (SloppyPrimer.isPrime(j)) {	//primer from Q9
				nums.remove(nums.indexOf(j));
			}
		}

		
		System.out.println("The addition of all even numbers from 1 to 10 is "+even);
		System.out.println("The addition of all odd numbers from 1 to 10 is "+odd);
		System.out.println(nums);
		
		
	}

}
