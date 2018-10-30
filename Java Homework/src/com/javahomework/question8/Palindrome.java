package com.javahomework.question8;

//hehehe yes sir....i did not forget

import com.javahomework.question3.reverseString;

import java.util.ArrayList;

public class Palindrome {

	public static ArrayList<String> words = new ArrayList<String>();
	public static ArrayList<String> palindromes = new ArrayList<String>();

	public static void addwords() {
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("wow");
	}

	public static void iterate() {
		reverseString r = new reverseString();
		for (String s : words) {
			if (r.reverse(s).equals(s)) {
				palindromes.add(s);
			}
		}
		System.out.println(words);
		System.out.println(palindromes);

	}

	public static void main(String[] args) {
		addwords();
		iterate();

	}

}
