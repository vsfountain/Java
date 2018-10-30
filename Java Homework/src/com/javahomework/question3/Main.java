package com.javahomework.question3;

public class Main {
	public static void main(String[] args) {
		reverseString r = new reverseString();
		String toBeReversed = "tseb ma i";
		System.out.print("The initial String is: " + toBeReversed + "\nThe reversed String is: ");
		System.out.println(r.reverse(toBeReversed));

	}
}
