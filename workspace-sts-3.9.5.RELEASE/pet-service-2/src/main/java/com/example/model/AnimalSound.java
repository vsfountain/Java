package com.example.model;

public class AnimalSound {
	private String sound;
	private double decibel;

	public AnimalSound() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sound
	 * @param decibel
	 */
	public AnimalSound(String sound, double decibel) {
		super();
		this.sound = sound;
		this.decibel = decibel;
	}

	/**
	 * @return the sound
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * @param sound the sound to set
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}

	/**
	 * @return the decibel
	 */
	public double getDecibel() {
		return decibel;
	}

	/**
	 * @param decibel the decibel to set
	 */
	public void setDecibel(double decibel) {
		this.decibel = decibel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnimalSound [sound=" + sound + ", decibel=" + decibel + "]";
	}
	

}
