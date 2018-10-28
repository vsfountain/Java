package com.hw1.q09;

public class SloppyPrimer {
	
	public static boolean isPrime(int n) {
		/*
		 * implementation of the
		 * Sieve of Eratosthenes
		 * 
		 * This logic should be good for the first ~120 primes
		 * check if n is one of the first four primes and then
		 * if n is divisible by one of the first four primes
		 */
		boolean prime = true;
		
		if (n == 2 || n == 3 || n == 5 || n ==7) {
			prime = true;
		}else {
			if(n%2 == 0) {
				prime = false;
			}
			if(n%3 == 0) {
				prime = false;
			}
			if(n%5 == 0) {
				prime = false;
			}
			if(n%7 == 0) {
				prime = false;
			}
		}
		return prime;
	}
	
}
