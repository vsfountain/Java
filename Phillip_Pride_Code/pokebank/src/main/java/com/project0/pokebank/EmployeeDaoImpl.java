package com.project0.pokebank;

import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDao {
	private static String url = "jdbc:oracle:thin:@revatur-instance.cyxb24oq9oml.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "pokebank";
	private static String password = "NurseJoy95";

	@Override
	public void getBoxApplications() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT username FROM trainers WHERE hasAppliedForBox = 1";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			System.out.println("Here are your clients with pending box applications:");
			while (rs.next()) {
				System.out.println(rs.getString("username"));
				;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void reviewBoxApplication(String name, int ans) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE trainers SET hasAppliedForBox = 0 WHERE username = '" + name + "'";
			String sql2 = "UPDATE trainers SET hasBoxAccess = " + ans + " WHERE username = '" + name + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps.executeUpdate();
			ps2.executeUpdate();

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
					System.out.println("This trainer does not have access to an open PC box.");
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
							System.out.println("This Trainer does not have a " + poke + " staying with us.");
						}
					}
				}

				else {
					System.out.println("This trainer does not have access to an open PC box.");
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

	@Override
	public void deleteBox(String name) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "DELETE FROM pcbox WHERE " + "trainer_id = (SELECT trainer_id FROM trainers WHERE "
					+ "username = '" + name + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
