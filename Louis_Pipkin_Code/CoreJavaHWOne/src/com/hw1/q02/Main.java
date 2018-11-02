package com.hw1.q02;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q2. Write a program to display the first 25 
		 * Fibonacci numbers beginning at 0.
		 * 
		 */
		
		fibonacci(25);
		fibonacci(70);
	
	}
	
	public static void fibonacci(int iterations) {
		//find nth fib number by adding last two numbers before n
		//recursive fib is a bad idea
		long first = 0; //first number before n
		long second = 0;//second number before n
		long current;
		for (int i=0; i<iterations; i++) {
			if (i == 0) {				//first fib number will always be 0
				System.out.println(0);
				first = 0;
			}else if (i == 1) {			//second fib number will always be 1
				System.out.println(1);
				second = first;			//first becomes second, current becomes first
				first = 1;
			}else {
				current = first + second;
				System.out.println(current);
				second = first;			//first becomes second, current becomes first
				first = current;
			}
		}
	}
}


