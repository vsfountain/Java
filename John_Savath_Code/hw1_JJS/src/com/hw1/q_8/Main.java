package com.hw1.q_8;

import java.util.ArrayList;
import java.util.Collections;


//Q8. Write a program that stores the following strings in an ArrayList 
//and saves all the palindromes in another ArrayList.

//“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, 
//“jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names=new ArrayList<String>();
		ArrayList<String> palindrome = new ArrayList<String>();

		
		names.add("karan");
		names.add("madan");
		names.add("tom");
		names.add("civic");
		names.add("radar");
		names.add("sexes");
		names.add("jimmy");
		names.add("kayak");
		names.add("john");
		names.add("refer");
		names.add("billy");
		names.add("did");
		
		System.out.println(names);
		palindrome = names;
		
		StringBuilder reverse = new StringBuilder();
		reverse.append(names);
		reverse.reverse();
		

		System.out.println(reverse);

	}
	


}
