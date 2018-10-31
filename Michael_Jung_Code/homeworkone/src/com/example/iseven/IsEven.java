package com.example.iseven;

public class IsEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 5;
		System.out.println(isEven(8));
		
		
	}
	
	public static boolean isEven(int a) {
		
		int b = a - 1;
		a = a/2;
		b = b/2;
		if(a == b) {
			return false;
		}
		
		return true;
		
		
		
	}
	
	

}
