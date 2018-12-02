package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DIRECTOR")

public class Director {
	
	@Id
	@Column(name="DIRECTOR_ID") 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int directorId;
	
	@Column(name="NAME", unique=true)
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="GENDER")
	private String gender;
	
	@OneToMany(mappedBy="myDirector",fetch = FetchType.LAZY)
	private List<Movie> myMovies;

	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Director(String name, int age, String gender, List<Movie> myMovies) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.myMovies = myMovies;
	}
	
	public Director(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Director(int directorId, String name, int age, String gender, List<Movie> myMovies) {
		super();
		this.directorId = directorId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.myMovies = myMovies;
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Movie> getMyMovies() {
		return myMovies;
	}

	public void setMyMovies(List<Movie> myMovies) {
		this.myMovies = myMovies;
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", myMovies=" + myMovies + "]\n";
	}

	
}
