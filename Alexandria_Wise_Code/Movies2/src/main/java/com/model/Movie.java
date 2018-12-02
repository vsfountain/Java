package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE")

public class Movie {

	@Id
	@Column(name="MOVIE_ID") 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int movieId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="YEAR")
	private int	releaseYear;
	
	@Column(name="GENRE")
	private String genre;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="myDirector")
	private Director myDirector;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String title, int releaseYear, String genre, Director myDirector) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.myDirector = myDirector;
	}
	
	public Movie(String title, int releaseYear, String genre) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.genre = genre;
	}
	
	public Movie(int movieId, String title, int releaseYear, String genre, Director myDirector) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.myDirector = myDirector;
	}
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Director getMyDirector() {
		return myDirector;
	}

	public void setMyDirector(Director myDirector) {
		this.myDirector = myDirector;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", releaseYear=" + releaseYear + ", genre=" + genre
				+ ", myDirector=" + myDirector.getName() + "]";
	}
	
	
}
