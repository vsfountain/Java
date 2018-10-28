package com.hw1.q11;

import com.hw1.floatpackage.*; //this is it

public class Main {

	public static void main(String[] args) {
		/*
		 * Questions text
		 * 
		 * Q11. Write a program that would access two 
		 * float-variables from a class that exists in 
		 * another package. Note, you will need to create 
		 * two packages to demonstrate the solution.
		 * 
		 */
		
		MyFloats f = new MyFloats();
		
		System.out.println(f.floatOne);
		System.out.println(f.floatTwo);
	}

}
