package com.assignmentQ13;

public class Pyramid {
	
	public static void main(String[] args) {
		int zero = 0;
		int one =1;
		int counter = 4;
		while (counter >=0) {
			if(counter == 4) {
				System.out.println(zero);
			}
			if(counter == 3) {
				System.out.println(one + " " + zero);
			}
			if(counter == 2) {
				System.out.println(one + " " + zero + " " + one);
			}
			if(counter == 1) {
				System.out.println(zero + " " + one + " " + zero + " " + one);
			}
			counter--;
		}		
	}
}
