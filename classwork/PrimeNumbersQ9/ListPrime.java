package com.PrimeNumbersQ9;

import java.util.ArrayList;

//control shift o to auto import

public class ListPrime {

	public static void main(String[] args){
		//System.out.println(isPrime(97));
		ArrayList <Integer> nums = new ArrayList<>();//store all number from 1 to 100
		for (int i = 1;i<=100;i++) {
			nums.add(i);
		}
		for(int idx :nums) {
			if (isPrime(idx)) {//prints out all prime numbers to console
				System.out.println(idx);
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if(num < 2) {
			return false;
		}
		for (int i = 2; i< num; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;		
	}
}


