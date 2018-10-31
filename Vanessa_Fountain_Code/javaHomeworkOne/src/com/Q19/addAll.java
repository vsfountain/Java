package com.Q19;

import java.util.ArrayList;
import com.Q9.*;
import com.Q6.*;


/*
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
 * Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList
 */


public class addAll extends PrimeList{
	
	//private static final int Integer = 0;

	public static void removePrime(ArrayList<Integer> arr) {
		//PrimeList prime = new PrimeList();
		
		for(int p = 0; p<arr.size();p++) {
			
			if (PrimeList.CheckIfPrime(arr.get(p))==false) {
				arr.remove(p);
				//System.out.println(arr);
			}
		}
		System.out.println(arr);
	}
	
	public static void addEven(ArrayList<Integer> arr) {
		int even = 0;
		for(int p = 0; p<arr.size();p++) {
					
			if (Even.isEven(arr.get(p))==true) {
				even+=arr.get(p);
				//System.out.println(even);
			}
		}
		System.out.println(even);
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(Integer i=1;i<=10;i++) {
			arr.add(i);
			//System.out.println(arr);
		}
		addOdd(arr);
		removePrime(arr);
		addEven(arr);
		
	}

	static void addOdd(ArrayList<Integer> arr) {
		int odd = 0;
		System.out.println(arr);
		for(int p = 0; p<arr.size();p++) {		
			if (Even.isEven(arr.get(p))==false) {
				odd+=arr.get(p);
				
				//System.out.println(odd);
			}
		}
		System.out.println(odd);
		
	}

}
