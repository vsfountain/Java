package com.question.q19;

import java.util.ArrayList;

public class Main { 

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			array.add(i);
		}

		System.out.println(array);

		int ans = 0;
		for (int i = 1; i <= 10; i += 2) {
			ans += array.get(i);
		}
		
		System.out.println("Sum of odd numbers from 1 to 10: " + ans);
		
		ans = 0;
		for (int i = 0; i <= 9; i += 2) {
			ans += array.get(i);
		}
		
		System.out.println("Sum of even numbers from 1 to 10: " + ans);
		
		prime(array);
		

	}

	static void prime(ArrayList<Integer> array) {
		ArrayList<Integer> primeList = new ArrayList<>();
		for(int num: array) {
			boolean prime = true;
			int sqroot = (int) Math.round(Math.sqrt(num));
			
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
		
		System.out.println("Prime numbers are: " + primeList);
	}
	
}
