package com.corejava.questionq10;

public class Ternary {
	
	static int one = 0;
	static int two = 0;
	
	public static void main(String[] args) {
		minimum(12,13);//will return 12
		
		//TODO: try the above function with different values to test functionality
			
	}
	
	static void minimum(int a, int b) {
		int minimum = a > b ?  b: a;//Ternary operator implementation
		System.out.println(minimum);//return lowest of two integers
	}
}
