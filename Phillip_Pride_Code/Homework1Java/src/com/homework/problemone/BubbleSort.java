package com.homework.problemone;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arryOne = {1,0,5,6,3,2,3,7,8,9,4};
		System.out.print("Before sorting: ");
		for(int i: arryOne)// For each loop that prints out the array
			System.out.print(i + " "); // before bubble sort is applied
		
		bubbleSort(arryOne);
		
		System.out.print("\nAfter sorting: ");
		for(int i: arryOne)// For each loop that prints out the array
			System.out.print(i + " "); // after bubble sort is applied
		
		
	}
	
	public static void bubbleSort(int[] arry) {
		int swapCnt = -2; // non-zero integer to begin while loop
		while(swapCnt != 0) {
			swapCnt = 0;
			for(int i=0; i<arry.length-1; i++) {
				if(arry[i]>arry[i+1]) {
					int temp = arry[i]; //Swap the two adjacent numbers 
					arry[i] = arry[i+1];// using a temporary 3rd variable
					arry[i+1] = temp;   // if they are out of order
					swapCnt++;
				}
			}
		}
	}
}
