package q20;

import java.util.Scanner;
import java.io.File;

public class ReadTxtFile {

	public static void main(String[] args) {
		//String myStr = "C:\\Users\\Sean\\Desktop\\workspace-spring-tool-suite-4-4.0.0.RELEASE\\Home_Work_0_Part_1\\src\\q20\\Data.txt";
		String myStr = "src\\q20\\Data.txt";
		System.out.println("File read successful?: " + showTxt(myStr));
	}
	
	/*
	 * opens the file and reads in the information line by line
	 */
	public static boolean showTxt(String fileIn) {
		try{
			Scanner s = new Scanner(new File(fileIn));		
			while (s.hasNext()) {
				decouple(s.next());
			}
			s.close();
			return true;
		} catch (Exception e){
			System.out.println("Could not find file.");
			return false;
		}
	}
	
	/*
	 * split the imported string based on the ":" delimeter and show its parts grouped properly
	 */
	public static void decouple(String holder) {
		String[] toPrint = holder.split(":");
		System.out.println("Name: "+ toPrint[0] + " "+ toPrint[1]+"\nAge: "+toPrint[2] +" years\nState: "+toPrint[3]+"\n");

	}
}
