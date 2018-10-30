package com.concrete.subclass;

import java.util.Scanner;

/**
 * 2. Convert all of the lower case characters to uppercase in the input string,
 * and return the result.
 * 
 * @author Kristen Kavanagh
 *
 */

class Subclass implements main {

	
	public void loginAccount() {
		System.out.println("Enter your login information");
		
	}
	public static void main( String []args) {
		
			String password;
	char ch;
	Scanner stdIn = new Scanner(System.in);
	// System.out.print("Enter password: ");
	password=stdIn.next();
	ch=password.charAt(0);
	if((Character.isLowerCase(ch)))// check for Lowercase
	{
		System.out.println(password.toUpperCase());
	}else
	{
		System.out.println("false");
	}
	}
	@Override
	public void upperLowcase() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void upperTrue() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addToResult() {
		// TODO Auto-generated method stub
		
	}}
	