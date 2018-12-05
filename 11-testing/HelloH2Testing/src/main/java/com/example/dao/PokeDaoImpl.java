package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Pokemon;

public class PokeDaoImpl implements PokeDao {

	//H2 DATABASE note:
	//the "./folder1/folder2" will show up in the same directory as your project. Go check it after you run the main
	private static String url=
			"jdbc:h2:./folder1/folder2/theData";
	private static String username="sa";
	private static String password="sa";
	
	public PokeDaoImpl() {
	}
	
	public PokeDaoImpl(String _url, String _username, String _password) {
		url= _url;
		username = _username;
		password = _password;
	}
	
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
		List<Pokemon> pokes = new ArrayList<>();
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= "SELECT * FROM pokemon WHERE pokemon_name='" + name+"';";
			
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
		
		if(pokes.size()==0)
			return null;
		else
			return pokes.get(0);
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

	@Override
	public void h2InitDao() {
		//I am inserting two pokemon "types" into the database, but my Pokemon model in the model layer
		//	only uses one type. I simplified the model for demo purposes. AND to demo that your model can
		//	differ from the actual database table, in JDBC.
		
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= ""+
			"CREATE TABLE pokemon( "+
					"pokemon_id INTEGER, "+
					"pokemon_name VARCHAR(100), "+
					"pokemon_type VARCHAR(25), "+
					"pokemon_secondtype VARCHAR(25), "+
					"PRIMARY KEY (pokemon_id) "+
					"); "+
					"INSERT INTO pokemon VALUES(1, 'bulbasaur', 'grass', 'poison'); "+
					"INSERT INTO pokemon VALUES(7, 'squirtle', 'water', 'none'); "+
					"INSERT INTO pokemon VALUES(25, 'pikachu', 'electric', 'none'); "+
					"INSERT INTO pokemon VALUES(129, 'Magikarp', 'water', 'best'); "+
					"INSERT INTO pokemon(pokemon_id, pokemon_type, pokemon_name) VALUES(143, 'normal', 'snorlax'); ";
			
			Statement state = conn.createStatement();
			state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void h2DestroyDao() {
		try(Connection conn=
				DriverManager.getConnection(url,username, password))
		{
			String sql= ""+
			"DROP TABLE pokemon; ";
			
			Statement state = conn.createStatement();
			state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}