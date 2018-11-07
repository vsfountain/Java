package com.assignmentQ4;

public class Factorialize {
	
	public static void main(String[] args) {		
		System.out.println(factorial(6));
	}
	
	public static int factorial(int n) {		
		if(n == 0) {//if n can't be factored any more end the recursive loop
			return 1;
		}
		return n * factorial(n - 1);		
	}
}
