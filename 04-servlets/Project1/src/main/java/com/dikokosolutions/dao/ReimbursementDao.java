package com.dikokosolutions.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dikokosolutions.model.Reimbursement;

public class ReimbursementDao implements MasterDao {
	Reimbursement reimburse = new Reimbursement();

	public ArrayList<Reimbursement> getAllReimbursementsFromDB() {
		ArrayList<Reimbursement> reimArrayList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "select * from ers_reimbursement r join ers_users e on r.reimb_author = E.ERS_USERS_ID order by reimb_status_id, reimb_author ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				Reimbursement reim = new Reimbursement();
				reim.setReim_id(s.getInt("reimb_id"));
				reim.setReim_amount(s.getInt("reimb_amount"));
				reim.setReim_author_name(s.getString("user_first_name"));
				reim.setReim_author(s.getInt("reimb_author"));
				reim.setReim_resolver(s.getInt("reimb_resolver"));
				reim.setReim_status(s.getInt("reimb_status_id"));
				reim.setReim_type_id(s.getInt("reimb_type_id"));
				reim.setReim_description(s.getString("reimb_description"));
				reim.setReim_submitted(s.getDate("reimb_submitted"));
				reim.setReim_resolved(s.getDate("reimb_resolved"));
				reimArrayList.add(reim);
			}
		} catch (SQLException e) {

		}
		// System.out.println(reimburse.getReim_author());
		return reimArrayList;
	}

	public String getReim() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String s = "Select * from ers_reimbursement";
			PreparedStatement p = conn.prepareStatement(s);
		} catch (SQLException e) {
		}
		return "";
	}

	public ArrayList<Reimbursement> getUserReimbursement(String user) {
		ArrayList<Reimbursement> reimArrayList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "select * from ers_reimbursement r join ers_users e on r.reimb_author = E.ERS_USERS_ID where ers_username = ? order by reimb_status_id, reimb_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(user);
			ps.setString(1, user);
			ResultSet s = ps.executeQuery();
			while (s.next()) {
				Reimbursement reim = new Reimbursement();
				reim.setReim_id(s.getInt("reimb_id"));
				reim.setReim_amount(s.getInt("reimb_amount"));
				reim.setReim_author_name(s.getString("user_first_name"));
				reim.setReim_author(s.getInt("reimb_author"));
				reim.setReim_resolver(s.getInt("reimb_resolver"));
				reim.setReim_status(s.getInt("reimb_status_id"));
				reim.setReim_type_id(s.getInt("reimb_type_id"));
				reim.setReim_description(s.getString("reimb_description"));
				reim.setReim_submitted(s.getDate("reimb_submitted"));
				reim.setReim_resolved(s.getDate("reimb_resolved"));
				reimArrayList.add(reim);
			}
		} catch (SQLException e) {
			System.out.println("Error");

		}
		// System.out.println(reimburse.getReim_author());
		return reimArrayList;
	}

	public void createReimbursement(Double amount, int author, int status_id, int type_id, String descr)
			throws SQLException {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "INSERT INTO ERS_REIMBURSEMENT " + "(reimb_amount,"
					+ "reimb_author, reimb_status_id, reimb_type_id, reimb_description)" + "VALUES (?, ?, ?, ?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, author);
			ps.setInt(3, status_id);
			ps.setInt(4, type_id);
			ps.setString(5, descr);
			ps.executeUpdate();

		}
	}

	public void approveReimBursement(int reim_id, int num, int user_id) {
		System.out.println("approve reimbursement 1");
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "update ers_reimbursement set reimb_status_id = ?, "
					+ "reimb_resolved = Current_timestamp, reimb_resolver = ? " + "where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, user_id);
			ps.setInt(3, reim_id);

			// ps.executeUpdate();
			System.out.println("approve reimbursement 2");
			ps.executeUpdate();

		} catch (SQLException E) {
			E.getStackTrace();
			System.out.println("approve reimbursement 3");
		}
		System.out.println("approve reimbursement 4");
	}

	public static void deleteReimbursement(int id) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "delete from ERS_REIMBURSEMENT where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException E) {
			E.getStackTrace();
			System.out.println("approve reimbursement 3");
		}
		System.out.println("approve reimbursement 4");
	}

}
