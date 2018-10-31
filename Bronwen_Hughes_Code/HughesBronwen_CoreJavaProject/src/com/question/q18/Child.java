package com.question.q18;

public class Child implements Parent {

	public Child(String s) {
		uppercaseCheck(s);
		forceUppercase(s);
		convertStringAddTen(s);
	}

	@Override
	public boolean uppercaseCheck(String s) {
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			if (Character.isUpperCase(c)) {
				System.out.println("There is at least one uppercase in this string.");
				return true;
			}
		}
		System.out.println("There are no uppercases in this string.");
		return false;
	}

	@Override
	public String forceUppercase(String s) {
		s = s.toUpperCase();
		System.out.println("After forcing uppercase, the string is now: " + s);
		return s;
	}

	@Override
	public int convertStringAddTen(String s) {
		char[] temp = s.toCharArray();
		int x = 0;
		for (char c : temp) {
			x += c;
		}
		x += 10;
		System.out.println("After converting to integer and adding 10, the int is: " + x);
		return x;
	}

}
