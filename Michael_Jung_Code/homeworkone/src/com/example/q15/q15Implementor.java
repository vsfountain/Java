package com.example.q15;

public class q15Implementor implements q15Interface{

	@Override
	public int addition(int a, int b) {
		// TODO Auto-generated method stub
		
		int aa = a + b;
		return aa;
	}

	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		int aa = a - b;
		return aa;
	}

	@Override
	public int division(int a, int b) {
		// TODO Auto-generated method stub
		int aa = a/b;
		return aa;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		int aa = a * b;
		return aa;
	}

}
