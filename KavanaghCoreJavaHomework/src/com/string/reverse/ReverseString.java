package com.string.reverse;

public class ReverseString {

	public static void main(String[] args) {
		String home = "Garage";
		// convert string to character array
		char[] convt = home.toCharArray();
		for (int i = convt.length - 1; i >= 0; i--)
			System.out.print(convt[i]);
	}

}


