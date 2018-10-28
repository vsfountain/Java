package com.hw1.q04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q4. Write a program to compute N factorial.
		 * 
		 */
		
		String input;
		int number;
		long answer;
		
		Scanner scanner = new Scanner(System.in);
		
		//get n from the user
		System.out.print("Enter a number for n!: ");
		input = scanner.nextLine(); 
		number = Integer.parseInt(input);
		
		answer =  factorial(number);
	
		System.out.println(number+" foctorial is "+answer);
		
		scanner.close();
	}
	
	public static long factorial(long n) {
		//recursivly n * n-1
		//use long for bigger numbers
		if(n>2) {	//don't bother with 1 because n*1=n
			return (n * factorial(n-1));
		}else {		//finally return two
			return n;
		}
	}
}
