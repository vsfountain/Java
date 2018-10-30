package com.commandline.string;

import java.util.Scanner;

/**
 * Write a program to display the number of characters for a string input. The string
* should be entered as a command line argument using (String [ ] args).
 * @author Kristen Kavanagh
 * @version 10/29/2018
 *
 */

public class Commandlinestring {

	public Commandlinestring() {
		}
		 public static void main(String[] args){
		        Scanner input = new Scanner(System.in);
		        System.out.println("Please enter a string");
		        String display = input.nextLine();
		        String word = "";
		        String total = "";

		       for (int i = 0; i < display.length(); i++) {
		            char thisChar = display.charAt(i);
		            if (thisChar >= 0 && thisChar <= 122) {
		                word += thisChar; 
		        }

		        System.out.println("Total amount of characters: " + display.length() + " - " + display);
		        System.out.println("Letters in this string is: " + word.length() + " - " + word);    
		    }
		
	}
}

