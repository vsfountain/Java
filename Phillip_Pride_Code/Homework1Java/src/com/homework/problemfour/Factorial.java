package com.homework.problemfour;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(doFactorial(5));

	}
	
	public static int doFactorial(int num) {
		if(num==1) {// base case for end of recursion
			return num;
		}
		else
			return num * doFactorial(num-1); // recursive call to 
											//method that decrements num 
	}

}
