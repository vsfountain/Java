package com.hw1.q_6;

//Q6. Write a program to determine if an integer 
//is even without using the modulus operator (%)

public class Main {
	static boolean isEven(int n) {
		boolean isEven = true;
		
		for (int i = 1; i <=n; i++)
			isEven = !isEven;
		return isEven;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2;
		int y = 3;
		if(isEven(x))
			System.out.println("Even");
		else
			System.out.println("Odd");
		
	}

}
