package com.dao.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.profiles.Account;
import com.profiles.Client;

public class ClientDAOImplementation implements ClientDAO {
	private static String url = "jdbc:oracle:thin:@usf-revature-sean.ctfo6zflqljh.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "RykerIndustries";
	private static String password = "revature1";

	@Override
	public int insertClient(Client c) {
		int rs = 0;
		System.out.println(c.toString());
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO clients (client_id, familyname, givenname, passwordc, isactive, myaccountnumber)VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getClientID() + "");
			ps.setString(2, c.getFamilyName());
			ps.setString(3, c.getGivenName());
			ps.setString(4, c.getPassword());
			if (c.getClientStatus()) {
				ps.setString(5, 1 + "");
			} else {
				ps.setString(5, 0 + "");
			}
			ps.setString(6, c.getClientAccount() + "");
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	@Override
	public ArrayList<Client> selectAllClients() {
		ArrayList<Client> clients = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM clients";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				clients.add(new Client(rs.getInt("client_id"), rs.getString("familyname"), rs.getString("givenname"),
						rs.getString("passwordc"), rs.getInt("isactive") == 1,
						rs.getInt("myaccountnumber")));
			}
			Client.clientCount = clients.size();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public int updateCLient(Client c) {
		int rs = 0;
		System.out.println(c.toString());
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE clients SET familyname = ?, givenname = ?, passwordc = ?, isactive = ?, myaccountnumber = ? WHERE client_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getFamilyName());
			ps.setString(2, c.getGivenName());
			ps.setString(3, c.getPassword());
			if (c.getClientStatus()) {
				ps.setInt(4, 1);
			} else {
				ps.setInt(4, 0);
			}
			ps.setInt(5, c.getClientAccount());
			ps.setInt(6, c.getClientID());
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int deleteClient(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addJoint(Account a, Client c) {
		int rs = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE clients SET myaccountnumber = ? WHERE client_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getAccountNumber() + "");
			ps.setString(2, c.getClientID() + "");
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int activateClient(Client c, int anum) {
		int rs = 0;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE clients SET isactive = 1, myaccountnumber = ? WHERE client_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, anum);
			ps.setString(2, c.getClientID() + "");
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public Client checkClientLogin(String first, String last, String password) {
		Client temp = null;
		try (Connection conn = DriverManager.getConnection(url, username, this.password)) {
			String sql = "SELECT * FROM clients WHERE givenname = ? AND familyname = ? AND passwordc = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, first.toLowerCase());
			ps.setString(2, last.toLowerCase());
			ps.setString(3, password.toLowerCase());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				temp = new Client(rs.getInt("client_id"), rs.getString("familyname"), rs.getString("givenname"),
						rs.getString("passwordc"), rs.getInt("isactive") == 1,
						rs.getInt("myaccountnumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public ArrayList<Integer> getClients(String p) {
		ArrayList<Integer> clientnums = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "";
			if (p.equals("p")) {
				sql = "SELECT client_id FROM clients WHERE isactive = 0";
			} else {
				sql = "SELECT client_id FROM clients";
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				clientnums.add(rs.getInt("client_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientnums;
	}
}
