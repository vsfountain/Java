package com.javahomework.questions16;

public class ArgumentLengthCalculator {
	
	public static void main(String[] args) {
		// "my name is clement" is what i put in the run configuration for arguments
		// it does not count the space
		int length = 0;
		for(String s: args) {
			length = length + s.length();
		}
		
		System.out.println(length);
	}

}
