package Pokebank;

import java.util.*;

public class Trainer {
	private String usrname;
	private String password;
	private ArrayList<String> pcBox;
	private boolean hasOpenAccount;

	public Trainer(String usrname, String password) {
		this.usrname = usrname;
		this.password = password;
		pcBox = new ArrayList<String>();
		hasOpenAccount = true;
	}
	
	String getUsername() {
		return usrname;
	}
	String getPassword() {
		return password;
	}

	void withdraw(String poke) {
		if (hasOpenAccount) {
			if (pcBox.contains(poke)) {
				pcBox.remove(poke);
			}
			else {
				System.out.println("Nurse Joy: Oh dear! That Pok\u00E9mon does not seem to be stored in your PC Box! "
						+ "Did you mean to pick up a different Pok\u00E9mon?");
			}
		} else {
			System.out.println("Nurse Joy: I'm sorry, you don't seem to have an account with us. Please create one before continuing");

		}

	}

	void deposit(String poke) {
		if (hasOpenAccount) {
			pcBox.add(poke);
		}

	}

	void transfer(int funds, ArrayList<String> move) {

	}

}
