package com.Q20;

import com.Q20.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 	Name: Mickey Mouse
	Age: 35 years
	State: Arizona State
	
	Mickey:Mouse:35:Arizona
	Hulk:Hogan:50:Virginia
	Roger:Rabbit:22:California
	Wonder:Woman:18:Montana


 */
public class ReadFileIn{
//Made two ArrayList object data structures
	static ArrayList<String> data = new ArrayList<String>();
	static ArrayList<String> format = new ArrayList<String>();
	
	public static void main(String[] args) throws FileNotFoundException {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(new File ("./Data"));
		//scanning the data file in
		while (scan.hasNext()) {
			String name = scan.next();
			data.add(name);
		}
		dataContainer(data);
}
//Reading in from an arrayList
	//formatting: replacing all of the "_" with ":" 
	//printing out the line that contains what we are looking for
	public static void formatData(ArrayList<String> format) {
		String line;
		for(int i = 0; i< format.size();i++) {
			line = format.get(i);
			line = line.replaceAll("_", ": ");
			if (line.contains("Mickey Mouse")==true ) {
				System.out.println(line);
			}
		}
		
	}

//Reading in from an array
	//pre processing by tagging and separating each ":" 
	//storing into an array
	public static void dataContainer(ArrayList<String> data) {
		String name ;
		String age;
		String state;

		for(int i=0;i<data.size();i++) {
			name = data.get(i);
			name = ("Name_" + name);
			name = name.replaceFirst(":", " ");
			age = name.replaceFirst(":", "\n" + "Age_");
			state = age.replaceFirst(":", "\n" + "State_");
			
			format.add(state); 

		}
		formatData(format);
	}
}
