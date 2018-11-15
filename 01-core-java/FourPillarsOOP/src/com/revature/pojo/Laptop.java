package com.revature.pojo;

//another pojo
public class Laptop extends Computer{

	
	//state
	private int batteryLife;
	private double weight;
	
	//no-args
	public Laptop(){
		super(); //implicit
		System.out.println("Building a Laptop");
	}

	//behaviors
	
	//getters and setters (acessors and mutators)
	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//overriden toString
	@Override
	public String toString() {
		return "Laptop [batteryLife=" + batteryLife + ", weight=" + weight + "]";
	}
	
	
	
	
}
