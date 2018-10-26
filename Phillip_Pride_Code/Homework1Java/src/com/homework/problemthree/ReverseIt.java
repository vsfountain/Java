package com.homework.problemthree;

public class ReverseIt {
	
	public static void main(String[] args) {
		String word = new String("Clutch");
		System.out.println(word);
		System.out.println("REVERSE!!!!");
		
		for(int i = word.length()-1; i>=0;i--) {
			word+= word.charAt(i); // adds the reverse of the initial word to the end of the String
		}
		
		word = word.substring(word.length()/2); // slices the String in half so that only the reverse of the word remains
		System.out.println(word);
		
	}

}
