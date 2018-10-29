package q20;

import java.io.BufferedReader;
import java.io.FileReader;


public class PeoplePrinter {

	public static void main(String[] args) {
		
		try {
			FileReader file = new FileReader("src\\Q20\\Data.txt");
			BufferedReader reader = new BufferedReader(file);
			String process =  reader.readLine();
			while (process != null) {
				//System.out.println(process);
				String[] info = process.split(":");
				System.out.println("Name: " + info[0] + " " +info[1] +
						"\nAge: " + info[2] + " years"+
						"\nState: " + info[3] + "\n");
				process = reader.readLine();
			}

			reader.close();
			file.close();
			
			
		} catch (Exception e){
			e.printStackTrace();
			
		} 

	}

}
