package com.Q10;

public class TwoMin {
	public static int twoNum(int num1, int num2) {
		int N = (num1 < num2) ? num1 : num2;
		
		return N;
	}

	public static void main(String[] args) {
		System.out.println(twoNum(4,8));
	}

}
