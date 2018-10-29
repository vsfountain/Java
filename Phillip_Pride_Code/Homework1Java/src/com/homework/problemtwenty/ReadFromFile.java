package com.homework.problemtwenty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

	public static void main(String[] args) {
		String filename = "C:\\Users\\wolfm\\my_git_repos\\1810-oct22-java\\Phillip_Pride_Code\\Homework1Java\\src\\com\\homework\\problemtwenty/Data.txt";
		readCharacterStream(filename);

	}

	static void readCharacterStream(String filename) {

		try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {

			String line = "";
			String[] info = new String[4];
			while ((line = reader.readLine()) != null) {
				info = line.split(":");
				for (int i = 0; i < info.length; i++) {
					switch (i) {
					case 0:
						System.out.println("Name: " + info[i] + " " + info[++i]);
						continue;
					case 2:
						System.out.println("Age: " + info[i] + " years");
						continue;
					case 3:
						System.out.println("State: " + info[i] + " State");

					}
					System.out.println();

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
