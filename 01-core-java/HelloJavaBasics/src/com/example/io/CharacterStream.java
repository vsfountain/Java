package com.example.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {

	public static void main(String[] args) {

		String filename = "./charExample.txt";

		writeCharacterStream(filename);
		readCharacterStream(filename);
	}

	static void readCharacterStream(String filename) {

		try (FileReader reader = new FileReader(filename)) {
			int i;
			while ((i = reader.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}
	}

	static void writeCharacterStream(String filename) {

		try (FileWriter writer = new FileWriter(filename,true);) {

			for (int i = 65; i < 72; i++) {
				writer.write(i);
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}
	}

}