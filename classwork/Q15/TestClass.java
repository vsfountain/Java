package com.assignment.Q15;

public class TestClass implements Problem15 {
	
	public static void main(String[] args) {
		TestClass tc = new TestClass();
		tc.adder(3,4);
		tc.subtracter(2, 4);
		tc.multiplier(3, 5);
		tc.divider(2, 4);
	}
	@Override
	public  int adder(int num1, int num2) {
		int total = num1 + num2;
		return total;
	}
	@Override
	public int subtracter(int num1, int num2) {
		int total = num2 - num1;
		return total;
	}
	@Override
	public int multiplier(int num1, int num2) {
		int total = num1 * num2;
		return total;
	}
	@Override
	public int divider(int num1, int num2) {
		int total = num2/num1;
		return total;
	}
}
