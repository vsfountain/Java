package com.example.model;

public class Pokemon {

	private int pokemon_id;
	private String pokemon_name;
	private String pokemon_type;
	
	public Pokemon() {
	}

	public Pokemon(int pokemon_id, String pokemon_name, String pokemon_type) {
		super();
		this.pokemon_id = pokemon_id;
		this.pokemon_name = pokemon_name;
		this.pokemon_type = pokemon_type;
	}

	public int getPokemon_id() {
		return pokemon_id;
	}

	public void setPokemon_id(int pokemon_id) {
		this.pokemon_id = pokemon_id;
	}

	public String getPokemon_name() {
		return pokemon_name;
	}

	public void setPokemon_name(String pokemon_name) {
		this.pokemon_name = pokemon_name;
	}

	public String getPokemon_type() {
		return pokemon_type;
	}

	public void setPokemon_type(String pokemon_type) {
		this.pokemon_type = pokemon_type;
	}

	@Override
	public String toString() {
		return "Pokemon [pokemon_id=" + pokemon_id + ", pokemon_name=" + pokemon_name + ", pokemon_type=" + pokemon_type
				+ "]";
	}
}
