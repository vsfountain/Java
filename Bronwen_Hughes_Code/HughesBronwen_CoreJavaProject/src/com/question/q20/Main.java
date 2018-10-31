package com.question.q20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\spring-workspace\\HughesBronwen_CoreJavaProject\\src\\com\\question\\q20\\Data.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		String st;
		while((st = in.readLine()) != null) {
			//System.out.println(st);
			String[] temp = st.split(":");
			
			System.out.println("Name: " + temp[0] + " " + temp[1]);
			System.out.println("Age: " + temp[2] + " years");
			System.out.println("State: " + temp[3] + " State");
			System.out.println();
		}
	}
}
