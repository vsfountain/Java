package com.question.q09;

import java.util.ArrayList;

public class Main {
	// arraylist stores number from 1 - 100
	// prints out prime numbers to the console
	
	static ArrayList<Integer> numberList = new ArrayList<Integer>();
	static ArrayList<Integer> primeList = new ArrayList<>();
	
	public static void main(String[] args) {
		createArrayList(100);
		findPrime(numberList);
		printPrime(primeList);
	}
	
	public static void createArrayList(int maxValue) {
		for(int i = 1; i <= maxValue; i++) {
			numberList.add(i);
		}
		
	}
	
	public static void findPrime(ArrayList<Integer> array) {
		
		for(int num: array) {
			boolean prime = true;
			int sqroot = (int) Math.round(Math.sqrt(num));
			//System.out.println("Number is : " + num + "\t sqroot is " + sqroot);
			
			for(int i = 2; i <= sqroot; i++) {
				if(num % i == 0) {
					prime = false;
					break;
				}
			}
			
			if(prime) {
				primeList.add(num);
			}
			
		}
	}
	
	public static void printPrime(ArrayList<Integer> array) {
		System.out.println("The prime numbers from 1 to 100 are: " + array);
	}
}
