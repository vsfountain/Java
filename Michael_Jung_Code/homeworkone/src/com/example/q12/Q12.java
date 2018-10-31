package com.example.q12;

public class Q12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] a = new int[100];
		
		
		for(int i = 0; i<100; i++) {
			a[i] = i+1;
			
		}
		
		for(int aa: a) {
			if(aa %2 == 0) {
			System.out.print(aa + " ");
			}
		}
		
		
		
	}

}
