package com.question.q10;

public class Main {
	public static void main(String[] args) {
			int x = 9;
			int y = 5;
			
			System.out.println(returnMin(x,y));
	}
	
	public static int returnMin(int x, int y) {
		return x < y ? x : y;
	}
}
