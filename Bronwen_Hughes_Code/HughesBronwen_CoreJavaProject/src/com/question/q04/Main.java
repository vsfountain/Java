package com.question.q04;

// compute N factorial 
public class Main {

	/*
	 * 5! = 5*4*3*2*1 5! = 5*4! Factorial(n) = n * Factorial(n-1);
	 */

	public static int Factorial(int n) {
		if (n > 1) {
			n *= Factorial(n - 1);
			return n;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		int x = 6;
		System.out.println("Factorial " + x + " is: " + Factorial(x));
	}

}
