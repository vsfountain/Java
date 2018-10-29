package com.corejava.question6;
/*
 * Q6. Write a program to determine 
 * if an integer is even without using
 *  the modulus operator (%)
 */
 
public class NoMod {
	
	public static void main(String[] args) {
		double result = isEven(32);
		String answer = Double.toString(result);
		System.out.println(answer);
		if(answer.endsWith(".0")){System.out.println("tis even");}
		else System.out.println("tis odd");
		
	}
	
	static double isEven(int num) {
		double divided = (double)num/2;
		return divided;
	}

}
