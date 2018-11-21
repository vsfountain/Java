package com.example;

import java.util.List;

import com.example.dao.PokeDaoImpl;
import com.example.model.Pokemon;
import com.example.service.PokeService;
import com.example.service.PokeServiceImpl;
/*
 * There are comments mentioning H2 throughout this example. But specifically I want you all to
 * 	look at the dependencies inside pom.xml, the URL used to connect to your h2 database,
 * 	the syntax used to create a table, and the path where the database files are stored
 * 	(given in the url needed to connect to the database)
 */
public class Main {

	public static void main(String[] args) {

		PokeService pokeService = new PokeServiceImpl();
		//CREATING H2 DATABASE TABLE W/ DUMMY DATA
		pokeService.h2Init();
		
		//checking select by name method in the Dao
		System.out.println("Checking selectbyname method:\n\t"+pokeService.getPokemon("squirtle"));
		
		//checking select all method in the Dao
		List<Pokemon> pokes = pokeService.getAllPokemon();
		System.out.println("Checking select all method:");
		for(Pokemon p: pokes) {
			System.out.println("\t\t"+p);
		}
		
		//DROPPING H2 DATABASE TABLE
		pokeService.h2Destroy();
		
		System.out.println("done");
	}

}
