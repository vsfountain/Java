package com.example.serialization;

import java.io.Serializable;

//an interface with nothing in it is called a marker interface
public class Person implements Serializable{
	
	
	private static final long serialVersionUID = 3716372720814391944L;
	private String name;
	private int age;
	private transient String ssn;
	
	public Person() {
	}

	public Person(String name, int age, String ssn) {
		super();
		this.name = name;
		this.age = age;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Mortal A Person [name=" + name + ", age=" + age + ", ssn=" + ssn + "]";
	}
}
