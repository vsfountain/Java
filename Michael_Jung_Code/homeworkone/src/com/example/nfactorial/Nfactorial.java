package com.example.nfactorial;

public class Nfactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		nFactorial(5);
		
	}
	
	
	public static void nFactorial(int n) {
		int f = 0;
		for(int i = n; i > 0; i--) {
			
			if(i == n ) {
				f = n;
			} else {
			
				f = f * (f-1);
			}
			
			
		}
		System.out.println(f);
		
	}

}
