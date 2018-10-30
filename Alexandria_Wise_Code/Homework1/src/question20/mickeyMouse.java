package question20;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mickeyMouse {
	
	public static void main(String[] args) {
		String filename = "./Data.txt";
		
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
}

