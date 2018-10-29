package q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("data.txt");
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				String person = input.nextLine();
				String[] data = person.split(":");
				System.out.println("Name: " + data[0] + " " + data[1]);
				System.out.println("Age: " + data[2] + " years");
				System.out.println("State: " + data[3] + " State\n");
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
