package com.Q15;
import com.Q15.MathI;
// * Hard code two operands in a test class having a main method that calls the implementing class.
public class Test {
	static int x = 5;
	static int y =4;
	
	public static void main(String[] args) {
		MathI math = new MathI();
		
		System.out.println(math.addition(x,y));
		System.out.println(math.division(x,y));
		System.out.println(math.muliplication(x,y));
		System.out.println(math.subraction(x,y));
	}

}
