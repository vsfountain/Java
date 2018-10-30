package com.integer.array;

public class BubbleSort {

	public static void BubbleSort(int[] myBubble) {
		boolean needNextPass = true;
		for (int k = 1; k < myBubble.length && needNextPass; k++) {
			// Array may be sorted and next pass not needed
			needNextPass = false;
		}
		// Perform the kth pass
		for (int i = 0; i < myBubble.length - 1; i++) {
			if (myBubble[i] > myBubble[i + 1]) {
				// swap list [i] with list [i+1];
				     int temp = myBubble[i];
		          myBubble[i] = myBubble[i + 1];
		          myBubble[i + 1] = temp;
		          
		          needNextPass = true; // Next pass still needed
		        }
		      }
		    }
		  
/** A test method */
		  public static void main(String[] args) {
			  int[] myBubble = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };		    
			  BubbleSort(myBubble);
		    for (int i = 0; i < myBubble.length; i++)
		      System.out.print(myBubble[i] + " ");
		    }
		  }