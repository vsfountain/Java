package com.corejava.question3;

public class Main {
	public static void main(String[] args) {
		reverseString r = new reverseString();
		String toBeReversed = "Somehow This worked";
		System.out.print("The initial String is: " + toBeReversed + "\nThe reversed String is: ");
		System.out.println(r.reverse(toBeReversed));
		
		
	}
}
