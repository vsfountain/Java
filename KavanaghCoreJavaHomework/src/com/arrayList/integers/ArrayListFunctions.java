package com.arrayList.integers;

import java.util.Arrays;

/**
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
 * Add all the even numbers up and display the result. Add all the odd numbers
 * up and display the result. Remove the prime numbers from the ArrayList and
 * print out the remaining ArrayList.
 *
 * @author KristenKavanagh
 *
 */
public class ArrayListFunctions {

	public ArrayListFunctions() {

	}

	public static void main(String[] args) {
		int[] arrayList = { 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
		int even = 0, odd = 0;
		for (int a = 0; a < arrayList.length; a++) {
			if (a % 2 == 0)
				even += arrayList[a];
			else
				odd += arrayList[a];

		}

		System.out.println("Display of the ArrayList:" + Arrays.toString(arrayList));
		System.out.println("Even number sum:" + "" + even);
		System.out.println("Odd number sum:" + "" + odd);
	}
}
