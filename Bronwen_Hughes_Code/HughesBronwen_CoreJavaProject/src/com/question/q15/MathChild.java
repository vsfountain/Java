package com.question.q15;

public class MathChild implements Math {
	
	@Override
	public double addition(double... varargs) {
		double ans = 0.0;
		for (double d : varargs) {
			ans += d;
		}
		return ans;
	}

	@Override
	public double subtraction(double num1, double num2) {
		double ans = num1 - num2;
		return ans;
	}

	@Override
	public double multiplication(double... varargs) {
		double ans = 1.0;
		for (double d : varargs) {
			ans *= d;
		}
		return ans;
	}

	@Override
	public double division(double num1, double num2) {
		if (num2 != 0) {
			double ans = 0.0;
			ans = num1 / num2;
			return ans;
		} else {
			System.out.println("Cannot divide by zero.");
			return 0;
		}
	}

}
