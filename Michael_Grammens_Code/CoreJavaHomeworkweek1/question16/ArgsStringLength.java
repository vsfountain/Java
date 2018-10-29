package com.homework.question16;

public class ArgsStringLength {
	public static void main(String[] args) {
		String totalArgs = "";
		for(int i = 0; i < args.length;i++) {
			totalArgs += args[i];
		}
		System.out.println("There is a total of " + totalArgs.length() + " characters in the string.");
	}
}
