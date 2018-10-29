package com.homework.question18;

import java.util.*;
public class ConcreateClass extends SuperClass{
	
	@Override
	public boolean anyUpperCase(String findUpper) {
		for(int i = 0; i < findUpper.length(); i++) {
			if(Character.isUpperCase(findUpper.charAt(i))==true) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String lowerCaseToUpper(String inputString) {
		inputString = inputString.toUpperCase();
		return inputString;
	}
	
	@Override
	public int convertString(String myString) {
		int countChars = 0;
		for(int i = 0; i < myString.length(); i++) {
			countChars += myString.charAt(i);
		}
		countChars += 10;
		return countChars;
	}
}
