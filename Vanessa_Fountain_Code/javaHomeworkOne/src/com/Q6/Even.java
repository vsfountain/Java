package com.Q6;
/*
 * Write a program to determine 
 * if an integer is even without using the modulus operator (%)
 */
public class Even {
	
	public static boolean isEven(int n){
		if( n == 2*(n/2)){
			return true;
		}
		return false;	
	}
	
	
	public static void main(String[] args) {
		int N = -2;
		
		System.out.println(isEven(N));
	}

}
