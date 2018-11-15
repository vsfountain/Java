package q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SwitchStatement {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a number for: \n"
				+ "1: square root of num\n2: todays date\n3: split string");
		int i = scan.nextInt();
		//System.out.println(i);
		
		switch(i) {
			case (1):
				System.out.println("enter a number");
				scan.nextFloat();
				System.out.println("Square root of " + i + " is " + Math.sqrt(i));
				break;
			case (2):
				Date x = new Date();
				DateFormat format = new SimpleDateFormat("MM/dd/YYYY");
				System.out.println(format.format(x));
				break;
			case (3):
				String toBreak = "I am learning core java";
				String[] brokenArray = toBreak.split(" ");
				for (String theString : brokenArray) {
					System.out.println(theString);
				}
				break;
		}
	}

}
