package com.corejava.question3;

public class reverseString {
	
	public reverseString() 
	{	}
	//Reverse Logic
	public String reverse(String myString) {
		// remove repetitiveness of str.length() by assigning it to variable l
		//System.out.println("The initial String is: " +myString);
		int l = myString.length();
		
		//i is set to the last element in the string 
		for(int i= (l-1);i>=0 ; i--) {
			myString +=  myString.charAt(i);
		}
			//divide the returned string by two to remove the initial string
		 return myString.substring(myString.length()/2);
		 
	}
}
