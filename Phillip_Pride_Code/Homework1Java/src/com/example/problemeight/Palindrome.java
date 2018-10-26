package com.example.problemeight;

import java.util.*;

public class Palindrome {

	public static void main(String[] args) {

		ArrayList<String> strArryL = new ArrayList<String>();
		ArrayList<String> palArry = new ArrayList<String>();
		strArryL.add("karan");
		strArryL.add("madam");
		strArryL.add("tom");
		strArryL.add("civic");
		strArryL.add("radar");
		strArryL.add("sexes");
		strArryL.add("jimmy");
		strArryL.add("kayak");
		strArryL.add("john");
		strArryL.add("refer");
		strArryL.add("billy");
		strArryL.add("did");
		System.out.println(strArryL);

		for (int i = 0; i < strArryL.size(); i++) {
			String word = strArryL.get(i);
			for (int j = word.length() - 1; j >= 0; j--) {
				word += word.charAt(j); // adds the reverse of the initial word to the end of the String
			}

			word = word.substring(word.length() / 2); // slices the String in half so that only the reverse of the word
														// remains

			if (strArryL.get(i).equals(word)) {
				palArry.add(word);
			}

		}
		System.out.println(palArry);

	}

}
