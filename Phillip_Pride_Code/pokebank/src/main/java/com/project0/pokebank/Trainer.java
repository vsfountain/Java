package com.project0.pokebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Trainer {

	

	private String usrname;
	private String pword;
	private ArrayList<Account> accounts;
	boolean hasOpenBox;
	protected String application;
	int boxNum = 0;

	public Trainer(String usrname, String password) {
		this.usrname = usrname.toLowerCase();
		this.pword = password;
		accounts = new ArrayList<>();
		hasOpenBox = false;
		application = "no";
	}

	String getUsername() {
		return usrname;
	}

	String getPassword() {
		return pword;
	}

	Account getBox(String name) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountName().equals(name)) {
				return accounts.get(i);
			}
		}
		return null;

	}

	/*int applyForBox() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE trainers SET hasAppliedForBox = 1 WHERE username = '" + usrname + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			int rs = ps.executeUpdate();

			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}*/

	void withdraw(String poke) {
		/*try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT trainer_id, hasBoxAccess FROM trainers WHERE username='" + getUsername() + "'";
			String sql2 = "SELECT trainer_id FROM pcbox WHERE pokemon='" + poke + "'";
			String sql3 = "DELETE FROM pcbox WHERE pokemon='" + poke + "' AND trainer_id = "
					+ "(SELECT trainer_id FROM trainers WHERE username='" + getUsername() + "')";

			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 = ps2.executeQuery();

			while (rs.next()) {
				if (rs.getBoolean("hasBoxAccess")) {
					while (rs2.next()) {
						if (rs.getInt("trainer_id") == rs2.getInt("trainer_id")) {
							ps3.executeUpdate();
							//System.out.println("Here is your " + poke + " safe and sound!");
						} else {
							System.out.println("You don't have a " + poke + " staying with us.");
						}
					}
				}

				else {
					System.out.println("You do not have access to an open PC box. Please apply for one.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	void deposit(String poke, String name) {
		/*try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT hasBoxAccess FROM trainers WHERE username='" + name + "'";
			String sql2 = "INSERT INTO pcbox(pokemon, trainer_id) " + "Values('" + poke
					+ "', (SELECT trainer_id FROM trainers WHERE username='" + name + "'))";

			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getBoolean("hasBoxAccess")) {
					ps2.executeUpdate(sql2);
					//System.out.println("Thank you! We will keep your " + poke + " safe until your return!");
				}

				else {
					System.out.println("You do not have access to an open PC box. Please apply for one.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	/*void transfer(String poke, String moveTo) {
		withdraw(poke);
		deposit(poke, moveTo);
		
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
	}*/

	@Override
	public String toString() {
		return "Trainer [username = " + usrname + "\n";
	}
}
