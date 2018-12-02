package com.main;

import java.util.ArrayList;
import java.util.List;

import com.dao.CharacterDAO;
import com.dao.DirectorDAO;
import com.dao.MovieDAO;
import com.model.Character;
import com.model.Director;
import com.model.Movie;
import com.util.HibernateUtil;

public class Main {
	public static final CharacterDAO cdao = new CharacterDAO();
	public static final MovieDAO mdao = new MovieDAO();
	public static final DirectorDAO ddao = new DirectorDAO();
	
	public static void main(String[] args) {
		HibernateUtil.getSession();
		
		CharacterDAO cdao = new CharacterDAO();
		MovieDAO mdao = new MovieDAO();
		DirectorDAO ddao = new DirectorDAO();
		
		insertInitialValues();
		
		System.out.println("Our Characters:");
		System.out.println(cdao.selectAll());
		
		System.out.println("Our Movies:");
		System.out.println(mdao.selectAll());
		
		System.out.println("Our Directors:");
		System.out.println(ddao.selectAll());
		
		HibernateUtil.closeSession();

	}
	
	public static void insertInitialValues() {
		
		Character char1 = new Character("Mickey Mouse");
		Character char2 = new Character("Donald");
		Character char3 = new Character("Goofy");
		Character char4 = new Character("Pluto");
		
		cdao.insert(char1);
		cdao.insert(char2);
		cdao.insert(char3);
		cdao.insert(char4);
		

		Movie mov1 = new Movie("Avengers", 2018, "Action");
		Movie mov2 = new Movie("Zootopia", 2016, "Mystery/Crime");
		Movie mov3 = new Movie("La La Land", 2016, "Drama/Romance");
		Movie mov4 = new Movie("The Dark Night", 2008, "Drama/Thriller");
		
		Director dir1 = new Director("Anthony Russo", 48, "M");
		Director dir2 = new Director("Byron Howard", 48, "M");
		Director dir3 = new Director("Damien Chazelle", 33, "M");
		Director dir4 = new Director("Christopher Nolan", 48, "M");
		
		mov1.setMyDirector(dir1);
		mov2.setMyDirector(dir2);
		mov3.setMyDirector(dir3);
		mov4.setMyDirector(dir4);
		
		List<Movie> movies1 = new ArrayList<Movie>();
		List<Movie> movies2 = new ArrayList<Movie>();
		List<Movie> movies3 = new ArrayList<Movie>();
		List<Movie> movies4 = new ArrayList<Movie>();
		
		movies1.add(mov1);
		movies2.add(mov2);
		movies3.add(mov3);
		movies4.add(mov4);
		
		dir1.setMyMovies(movies1);
		dir2.setMyMovies(movies2);
		dir3.setMyMovies(movies3);
		dir4.setMyMovies(movies4);
		
		
		mdao.insert(mov1);
		mdao.insert(mov2);
		mdao.insert(mov3);
		mdao.insert(mov4);
		
		ddao.insert(dir1);
		ddao.insert(dir2);
		ddao.insert(dir3);
		ddao.insert(dir4);
		
		
		
	}
}
