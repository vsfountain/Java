package com.example.junit;

public class Calculator {

	public int add(int x, int y) {
		return x+y;
	}
	
	public int subtract(int x, int y) {
		return x-y;
	}
	
	public int multiply(int x, int y) {
		return x*y;
	}
	
	public int divide(int x, int y) {
		return x/y;
	}
	
	public void xyzMethod() throws IllegalArgumentException
	{
		throw new IllegalArgumentException();
	}
	
	public void timeMethod() {
		while(true) {
			//thats it
		}
	}
}
