package com.example.q2;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 0;
		int b = 1;
		
		//temp is the placeholder for int b when I calculate the sum
		int temp = 0;
		for(int i = 0 ; i< 25; i++) {
			
			if(i == 0) {
				System.out.print(a + " ");
			} else if (i == 1) {
				System.out.print(b + " ");
			} else {
				
				temp = a + b;
				a = b;
				b = temp;
				
				System.out.print(temp + " ");
				
				
			}
			
			
			
			
		}

	}

}
