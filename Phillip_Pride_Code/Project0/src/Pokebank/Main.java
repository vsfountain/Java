package Pokebank;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String response;
		boolean done = false;
		System.out.println("Nurse Joy: Welcome to the Pok\u00E9mon Center. What would you like to during this visit? \n"
				+ "Make a new account (type new) or log in an existing account(type log)? (Type log out to leave)");
		
		response = input.next().toLowerCase();
		System.out.println(response);
		while(!done) {//currently an infinite loop
			System.out.println(6);
		}
	}

}
