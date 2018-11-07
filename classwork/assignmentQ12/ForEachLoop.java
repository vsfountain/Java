package com.assignmentQ12;

public class ForEachLoop {

	public static void main(String[] args) {
		displayNumbers();
	}
	
	public static void displayNumbers() {
		int[] numArr = new int[100];	
		for (int i = 0;i<100;i++) {
			numArr[i]=i + 1;
		}
		for (int element : numArr) {
			System.out.print((element % 2 == 0) ? element:" ");
		}
	}	
}
