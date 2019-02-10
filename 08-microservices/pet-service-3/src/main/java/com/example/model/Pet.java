package com.example.model;

public class Pet {
	private String name;
	private String animal;
	
	public Pet() {
	}

	public Pet(String name, String animal) {
		super();
		this.name = name;
		this.animal = animal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", animal=" + animal + "]";
	}
	
}
