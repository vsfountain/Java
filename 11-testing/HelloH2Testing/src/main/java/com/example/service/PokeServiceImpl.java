package com.example.service;

import java.util.List;

import com.example.dao.PokeDao;
import com.example.dao.PokeDaoImpl;
import com.example.model.Pokemon;

public class PokeServiceImpl implements PokeService {

	private PokeDao poke= new PokeDaoImpl();
	
	@Override
	public List<Pokemon> getAllPokemon() {
		//put any other business logic here
		return poke.selectAllPokemon();
	}

	@Override
	public void h2Init() {
		poke.h2InitDao();
		
	}

	@Override
	public void h2Destroy() {
		poke.h2DestroyDao();
	}

	@Override
	public Pokemon getPokemon(String name) {
		return poke.selectPokemonByName(name);
	}

}
