package com.homework.question5;

import java.util.*;

public class substringConverter {
	public static void main(String[] args) {
		System.out.println("Enter your string, followed by an integer (substring cutoff point). Format Hello 5");
		Scanner input = new Scanner(System.in);
		try {
			String wholeInput = input.nextLine();
			String[] wholeInputArray = wholeInput.split(" ");
			String stringInput = wholeInputArray[0];
			int intInput = Integer.parseInt(wholeInputArray[1]);
			System.out.println(subString(stringInput, intInput));
		}
		catch(Exception e){
			System.out.println("Thats the wrong input, try again please using the format type.");
		}
		input.close();
	}
	
	public static String subString(String str, int idx) {
		String newString = "";
		for(int i = 0; i < idx; i++) {
			newString+= str.charAt(i);
		}
		return newString;
	}
}
