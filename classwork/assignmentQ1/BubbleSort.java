package com.assignmentQ1;

import java.util.*;
public class BubbleSort {
	public static void main(String[] args) {		
		int[] testArray = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println(Arrays.toString(bubbleSorted(testArray))); 
	}
	
	public static void swap(int[] holderArr, int pos1, int pos2) {
		int swapper = holderArr[pos1];//holds the first position of the array
		holderArr[pos1] = holderArr[pos2];
		holderArr[pos2] = swapper; 		
	}
	
	public static int[] bubbleSorted(int[] mainArray) {
		int swapCounter = 6;  //assign swapcounter to any non 0 integer		
		while (swapCounter != 0) {
			swapCounter = 0;
			for (int i = 0; i <mainArray.length -1;i++) {
				
				if(mainArray[i + 1] < mainArray[i]) {
					swap(mainArray, i, (i + 1));
					swapCounter ++;
				}
			}
		}		
		return mainArray;
	}		
}
