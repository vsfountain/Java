package com.homework.question8;

import java.util.*;
public class PalindromesArrayList {
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		ArrayList<String> myListPalindromes = new ArrayList<String>();
		//For the record, I would add these names to a file, and just read them in 1 at a time. Not sure if that would be a problem so I didn't
		myList.add("karan");
		myList.add("madam");
		myList.add("tom");
		myList.add("civic");
		myList.add("radar");
		myList.add("sexes");
		myList.add("jimmy");
		myList.add("kayak");
		myList.add("john");
		myList.add("refer");
		myList.add("billy");
		myList.add("did");
		for(int i = 0; i < myList.size(); i++) {
			String reversed = new StringBuilder(myList.get(i)).reverse().toString();
			if(reversed.equals(myList.get(i))) {
				myListPalindromes.add(myList.get(i));
			}
		}
		
		System.out.println("The entire ArrayList is: " + myList + "\nThe list of Palindromes is: " + myListPalindromes);
	
	}
}
