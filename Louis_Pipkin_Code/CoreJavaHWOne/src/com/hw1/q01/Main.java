package com.hw1.q01;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question Text
		 * 
		 * Q1. Perform a bubble sort on the following integer array:  
		 * 1,0,5,6,3,2,3,7,9,8,4
		 */
		
		int[] tstArray = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.print("Before sort: ");
		printArray(tstArray);
		
		bubbleSort(tstArray);
		
		System.out.print("After sort:  ");
		printArray(tstArray);
	}

	public static void bubbleSort(int[] arr) {
		/*
		 * Bubble sort - loop through collection comparing n, n+1
		 * swap if n>n+1. Continue looping through array until 
		 * no values have been swapped. 
		 */
		boolean sorted = false;
		int x; //temporary variable for the swap
		
		while(!sorted) {
			sorted = true; //flip to false when values are shifted
			
			for(int i=0, j=1; j<arr.length; i++, j++) {
				if (arr[i]>arr[j]) {	//values not in order, need to swap
					//swap index values
					x = arr[i];
					arr[i] = arr[j];
					arr[j] = x;
					//we don't know if it has been completly sorted yet
					sorted = false;
				}
			}
		}
	}
	
	public static void printArray(int[] arr) {		
		//print an array to the console to check state
		//pretty prints an integer array comma separated on one line
		//next time remember toString()!
		for(int i=0; i<arr.length; i++) {
			if (i<arr.length-1) {
				System.out.print(arr[i]+", ");
			}else {
				System.out.println(arr[i]);
			}
		}
	}
}
