package com.example.dao;

import java.util.List;

import com.example.model.CartoonCharacter;

public interface CartoonDao {
	public List<CartoonCharacter> selectAll();
}
