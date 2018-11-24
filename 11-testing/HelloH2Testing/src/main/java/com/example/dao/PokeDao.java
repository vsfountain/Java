package com.example.dao;

import java.util.List;

import com.example.model.Pokemon;

public interface PokeDao {
	/*
	 * CRUD METHODS ONLY
	 */
	
	//CREATE
	public int insertPokemon(Pokemon p);
	//READ
	public List<Pokemon> selectAllPokemon();
	public Pokemon selectPokemonById(int id);
	public Pokemon selectPokemonByName(String name);
	public List<Pokemon> selectByType(String type);
	//UPDATE
	public int updatePokemon(Pokemon p);
	//DELETE
	public int deletePokemon(Pokemon p);
	
	//H2 DATABASE FUNCTIONALITY
	public void h2InitDao();
	public void h2DestroyDao();
}
