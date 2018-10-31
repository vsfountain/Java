package com.hw1.q_4;

//Q4. Write a program to compute N factorial.

public class Main {
	
	static int factorial(int n) 
    { 
        int res = 1, i; 
        for (i=2; i<=n; i++) 
            res *= i; 
        return res; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5; 
        System.out.println("Factorial of "+ num + " is " + factorial(5));
	}

}
