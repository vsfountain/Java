package com.javahomework.question4;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factorial(4);
	}

	static void factorial(int num) {
		int total = 0;
		for (int i = 0; i < num; i++) {
			total += num * i;
		}
		System.out.println(total);
	}
}