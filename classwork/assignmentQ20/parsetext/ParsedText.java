package com.assignmentQ20.parsetext;

import java.io.*;
import java.util.*;
public class ParsedText {
	
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\Bleedscode\\Documents\\springWorkspace\\Homework1\\src\\com\\assignmentQ20\\parsetext\\Data.txt");
			Scanner sc = new Scanner(file);
			String scanParse;
			while(sc.hasNext()) {
				scanParse = sc.next();
				String[] parsedArr = scanParse.split(":");
				System.out.println("Name: " + " " + parsedArr[0] + " " + parsedArr[1]);
				System.out.println("Age: " + parsedArr[2] + " " + "years");
				System.out.println("State: " + parsedArr[3] + " " + "state\n");						
			}
		}
		catch(Exception b) {
			System.out.println("File not found.");
		}
	}	
}
