package com.example.flowcontrol;

public class IfExample {

	public static void main(String[] args) {

		// what is an if statements?
		/*int j= 2;
		int i = j>3 ? 7500:1000; //ternary statement
		
		if (i < 7000) {	//if statement
			System.out.println("first if statement hit!");
			System.out.println("I like buttered toast");
		} else if (i < 8000) {
			System.out.println("second if");
		} else {
			System.out.println("other stuff");
		}*/

		String k= "false";
		//switch statement
		//int, short, byte,char, (and all of their wrappers),
//		//   String, and enum
		switch(k) {
		case "true":
			System.out.println("first case");
			break;
		case "false":
			System.out.println("second case");
			break;
			default:
				//stuff
		}

		System.out.println("done");
	}

}
