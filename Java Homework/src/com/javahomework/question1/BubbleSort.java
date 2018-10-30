package com.javahomework.question1;

public class BubbleSort {

	public static void main(String[] args) {
		//initialize array
		int[] temp = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		bubbleSort(temp); // method call to sort the above array
		printArray(temp); // print the array at its current state (which should be sorted at this point)
	}

	public static void printArray(int[] temp) {
		//iterate through temporary array passed
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + "|"); // print every element of the array 
		}
	}

	/* Takes in an array argument 
	 * 
	 * 
	 */
	static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}

	}

}