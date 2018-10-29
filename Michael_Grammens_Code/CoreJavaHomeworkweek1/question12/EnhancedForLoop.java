package com.homework.question12;

public class EnhancedForLoop {
	public static void main(String[] args) {
		int[] myIntArray = new int[100];
		for(int i = 0; i<100; i++) {
			myIntArray[i] = i+1;
		}
		for(int j : myIntArray) {
			if(j%2==0) {
				System.out.print(j + " ");
			}
		}
	}
}
