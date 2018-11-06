package com.project0.pokebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainerDaoImpl implements TrainerDao {
	private static String url = "jdbc:oracle:thin:@revatur-instance.cyxb24oq9oml.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "pokebank";
	private static String password = "NurseJoy95";

	@Override
	public void createTrainer(String name, String passw) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO trainers(username, password, "
					+ "hasAppliedForBox, hasBoxAccess) VALUES(?,?,0,0)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, passw);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Trainer> getAllTrainers() {
		ArrayList<Trainer> trainers = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM trainers";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				trainers.add(new Trainer(rs.getString("username"), rs.getString("password")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainers;
	}

	@Override
	public int getTrainerId(String name) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT trainer_id FROM trainers WHERE username='" + name + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt("trainer_id");
			}

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<String> getTrainerBox(String name) {
		ArrayList<String> box = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT pokemon FROM pcbox WHERE trainer_id = "
					+ "(SELECT trainer_id FROM trainers WHERE username = '" + name + "')";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				box.add(rs.getString("Pokemon"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return box;
	}

	@Override
	public void applyForBox(String name) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE trainers SET hasAppliedForBox = 1 WHERE username = '" + name + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void depositPoke(String poke, String name) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT hasBoxAccess FROM trainers WHERE username='" + name + "'";
			String sql2 = "INSERT INTO pcbox(pokemon, trainer_id) " + "Values('" + poke
					+ "', (SELECT trainer_id FROM trainers WHERE username='" + name + "'))";

			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getBoolean("hasBoxAccess")) {
					ps2.executeUpdate(sql2);
				}

				else {
					System.out.println("You do not have access to an open PC box. Please apply for one.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdrawPoke(String poke, String name) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT trainer_id, hasBoxAccess FROM trainers WHERE username='" + name + "'";
			String sql2 = "SELECT trainer_id FROM pcbox WHERE pokemon='" + poke + "'";
			String sql3 = "DELETE FROM pcbox WHERE pokemon='" + poke + "' AND trainer_id = "
					+ "(SELECT trainer_id FROM trainers WHERE username='" + name + "')";

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
		}
	}

	@Override
	public void transferPoke(String poke, String name, String moveTo) {
		withdrawPoke(poke, name);
		depositPoke(poke, moveTo);
	}

	
}
