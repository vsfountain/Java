package com.Q8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Write a program that stores the following strings in an ArrayList 
 * and saves all the palindromes in another ArrayList.
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, 
 * “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
 */

public class Palindromes {
	static File filename = new File("./NamesList");
	static ArrayList<String> arr = new ArrayList<String>();
	static ArrayList<String> palindromes = new ArrayList<String>();
	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(filename);
		
		while(scan.hasNext()) {
			arr.add(scan.next());
		}
		palindromes(arr);
	}
	
	public static boolean palindromeChecker(String word) {
		System.out.println(word);
		for(int i = 1; i<word.length()/2;i++) {
			if(word.charAt(i) != word.charAt(word.length()-i -1)) {
				System.out.println(word.charAt(i));
				System.out.println(word.charAt(word.length()-i -1));
				return false;
			}
			else {
				i++;
			}
		}
		return true;
	}
	
	public static void palindromes(ArrayList<String> arr2) {
		ArrayList <String> palindromes = new ArrayList();
		for (int i = 0; i<arr.size(); i++) {
			String word = arr2.get(i);
			if(palindromeChecker(word) == true) {
				palindromes.add(word);
				
			}
		}
		System.out.println(palindromes);
		
	}

}
