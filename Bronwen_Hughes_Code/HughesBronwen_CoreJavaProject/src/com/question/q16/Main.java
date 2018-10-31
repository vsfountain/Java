package com.question.q16;

public class Main {
	public static void main(String[] args) {
		
		String s = "";
		
		for(String str: args) {
			s += str;
		}
		
		char[] c = s.toCharArray();
		System.out.println("There are " + c.length + " characters within this string");
	} 
}
