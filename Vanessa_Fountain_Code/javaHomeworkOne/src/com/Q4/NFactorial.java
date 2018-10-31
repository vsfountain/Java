package com.Q4;

public class NFactorial {
	static int factorial(int N) {
		int i = 1;
		for (int k = 1; k<=N ; k++) {
			i *= k;
			//System.out.println(i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		int N = 2;
		System.out.println(factorial(N));
	}

}
