package com.homework.question3;

import java.util.*;

public class reverseString {
	public static void main(String[] args) {
		System.out.println("Enter string you wanted reversed");
		Scanner currString = new Scanner(System.in);
		try {
			String revString = currString.nextLine();
			for(int i = revString.length()-1; i >= 0; i--) {
				revString+=revString.charAt(i);
			}
			System.out.println(revString.substring(revString.length()/2));
			
		}
		catch(Exception e){
			System.out.println("Thats the wrong input, try an integer please.");
		}
		currString.close();
	}
}
