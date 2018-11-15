package com.revature;

import com.revature.exception.BananaAgeAmountToBigException;
import com.revature.exception.InvalidBananaColorException;


//POJO - Plain Old Java Object
public class Banana {
	
	//state
	boolean isPeeled;
	String color;
	double weight;
	
	//NO-ARGS Constructor
	public Banana(){}
	
	//behavior
	public void age(){
		System.out.println("banana ages");
		this.weight = this.weight * 0.5;
	}
	
	public void age(int ageAmount) throws com.revature.exception.BananaAgeAmountToBigException{
		if(ageAmount > this.weight){
			throw new BananaAgeAmountToBigException();
		}
		System.out.println("banana ages");
		this.weight = this.weight - ageAmount;
	}
	
	
	
	public String getColor() throws IllegalArgumentException {
		return color;
	}

	/**
	 * 
	 * @param color
	 * @throws InvalidBananaColorException	- blue is not allowed
	 */
	public void setColor(String color) throws InvalidBananaColorException {
		if(color.equals("blue")){
			throw new InvalidBananaColorException();
		}
		this.color = color;
	}

	//Overriden toString() @-annotation
	@Override
	public String toString() {
		return "Banana [isPeeled=" + isPeeled + ", color=" + color + ", weight=" + weight + "]";
	}
	
	/**
	 * 
	 * @param a
	 * @throws IllegalArgumentException when 0 
	 */
	public void dontGiveMeAZero(int a) throws Exception{
		if(a == 0){
			throw new Exception();
		}
		System.out.println("not 0");
		
	}
	
}
