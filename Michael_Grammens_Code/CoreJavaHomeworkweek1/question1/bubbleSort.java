package com.homework.question1;

import java.util.*;
public class bubbleSort {
	private static int[] myArray = {1,0,5,6,3,2,3,7,9,8,4};
	public static void main(String[] args) {
		myFunction();
		System.out.println(Arrays.toString(myArray));
	}
	
	public static void myFunction() {
		for(int i = 0; i < myArray.length; i++) {
			for(int j = i+1; j < myArray.length; j++) {
				if(myArray[i] > myArray[j]) {
					int placeHolder = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = placeHolder;
				}
			}
		}
	}
}
