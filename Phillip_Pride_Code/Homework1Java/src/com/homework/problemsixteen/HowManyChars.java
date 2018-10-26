package com.homework.problemsixteen;

public class HowManyChars {

	public static void main(String[] args) {
		int cnt = 0;
		for(String s: args) {
			for(int i = 0; i < s.length(); i++)
			cnt++;
		}
		System.out.println("The entered string has " + cnt + " characters.");
	}

}
