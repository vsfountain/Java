package com.hw1.q_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

//Q3. Reverse a string without using a temporary variable.  
//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Reverse my string"; 
		  
        // convert String to character array 
        // by using toCharArray 
        char[] stringToChar = input.toCharArray(); 
  
        for (int i = stringToChar.length-1; i>=0; i--) 
            System.out.print(stringToChar[i]); 
	}

}
