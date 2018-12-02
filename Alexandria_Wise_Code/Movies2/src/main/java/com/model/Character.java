package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CHARACTER") //referencing the database and telling it the name of the table

public class Character {
	
		@Id
		@Column(name="CHAR_ID") //these identifiers tell hibernate that this will be a column with this name
		@GeneratedValue(strategy=GenerationType.AUTO) //auto-incrementor
		private int charId;
		
		@Column(name="NAME", unique=true, nullable=false)
		private String name;
		
		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Movie> movies;
		
		
		public Character() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Character(String name) {
			super();
			this.name = name;
		}
		
		public Character(String name, List<Movie> movies) {
			super();
			this.name = name;
			this.movies = movies;
		}

		public Character(int charId, String name, List<Movie> movies) {
			super();
			this.charId = charId;
			this.name = name;
			this.movies = movies;
			
		}

		public int getCharId() {
			return charId;
		}

		public void setCharId(int charId) {
			this.charId = charId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Movie> getMovies() {
			return movies;
		}

		public void setMovies(List<Movie> movies) {
			this.movies = movies;
		}

		@Override
		public String toString() {
			return "Character [charId=" + charId + ", name=" + name + ", movies=" + movies + "]\n";
		}

		
		
		
}
