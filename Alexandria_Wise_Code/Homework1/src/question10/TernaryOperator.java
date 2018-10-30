package question10;

import java.util.Scanner;

public class TernaryOperator {
	public static void main(String[] args) {
		System.out.println("Enter two integers separated by a space:");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		boolean xmin;
		
		xmin = x<y ? true:false;
		
		if(xmin==true) {
			System.out.println(x+ " is the minimum of the two values");
		}
		else {
			System.out.println(y+ " is the minimum of the two values");
		}
	}
}
