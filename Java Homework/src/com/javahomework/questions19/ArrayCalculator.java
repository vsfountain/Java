package com.javahomework.questions19;

import java.util.ArrayList;

public class ArrayCalculator {
	public static ArrayList<Integer> numbers= new ArrayList<>();
	
	public static void main(String[] args) {
		addValues();
		int total = 0;
		int oddTotal = 0;
		for(int n : numbers) {
			if(n%2==0) {
				total = total + n;
				
			}else 
				oddTotal += n;
		}
		
		System.out.println("Even numbers sum up to be: " + total);
		System.out.println("Odd numbers add up to: " + oddTotal);
		System.out.println(numbers);
	}
	
	private static void addValues() {
		for(int i = 1; i <= 10; i++) {
			numbers.add(i);
		}
	}
}
