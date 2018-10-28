package com.hw1.q15;

public class MyMathImplimented implements MyMathInterface {

	@Override
	public double addition(double x, double y) {
		return x+y;
	}

	@Override
	public double subtraction(double x, double y) {
		return x-y;
	}

	@Override
	public double multiplication(double x, double y) {
		return x*y;
	}

	@Override
	public double division(double x, double y) {
		return x/y;
	}

}
