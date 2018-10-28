package com.hw1.q12;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q12. Write a program to store numbers from 1 to 100 
		 * in an array. Print out all the even numbers from the array. 
		 * Use the enhanced FOR loop for printing out the numbers.
		 */
		
		int[] numArray = new int[100];
		
		//populate the array with 1 - 100
		for (int i=0; i<100; i++) {
			numArray[i] = i + 1;
		}
		
		for(int j: numArray) {			//this is the enhanced FOR loop syntax
			if (j%2 == 0) {				//even
				System.out.println(j);
			}
		}
	}
}
