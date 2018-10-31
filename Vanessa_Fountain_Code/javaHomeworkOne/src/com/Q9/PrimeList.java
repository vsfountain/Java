package com.Q9;

import java.util.ArrayList;



public class PrimeList {
	
	public static boolean CheckIfPrime(int N) {
		
		for (int i=2; i<N; i++) {
			if (N%i == 0) {
				return true;
				}
		}
		return false;	
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(); 
		ArrayList<Integer> arrPrime = new ArrayList<Integer>();
		for(int i = 0; i<=100;i++) {
			arr.add(i);
			if(CheckIfPrime(i) == true){
				arrPrime.add(i);
				}
			}
		System.out.println(arrPrime);
		}
		
}

