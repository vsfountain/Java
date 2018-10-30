package com.javahomework.question2;

/* This program will display
 * the first 25 Fibonacci
 * numbers starting at 0. 
 */
public class Fibonnaci {

	static int [] fib = new int[25];
	
	public static void printArray(int[] temp) {
		//iterate through temporary array passed
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + "|"); // print every element of the array 
		}
	}
	
	public static void fibLogic() {
		fib[0]=0;
		fib[1] = 1;
		for(int i = 1; i < fib.length-1; i++) {
			fib[i+1] = fib[i]+fib[i-1];
			
		}
		
	}
	
	public static void main(String [] args) {
		fibLogic();
		printArray(fib);
		
	}
	
	
}