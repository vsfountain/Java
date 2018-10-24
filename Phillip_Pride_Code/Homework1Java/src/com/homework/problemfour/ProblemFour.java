package com.homework.problemfour;

public class ProblemFour {

	public static void main(String[] args) {
		System.out.println(factorial(5));

	}
	
	public static int factorial(int num) {
		if(num==1) {// base case for end of recursion
			return num;
		}
		else
			return num * factorial(num-1); // recursive call to 
											//method that decrements num 
	}

}
