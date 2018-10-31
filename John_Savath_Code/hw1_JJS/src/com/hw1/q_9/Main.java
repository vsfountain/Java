package com.hw1.q_9;

import java.util.ArrayList;


//Q9. Create an ArrayList which stores numbers from 1 to 100 
//and prints out all the prime numbers to the console.

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arl=new ArrayList<Integer>();
		
		//add 100 numbers to arraylist
		for (int i = 0; i<101; i++) {
			arl.add(i);
			
			boolean isPrimeNumber = true;
			
			
			// use isPrimeNumber boolean value to "break" the inner loop and 
			//pass the value only if the number is prime
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrimeNumber = false;
					break; // exit the inner for loop
				}
			}
						
			// print the value if the number is prime
			if (isPrimeNumber) {
				System.out.print(i + " ");
			}
		}


	}
}
