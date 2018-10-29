package com.homework.question18;

public class Main {

		public static void main(String[] args) {
			String myString = "abcdefGhijklmnopqrstuvwxyz";
			ConcreateClass myConcreateClass = new ConcreateClass();
			boolean isThereUpper = myConcreateClass.anyUpperCase(myString);
			System.out.println("Was there an uppercase in the string?: " + isThereUpper);
			String allCapString = myConcreateClass.lowerCaseToUpper(myString);
			System.out.println("New string with all capitals: " + allCapString);
			int stringConverted = myConcreateClass.convertString(myString);
			System.out.println("String converted to int: " + stringConverted);
		}
}
