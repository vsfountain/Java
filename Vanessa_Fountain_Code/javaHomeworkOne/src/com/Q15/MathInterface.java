package com.Q15;
/*Write a program that defines an interface having the following methods:
 *  addition, subtraction, multiplication, and division.  
 *  Create a class that implements this interface and provides appropriate functionality 
 *  to carry out the required operations. 
 *  Hard code two operands in a test class having a main method that calls the implementing class
 */
public interface MathInterface {
	
	Object addition(Integer x, Integer y );
	Object subraction(Integer x, Integer y);
	Object muliplication(Integer x, Integer y);
	Object division(double x, double y);
}
