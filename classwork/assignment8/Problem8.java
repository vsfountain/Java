package com.assignment8;

import java.util.ArrayList;

public class Problem8 {
	
	public static void main(String[] args) {
		ArrayList<String> str = new ArrayList();
		String[] strings = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		for (String stringName : strings) {
			str.add(stringName);
		}
		ArrayList<String> pal = new ArrayList();//iterates through original arrayList and
		for (String stringName : strings) {//returns an array list of palindromes
			if(isPalindrome(stringName)) {
				pal.add(stringName);				
			}
		}
		System.out.println("Original list is\n" + str);
		System.out.println("Palindrome only list is\n" + pal);
	}		
	static boolean isPalindrome(String str){		
		for(int i = 0;i<str.length(); i++) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}			
		}
		return true;
	}	
}
