package com.javahomework.questions15;

public class CalculatorImplementation implements Calculator{

	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return Math.addExact(x, y);
	}

	@Override
	public int subtract(int x, int y) {
		// TODO Auto-generated method stub
		return Math.subtractExact(x, y);
	}

	@Override
	public int divide(int x, int y) {
		// TODO Auto-generated method stub
		return Math.floorDiv(x, y);
	}

	@Override
	public int multiply(int x, int y) {
		// TODO Auto-generated method stub
		return Math.multiplyExact(x, y);
	}
}
