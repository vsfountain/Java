package com.hw1.q20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question Text
		 * 
		 * Q20. Write a program that would read from the file 
		 * and print it out to the screen in the following format:
		 * 
		 * 		Name: Mickey Mouse
		 * 		Age: 35 years
		 * 		State: Arizona State
		 * 
		 */
		
		//String fileName = "C:/Users/ldpip/my_git_repos/1810-oct22-java/Louis_Pipkin_Code/CoreJavaHWOne/src/com/hw1/q20/dataIn.txt";
		//String fileName = "/CoreJavaHWOne/src/com/hw1/q20/dataIn.txt";
		String fileName = "src\\com\\hw1\\q20\\Data.txt";
		List<String> lines = new ArrayList<>();
		Person p;
		String[] sec;
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			//read all lines of file in ArrayList of strings
			lines = stream.collect(Collectors.toList());
		}catch (IOException e) {
			e.printStackTrace();
		}
	
		for (String l: lines) {
			sec = l.split(":");
			//sec[0] = fName, sec[0] = lName, sec[0] = age, sec[0] = state
			p = new Person(sec[0], sec[1], Integer.parseInt(sec[2]), sec[3]);
			p.printPerson();
		}
	}

}
