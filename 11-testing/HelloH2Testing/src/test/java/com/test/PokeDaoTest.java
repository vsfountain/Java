package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.dao.PokeDao;
import com.example.dao.PokeDaoImpl;
import com.example.model.Pokemon;

/*
 * There are comments mentioning H2 throughout this example. But specifically I want you all to
 * 	look at the dependencies inside pom.xml, the URL used to connect to your h2 database,
 * 	the syntax used to create a table, and the path where the database files are stored
 * 	(given in the url needed to connect to the database)
 */

public class PokeDaoTest {

	private static PokeDao pokeDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Using H2 database, instead of your actual live environment data, allows you heavily modify
		//	the database to extensively test your DAO functionality without threat of destroying
		//	your live environment.
		pokeDao = new PokeDaoImpl("jdbc:h2:./Starmie/is/thebest/pokemon/testData", "sa", "sa");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		pokeDao.h2InitDao();
	}

	@After
	public void tearDown() throws Exception {
		pokeDao.h2DestroyDao();
	}

	@Test
	public void selectByNametest() {
		//once you've set up your h2 database for testing you can just test your actual crud method
		//	functionality, just on a different database.
		
		Pokemon poke = pokeDao.selectPokemonByName("squirtle");
		
		assertEquals("squirtle", poke.getPokemon_name());
		assertEquals("water", poke.getPokemon_type());
		assertEquals(7, poke.getPokemon_id());
	}

}
