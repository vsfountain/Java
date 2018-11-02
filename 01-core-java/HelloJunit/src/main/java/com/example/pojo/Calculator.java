package com.example.pojo;

public class Calculator {
	public int add(int x, int y) {
		return x+y;
	}
	
	public int substract(int x, int y) {
		return x-y;
	}
	
	public int multiply(int x, int y) {
		/*if(x==0 && y==0)
			return 15;*/
		return x*y;
	}
	
	public int divide(int x, int y) {
		return x/y;
	}
	
	public void xyzMethd() {
		throw new IllegalArgumentException();
	}
	
	public void timeMethod() {
		while(true) {
			
		}
	}
}
