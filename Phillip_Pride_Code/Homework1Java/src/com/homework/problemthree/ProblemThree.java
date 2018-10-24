package com.homework.problemthree;

public class ProblemThree {
	
	public static void main(String[] args) {
		String word = new String("Clutch");
		System.out.println(word);
		System.out.println("REVERSE!!!!");
		System.out.println(reverseString(word));
	}
	
	public static String reverseString(String s) {
		String revS = new String("");
		for(int i = 0; i<s.length()/2;i++) {
			//System.out.println(i);
			s.charAt(i) = s.charAt(s.length(-i));
		}
		
		/*for(int i = s.length()-1; i>=0;i--) {
			//System.out.println(i);
			revS+= s.charAt(i);
		}*/
		
		return revS;
	}

}
