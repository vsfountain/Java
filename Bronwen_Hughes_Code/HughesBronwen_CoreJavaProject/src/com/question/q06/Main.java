package com.question.q06;

public class Main {
	public static void main(String[] args) {
		int x = -Integer.MAX_VALUE;

		System.out.println(x/2);
		System.out.println(((double)x)/2);
		System.out.println((double)(x/2 - (double)x/2));
		if((double)(x/2 - (double)x/2) == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
	}
}
