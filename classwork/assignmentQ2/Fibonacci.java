package com.assignmentQ2;

import java.util.*;
public class Fibonacci {	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(fibSequence()));
	}
	
	public static int[] fibSequence() {
		int[] fibArr = new int[25];
		fibArr[0] = 0;
		int previousNum = 1;
		int currentNum = 1;
		fibArr[1] = previousNum;
		fibArr[2] = currentNum;
		int total = 0;		
		for (int i = 3; i<25;i++) {
			total = previousNum + currentNum;
			previousNum = currentNum;
			currentNum = total;
			fibArr[i] = currentNum;
		}		
		return fibArr;
	}
}
