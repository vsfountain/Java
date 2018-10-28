package com.hw1.q10;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q10. Find the minimum of two numbers using ternary operators.
		 */
		int x = 9;
		int y = 5;
		
		System.out.println("Minimum of "+x+" and "+y+" is "+getMinimum(x, y));
	}
	
	public static int getMinimum(int a, int b) {
		return a<b ? a : b;
	}
}
