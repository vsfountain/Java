package com.example.service;

import java.util.List;

import com.example.model.Pokemon;

public interface PokeService {

	public List<Pokemon> getAllPokemon();
	public Pokemon getPokemon(String name);
	
	//H2 DATABASE FUNCTIONALITY
	public void h2Init();
	public void h2Destroy();
}
