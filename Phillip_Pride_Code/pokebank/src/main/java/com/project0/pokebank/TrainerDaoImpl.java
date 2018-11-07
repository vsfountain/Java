package com.project0.pokebank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class TrainerDaoImpl implements TrainerDao {
	private static String url = "jdbc:oracle:thin:@revatur-instance.cyxb24oq9oml.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "pokebank";
	private static String password = "NurseJoy95";
	final static Logger logger = Logger.getLogger(TrainerDaoImpl.class);

	@Override
	public void createTrainer(String name, String passw) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call add_trainer(?,?) }";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, name);
			cs.setString(2, passw);

			cs.executeUpdate();
			logger.info("Account for " + name + " was successfully created.");
		} catch (SQLException e) {
			logger.error("There was an error creating an account for " + name + ".",
					new SQLException());
		}
	}

	@Override
	public ArrayList<Trainer> getAllTrainers() {
		ArrayList<Trainer> trainers = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM trainers ORDER BY trainer_id";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				trainers.add(new Trainer(rs.getString("username"), rs.getString("password"), rs.getInt("trainer_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainers;
	}

	@Override
	public int getTrainerId(Trainer trainer) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT trainer_id FROM trainers WHERE username='" + trainer.getUsername() + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt("trainer_id");
			}

			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error retrieving " + trainer.getUsername() + "'s id.", new SQLException());
		}
		return 0;
	}

	@Override
	public List<String> getTrainerBox(Trainer trainer) {
		ArrayList<String> box = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT pokemon FROM pcbox WHERE trainer_id = "
					+ "(SELECT trainer_id FROM trainers WHERE username = '" + trainer.getUsername() + "')";

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
	public void applyForBox(Trainer trainer) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE trainers SET hasAppliedForBox = 1 WHERE username = '" + trainer.getUsername() + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
			logger.info(trainer.getUsername() + " has applied for a PC box.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void depositPoke(String poke, Trainer trainer) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT hasBoxAccess FROM trainers WHERE username='" + trainer.getUsername() + "'";
			String sql2 = "INSERT INTO pcbox(pokemon, trainer_id) " + "Values('" + poke
					+ "', " + getTrainerId(trainer) + ")";

			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getBoolean("hasBoxAccess")) {
					ps2.executeUpdate(sql2);
					logger.info(trainer.getUsername() + " has deposited a " + poke + ".");
				}

				else {
					System.out.println("You do not have access to an open PC box. Please apply for one.");
					logger.warn(trainer.getUsername() + " attempted to deposit a Pok\u00E9mon "
							+ "without an open PC box.");
				}
			}
		} catch (SQLException e) {
			logger.error("There was an issue depositing " + poke + " into " +
							trainer.getUsername() + "'s PC box.", new SQLException());
		}
	}

	@Override
	public void withdrawPoke(String poke, Trainer trainer) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT trainer_id, hasBoxAccess FROM trainers WHERE username='" + trainer.getUsername() + "'";
			String sql2 = "SELECT trainer_id FROM pcbox WHERE pokemon='" + poke + "'";
			String sql3 = "DELETE FROM pcbox WHERE pokemon='" + poke + "' AND trainer_id = "
					+ "(SELECT trainer_id FROM trainers WHERE username='" + trainer.getUsername() + "')";

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
							logger.warn(trainer.getUsername() + " attempted to withdraw a Pok\u00E9mon they did"
									+ " not own. They may be from Team Rocket!");
						}
					}
				}

				else {
					System.out.println("You do not have access to an open PC box. Please apply for one.");
					logger.warn(trainer.getUsername() + " attempted to withdraw a Pok\u00E9mon "
							+ "without an open PC box.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void transferPoke(String poke, Trainer trainer, Trainer trainer2) {
		withdrawPoke(poke, trainer);
		depositPoke(poke, trainer2);
		logger.info(trainer.getUsername() + " has transferred a " + poke + " to " + trainer2.getUsername() + 
				".");
	}

	
}
