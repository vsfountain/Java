package question5;

import java.util.Scanner;

public class Substring {

	public static String getSubstring(String str, int idx) {

		//convert the string into a character array
		char[] strArray = str.toCharArray();
		
		//create empty char array to hold reverse
		char[] SubstringArray = new char[str.length()];
		
		//fill substring array with characters
		for (int i=0;i<idx;i++) {
			SubstringArray[i] = strArray[i];
		}
		
		//convert SubstringArray into string
		String Substring = new String(SubstringArray);
		return Substring;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter a string: ");
		Scanner scanner = new Scanner(System.in);
		String userString = scanner.nextLine();
		
		System.out.println("Enter your desired substring length:");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		String mySubstring = getSubstring(userString, i);
		System.out.println(mySubstring);
	}
}
