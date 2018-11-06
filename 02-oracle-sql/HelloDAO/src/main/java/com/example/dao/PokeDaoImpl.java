package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Pokemon;

public class PokeDaoImpl implements PokeDao {

	private static String url=
			"jdbc:oracle:thin:@rainforest-closet.c4wt8faaxlgp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username="pokemondb";
	private static String password="p4ssw0rd";
	
	@Override
	public int insertPokemon(Pokemon p) {
		return 0;
	}

	@Override
	public List<Pokemon> selectAllPokemon() {
		List<Pokemon> pokes = new ArrayList<>();
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM pokemon";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				pokes.add(new Pokemon(rs.getInt(1), rs.getString(2),
						rs.getString("pokemon_type")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pokes;
	}

	@Override
	public Pokemon selectPokemonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pokemon selectPokemonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pokemon> selectByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePokemon(Pokemon p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePokemon(Pokemon p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
