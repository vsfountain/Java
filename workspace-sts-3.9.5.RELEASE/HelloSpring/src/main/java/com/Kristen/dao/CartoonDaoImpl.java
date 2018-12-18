package com.Kristen.dao;

import java.util.ArrayList;
import java.util.List;

import com.Kristen.model.CartoonCharacter;

public class CartoonDaoImpl implements CartoonDao {
	/**
	 * This method is a mock Dao implementation. Instead of going to a database it
	 * has a hard coded list of characters.
 */

	public List<CartoonCharacter> selectAll() {
		List<CartoonCharacter> carts = new ArrayList<CartoonCharacter>();

		carts.add(new CartoonCharacter("Bugs Bunny", "Looney Toons", "wb"));
		carts.add(new CartoonCharacter("Daffey Duck", "Looney Toons", "wb"));

		return carts;
	}




	
}
