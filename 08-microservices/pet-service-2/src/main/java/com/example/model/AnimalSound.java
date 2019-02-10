package com.example.model;

public class AnimalSound {
	private String sound;
	private double decibel;
	
	public AnimalSound() {
	}

	public AnimalSound(String sound, double decibel) {
		super();
		this.sound = sound;
		this.decibel = decibel;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public double getDecibel() {
		return decibel;
	}

	public void setDecibel(double decibel) {
		this.decibel = decibel;
	}

	@Override
	public String toString() {
		return "AnimalSound [sound=" + sound + ", decibel=" + decibel + "]";
	}
	
}
