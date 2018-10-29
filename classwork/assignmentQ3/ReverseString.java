package com.assignmentQ3;

public class ReverseString {

		public static void main(String[] args) {			
			reverser();
		}
		
		public static void reverser() {			
			String s = "TestString";			
			for (int i = s.length() - 1; i>= 0;i--) {
				s += s.charAt(i);
			}
			System.out.println(s.substring((s.length()/2)));			
		}
}
