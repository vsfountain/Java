package com.homework.question20;

import java.io.*;
import java.util.*;
public class DataFile {
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\micha\\Documents\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\Revature\\src\\com\\homework\\question20\\Data.txt");
			Scanner readFile = new Scanner(file);
			while(readFile.hasNext()) {
				String currString = readFile.next();
				String[] currLine = currString.split(":");
				System.out.println("Name:" + currLine[0] + " " + currLine[1] + "\nAge:" + currLine[2] + " years\nState:" + currLine[3] + " State\n");
			}
		}catch(Exception e){
			System.out.println("File not found.");
		}
	}
}
