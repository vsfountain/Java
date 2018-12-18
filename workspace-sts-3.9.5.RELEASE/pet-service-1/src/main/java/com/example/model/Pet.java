package com.example.model;

public class Pet {
		private String name;
		private String animal;
	

	public Pet() {
	}


	/**
	 * @param name
	 * @param animal
	 */
	public Pet(String name, String animal) {
		super();
		this.name = name;
		this.animal = animal;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the animal
	 */
	public String getAnimal() {
		return animal;
	}


	/**
	 * @param animal the animal to set
	 */
	public void setAnimal(String animal) {
		this.animal = animal;
	}

}
