package com.notepadfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create a notepad file called Data.txt and enter the following:
*Mickey:Mouse:35:Arizona
*Hulk:Hogan:50:Virginia
*Roger:Rabbit:22:California
*Wonder:Woman:18:Montana
*Write a program that would read from the file and print it out to the screen in the
*following format:
*Name: Mickey Mouse
*Age: 35 years
*State: Arizona State
*
 * @author KristenKavanagh
 * @version 10/29/2018
 *
 */

public class notepadfile {
	
	public static void main(String[] args) {
		String filename = "./data.txt";
		//writeCharacterStream(filename);
		readCharacterStream(filename);
	}
	

	static void readCharacterStream(String filename){
		

		try(BufferedReader reader = new BufferedReader(new FileReader(filename));){
			
			String line = "";
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
		