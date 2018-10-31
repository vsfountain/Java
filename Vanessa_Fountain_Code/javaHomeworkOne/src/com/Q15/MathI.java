package com.Q15;
/*
 * Create a class that implements this interface and provides appropriate functionality 
 *  to carry out the required operations. 
 *  Hard code two operands in a test class having a main method that calls the implementing class
 */

public class MathI implements MathInterface{
	
	@Override
	public Object addition(Integer x, Integer y ) {
		return x +=y;
	}

	@Override
	public Object subraction(Integer x, Integer y) {
		return x-=y;
	}

	@Override
	public Object muliplication(Integer x, Integer y) {
		return x*=y;
	}

	@Override
	public Object division(double x, double y) {
		
		return x/=y;
	}


}
