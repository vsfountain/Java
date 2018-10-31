package com.hw1.q_1;

//

public class BubbleSort {
	void bubbleSort(int arl[]) 
	 { 
	     int n = arl.length; 
	     for (int i = 0; i < n-1; i++) 
	         for (int j = 0; j < n-i-1; j++) 
	             if (arl[j] > arl[j+1]) 
	             { 
	                 // swap temp and arr[i] 
	                 int temp = arl[j]; 
	                 arl[j] = arl[j+1]; 
	                 arl[j+1] = temp; 
	             } 
	 } 

	 /* Prints the array */
	 void printArray(int arl[]) 
	 { 
	     int n = arl.length; 
	     for (int i=0; i<n; ++i) 
	         System.out.print(arl[i] + " "); 
	     System.out.println(); 
	 } 

	 // Driver method to test above 
	 public static void main(String args[]) 
	 { 
	     BubbleSort input = new BubbleSort(); 
	     int arl[] = {1,0,5,6,3,2,3,7,9,8,4}; 
	     input.bubbleSort(arl); 
	     System.out.println("Sorted array"); 
	     input.printArray(arl); 
	 } 

}


//Java program for implementation of Bubble Sort 
