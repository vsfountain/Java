package com.question.q12;

public class Main {
	public static void main(String[] args) {
		int[] numArray = new int[100];
		
		for(int i = 1; i <= 100; i++) {
			numArray[i - 1] = i;
		}
		
		for(int num: numArray) {
			if(numArray[num - 1] % 2 == 0) {
				System.out.println(num);
			}
		}
	}
}
