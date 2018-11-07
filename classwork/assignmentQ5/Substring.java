package com.assignmentQ5;

public class Substring {
	
	public static void main(String[] args) {
		String testString = "Testing string here";
		sub(testString, 5);		
	}	
	
	public static void sub(String s, int idx) {
		String editme = "";
		for(int i = 0; i<idx;i++) {
			 editme += s.charAt(i);
		}
		System.out.println(editme);		
	}
}