package com.example.fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0;
		int b = 1;
		
		for(int i = 0; i<25; i++) {
			
			if(i == 0) {
				System.out.print(a + " ");
			} else if (i == 1){
				System.out.print(b + " ");
				
			} else {
				System.out.print(a + b + " ");
				int aa = a;
				a = b;
				b = aa + b;
			}
			
			
			
		}
	}

}
