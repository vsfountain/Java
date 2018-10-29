package com.corejava.question5;

public class Substring {
/*Write a substring method that accepts a string str and an integer idx and returns the
substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
substring methods in the String, StringBuilder, or StringBuffer APIs.*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subString("word", 5));
	}
	
	static String subString(String str, int idx) {
		char [] word = new char [str.length()];
		String result = "";
		for(int i =0; i < idx-1; i++) {
			word[i] = str.charAt(i);
			result += word[i];
		}
		
		return result;
	}

}
