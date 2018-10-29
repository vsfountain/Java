package com.homework.question15;

public class FifteenFunctionality implements FifteenInterface{

	@Override
	public int addition(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}

	@Override
	public int subtraction(int firstNum, int secondNum) {
		return firstNum-secondNum;
	}
	
	@Override
	public int multiplication(int firstNum, int secondNum) {
		return firstNum*secondNum;
	}
	
	@Override
	public double division(double firstNum, double secondNum) {
		if(secondNum==0) {
			return 0;
		}
		return firstNum/secondNum;
	}
}
