package com.project0.pokebank;

import java.io.Serializable;
import java.util.*;

public class Account implements Serializable{
	private String acctName;
	private List<String> pokes;

	public Account(String name) {
		acctName = name;
		pokes = new ArrayList<>();

	}
	
	public String getAccountName() {
		return acctName;
	}
	
	public void getPokemonList() {
		for(String i: pokes) {
			System.out.println(i);
		}
		
	}

	public void addPokemon(String poke) {
		pokes.add(poke);
	}

	public void removePokemon(String poke) {
		pokes.remove(poke);
	}

	/*@Override
	public String toString() {
		return "Account [acctName= " + acctName + ", pokes= " + pokes + "]\n";
	}*/
	

}
