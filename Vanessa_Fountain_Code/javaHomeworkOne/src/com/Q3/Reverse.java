package com.Q3;
/*
 * getChars( )Copies characters from this string into the destination character array. 
 */

public class Reverse {
	static String reverse(char[] ch){
		String str = null;
		int last = ch.length-1;
		for (int i = 0; last>=i; last--) {
			str += ch[last];
		}
		return str.substring(4, str.length());
	}
	
	
	public static void main(String[] args) {
		String s = "Hello World";
		int last = s.length();
		char[] arr = new char[last];
		s.getChars(0, last, arr, 0);
		//System.out.println(arr);
		
		System.out.println(reverse(arr));		
	}
}
