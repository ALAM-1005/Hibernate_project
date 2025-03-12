package com.jsp.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {

		Movie movie = new Movie();
		movie.setMovieId(101);
		movie.setMovieTitle("Ham Sath Sath Hai");
		movie.setMovieGenre("Action");
		movie.setMovieDirector("RajKumarHirani");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		// em.persist(movie);
		
		Movie movie1 = em.find(Movie.class, 101);
		et.commit();
		em.close();
		emf.close();

	}
}
