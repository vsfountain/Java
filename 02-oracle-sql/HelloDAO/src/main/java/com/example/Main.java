package com.example;

import java.util.List;

import com.example.model.Pokemon;
import com.example.service.PokeService;
import com.example.service.PokeServiceImpl;

public class Main {

	public static void main(String[] args) {

		PokeService pokeService = new PokeServiceImpl();
		
		List<Pokemon> pokes = pokeService.getAllPokemon();
		
		for(Pokemon p: pokes) {
			System.out.println(p);
		}
		System.out.println("done");
	}

}
