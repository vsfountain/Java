package question17;

import java.util.Scanner;

public class InterestCalculator {
	public static void main(String[] args) {
		System.out.println("Enter your principal:");
		Scanner sc = new Scanner(System.in);
		float p = sc.nextFloat();
		
		System.out.println("Enter your rate:");
		Scanner sc1 = new Scanner(System.in);
		float r = sc1.nextFloat();
		
		System.out.println("Enter your time:");
		Scanner sc3 = new Scanner(System.in);
		float t = sc3.nextFloat();
		
		float interest = (float)p*r*t;
		System.out.println(interest);
		
	}

}
