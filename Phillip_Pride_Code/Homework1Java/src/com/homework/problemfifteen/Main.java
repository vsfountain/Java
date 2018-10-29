package com.homework.problemfifteen;

public class Main {

	public static void main(String[] args) {
		int a = 7;
		int b = 25;
		System.out.println(new DoMath().add(a, b));
		System.out.println(new DoMath().subtract(b, a));
		System.out.println(new DoMath().multiply(a, b));
		System.out.println(new DoMath().divide(b, a));

	}

}
