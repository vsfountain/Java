package com.example.q20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class q20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\Michael's Laptop\\Documents\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\HomeworkOne\\src\\com\\example\\q20\\Data.txt"); 
		  
		  BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
		  
		  
		  String st; 
			while ((st = br.readLine()) != null) {
			    String[] stt = st.split(":");
			    System.out.println("Name: " + stt[0] + " " + stt[1]);
			    System.out.println("Age: " + stt[2] + " years");
			    System.out.println("State: " + stt[3]);
				
				/*System.out.println(st);*/
			    
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		
		
	}
	
	
	

}
