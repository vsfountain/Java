package com.assignmentQ6;

public class IsEven {
	
	public static void main(String[] args) {
		isEven(16);
	}
	
	public static void isEven(int num) {
		int half = num/2;
		
		if(half * 2 == num) {
			System.out.println("This number is even");
		}
		else {
			System.out.println("This number is odd");
		}		
	}
}
