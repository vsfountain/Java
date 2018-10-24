package com.homework.problemsix;

public class ProblemSix {
	public static void main(String[] args) {
		evenOrOdd(4);
		evenOrOdd(27);
		evenOrOdd(12);
	}

	public static void evenOrOdd(int num) {
		if ((num / 2) * 2 == num) {
			System.out.println(num + " is even.");
		} else {
			System.out.println(num + " is odd.");
		}
	}
}
