package com.homework.problemtwo;

public class ProblemTwo {

	public static void main(String[] args) {
		int[] fibo = new int[25];// creates an array to house fibonacci numbers
		fibo[1] = 1; // Initializes the second fibonacci number
						// the first number is already set to 0 by default

		for (int i = 2; i < fibo.length; i++)
			fibo[i] = fibo[i - 1] + fibo[i - 2];

		for (int i : fibo)// For each loop that prints out the array
			System.out.print(i + " ");

	}

}
