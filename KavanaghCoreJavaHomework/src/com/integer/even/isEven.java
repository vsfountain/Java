package com.integer.even;
/**
 * check if a number is even
 * without modulus sign 
 * 
 * @author Kristen Kavanagh
 * @version 10/28/2018
 *
 */

public class isEven {
	// returns true if 
	//comb is even, else odd
	static boolean isEven (int comb) {
		boolean isEven = true;
	for (int i = 1; i <= comb; i++)
		isEven = ! isEven;
	return isEven;
	}
	 //Driver Code 

	public static void main (String args []) {
		{
			int comb = 68; 
			if (isEven (comb))
				System.out.println("Even");
			else
				System.out.println("Odd");
		}		}
}
