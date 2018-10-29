package com.corejava.question9;

import java.util.ArrayList;

/* 
 * Create an ArrayList which stores numbers from 1 to 100
 *  and prints out all the prime numbers to the console.
 */
public class PrimeNumbers {
	static public ArrayList<Integer> num = new ArrayList<Integer>();
	boolean isPrime = false;

	public static void main(String[] args) {
		addValuesToArrayList();
		//removeEvens();
		System.out.println(num);
		System.out.println(num.size());
	}

	static boolean checkPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static void addValuesToArrayList() {
		for (int i = 1; i <= 100; i++) {
			if(checkPrime(i))num.add(i);

		}
	}

}
