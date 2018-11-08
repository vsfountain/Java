package q14;

import java.util.Date;

public class SwitchStatement {
public static void main(String[] args) {
	mySwitch(1);
	mySwitch(2);
	mySwitch(3);
	mySwitch(11);
}
public static void mySwitch(int k) {
	switch(k) {
		case 1:
			//just use the math square root method
			double num = 25.25;
			System.out.println(Math.sqrt(num));
			break;
		case 2:
			//just print out the current date and time stamp
			System.out.println(new Date());
			break;
		case 3:
			/*
			 * just use the provided string and use the split by delimiter where the delimeter is " " 
			 * and show the individual pieces
			 */
			String temp = "I am learning Core Java";
			String[] strArry = temp.split(" ");
			for (String i:strArry) {
				System.out.print(i + "\t");
			}
			System.out.print("\n");
			break;
			default:
				System.out.println("We have hit the default case here.");
	}
}
}
