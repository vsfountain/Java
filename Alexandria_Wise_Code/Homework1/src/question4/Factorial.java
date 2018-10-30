package question4;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		
		//scan in value for N
		System.out.println("Enter your desired factorial:");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int fact = 1; //declare a variable to hold values and initialize to one
		
		for(int i = N; i>0; i--) { //multiplies by N and each value below it in descending order
			fact *= i;
		}
		
		System.out.println(fact);
		
	}
}
