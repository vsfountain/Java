package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.model.CartoonCharacter;

@Controller
public class CartoonDaoImpl implements CartoonDao {

	public CartoonDaoImpl() {
	}
	
	/*
	 * This method is a mock Dao implementation.
	 * Instead of going to a database it has a hard coded list of characters.
	 */
	@Override
	public List<CartoonCharacter> selectAll() {
		List<CartoonCharacter> carts = new ArrayList<>();
		
		carts.add(new CartoonCharacter("Bugs Bunny", "Looney Toons", "WB"));
		carts.add(new CartoonCharacter("Zoidberg", "Futurama", "Fox"));
		carts.add(new CartoonCharacter("Bojack Horsemen", "BojackHorsemen", "Netflix"));
		carts.add(new CartoonCharacter("Rick Sanchez", "Rick & Morty", "Adult Swim"));
		carts.add(new CartoonCharacter("Mr E", "Scooby Doo", "Cartoon Network"));
		
		return carts;
	}
	
}
