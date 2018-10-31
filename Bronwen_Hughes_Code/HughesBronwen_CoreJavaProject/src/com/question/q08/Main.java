package com.question.q08;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		String[] strArray = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArray));
		ArrayList<String> palinList = new ArrayList<String>();
		
		checkIfPalin(list, palinList);
		
		for(String s:palinList) {
			System.out.println(s);
		}
	}
	
	static void checkIfPalin(ArrayList<String> list, ArrayList<String> palinList) {
		for(String s: list) {
			String newS = new StringBuilder(s).reverse().toString();
			if(s.equals(newS)) {
				palinList.add(s);
			}
		}
	}
}