package com.example.q9;

import java.util.ArrayList;

public class q9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Integer> a = new ArrayList<>();
		
		for(int i = 0; i<100; i++) {
			
			a.add(i+1);
			
		}
		
		
			
			
		for(int i = 0; i<100; i++) {
			
			boolean isPrime = true;
			for(int j = 2; j<i; j++) {
				
				if(a.get(i)%j == 0) {
					isPrime = false;
				}
				
				
			}
			
			if(isPrime) {
				
				System.out.print(a.get(i) + " ");
			}
			
			
		}
		
		
		
		
		
	}

}
