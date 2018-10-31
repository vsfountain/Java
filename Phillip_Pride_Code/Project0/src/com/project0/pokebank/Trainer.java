package com.project0.pokebank;

import java.io.Serializable;
import java.util.*;

public class Trainer  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usrname;
	private String password;
	private ArrayList<Account> accounts;
	boolean hasOpenBox;
	protected String application;
	int boxNum = 0;

	public Trainer(String usrname, String password) {
		this.usrname = usrname.toLowerCase();
		this.password = password;
		accounts = new ArrayList<>();
		hasOpenBox = false;
		application = "no";
	}

	String getUsername() {
		return usrname;
	}

	String getPassword() {
		return password;
	}
	Account getBox(String name){
		for(int i = 0; i<accounts.size();i++) {
			if(accounts.get(i).getAccountName().equals(name)) {
				return accounts.get(i);
			}
		}
		return null;
		
	}

	void applyForBox() {
		application = "yes";
		createBox();
		
	}

	void withdraw(Account aName, String poke) {
		if (hasOpenBox) {
			if (accounts.contains(aName)) {
				aName.removePokemon(poke);
			} else {
				System.out.println("Oh dear! That Pok\u00E9mon does not seem to be stored in your PC Box! "
						+ "Did you mean to pick up a different Pok\u00E9mon?");
			}
		} else {
			System.out.println(
					"I'm sorry, you don't seem to have an open box. Please apply for one");

		}

	}

	void deposit(Account aName, String poke) {
		if (hasOpenBox) {
			if (accounts.contains(aName)) {
				aName.addPokemon(poke);

			}
			else {
				System.out.println("I'm sorry, you don't seem to have an open box. Please apply for one");
			}
		}

	}

	void transfer(String poke, Account current, Account move) {
		if (hasOpenBox) {
			if (accounts.contains(current)) {
				if (accounts.contains(move)) {
					current.removePokemon(poke);
					move.addPokemon(poke);
				} else {
					System.out.println("You do not have an account named " + move.getAccountName());
				}

			} else {
				System.out.println("You do not have an account named " + current.getAccountName());
			}
		}
	}
	private void createBox() {
		accounts.add(new Account("Box"+ ++boxNum));
	}

	@Override
	public String toString() {
		return "\nTrainer [username = " + usrname +  ", password = " + password + " accounts: " + accounts + " has applied for a new box: " + application +"]";
	}
}
