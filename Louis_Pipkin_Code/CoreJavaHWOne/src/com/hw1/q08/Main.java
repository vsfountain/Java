package com.hw1.q08;

import java.util.ArrayList;

import com.hw1.q03.MyStringMethods;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q8. Write a program that stores the following strings 
		 * in an ArrayList and saves all the palindromes in another 
		 * ArrayList. 
		 * 
		 * "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", 
		 * "kayak", "john", "refer", "billy", "did"
		 * 
		 */
		
		String[] names = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> arrlNames = new ArrayList<>();
		ArrayList<String> arrlPals = new ArrayList<>();
		
		//populating arrlNames with names array
		for (int i=0; i<names.length; i++) {
			arrlNames.add(names[i]);
		}
		
		for (String s: arrlNames) {
			//System.out.println(s);
			if(isPalindrom(s)) {
				arrlPals.add(s);
			}
		}
		
	}
	
	public static boolean isPalindrom(String word) {
		//if the string is equal to its reverse, return true
		if (word.equals(MyStringMethods.revString(word))) {	//modularize! from Q3
			System.out.println(word);
			return true;
		}else {
			return false;
		}
	}
	
}
