package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Movie;
import com.util.HibernateUtil;

public class MovieDAO {
	
	public MovieDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(Movie myMovie) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(myMovie);
		tx.commit(); // DON'T FORGET TO COMMIT
		// ses.close();
	}

	public void update(Movie myMovie) {

		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.update(myMovie);
		tx.commit(); // DON'T FORGET TO COMMIT
		// ses.close();
	}

	public Movie selectById(int id) {

		Session ses = HibernateUtil.getSession();
		// no transaction because there is no change to the database

		Movie myMovie = ses.get(Movie.class, id); // specifically tells it what type of object

		// ses.close();
		return myMovie;
	}

	public List<Movie> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<Movie> movieList = ses.createQuery("from Movie", Movie.class).list();

		return movieList;
	}
}
