package com.homework.problemfive;

public class Substring {

	public static void main(String[] args) {
		System.out.println(mySubstring("garurumon", 5));
		System.out.println(mySubstring("blaziken", 3));
		System.out.println(mySubstring("gesundheit", 8));

	}

	static String mySubstring(String str, int idx) {
		String newString = "";
		
		for(int i = 0; i < idx; i++) { 
			newString+= str.charAt(i);
		}
		return newString;
	}
}
