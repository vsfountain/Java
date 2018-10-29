package com.homework.question15;

public class FifteenMain {
	public static void main(String[] args) {
		FifteenFunctionality mathOperators = new FifteenFunctionality();
		int w = 2;
		int x = 3;
		int y = 7;
		int z = 11;
		double xx = 4;
		double xy = 2;
		double ww = 12;
		double zz = 4;
		System.out.println("Addition method called: adding integer values of: " + w + " and " + y +
				", answer is: " + mathOperators.addition(w,y));
		System.out.println("Addition method called: adding integer values of: " + x + " and " + z +
				", answer is: " + mathOperators.addition(x,z));
		System.out.println("Subtraction method called: subtracting integer values of: " + w + " and " + y +
				", answer is: " + mathOperators.subtraction(w,y));
		System.out.println("Subtraction method called: subtracting integer values of: " + x + " and " + z +
				", answer is: " + mathOperators.subtraction(x,z));
		System.out.println("Multiplication method called: multiplying integer values of: " + w + " and " + y +
				", answer is: " + mathOperators.multiplication(w,y));
		System.out.println("Multiplication method called: multiplying integer values of: " + x + " and " + z +
				", answer is: " + mathOperators.multiplication(x,z));
		System.out.println("Division method called: Dividing double values of: " + xx + " by " + xy +
				", answer is: " + mathOperators.division(xx,xy));
		System.out.println("Division method called: Dividing double values of: " + ww + " by " + zz +
				", answer is: " + mathOperators.division(ww,zz));
	}
}
