package com.jwjibilian.daos;

import java.awt.Image;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.jwjibilian.controller.DBDriver;
import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.Admin;
import com.jwjibilian.model.user.Client;
import com.jwjibilian.model.user.User;


public class ReimbursementDAOImpl implements ReimbursementDAO {

	DBDriver orclDriver = new DBDriver();

	@Override
	public ArrayList<Reimbursement> getUserReimbursments(User u) {
		ResultSet result = null;
		ArrayList<Reimbursement> toReturn = new ArrayList<Reimbursement>();
		String query = "SELECT REIMB_ID, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_AMMOUNT, REIMB_TYPE, REIMB_STATUS, REIMB_RECEIPT, REIMB_DESCRIPTION "
				+ "FROM " + "ERS_REIMBURSEMENT re "
				+ "RIGHT JOIN ERS_REIMBURSEMENT_STATUS status on re.REIMB_STATUS_ID = status.REIMB_STATUS_ID "
				+ "RIGHT JOIN ERS_REIMBURSEMENT_TYPE reType on re.REIMB_TYPE_ID = reType.REIMB_TYPE_ID "
				+ "WHERE re.REIMB_AUTHOR = ?";
		System.out.println(u.getId());
		try (Connection conn = orclDriver.connect()) {
			PreparedStatement cs = conn.prepareStatement(query);
			cs.setInt(1, u.getId());
			
			result = cs.executeQuery();
			while (result.next()) {
				int id = result.getInt("REIMB_ID");
				double ammount = result.getDouble("REIMB_AMMOUNT");
				LocalDate timeSubmitted = result.getObject("REIMB_SUBMITTED", LocalDate.class);
				LocalDate timeResolved = result.getObject("REIMB_RESOLVED", LocalDate.class);
				String description = result.getString("REIMB_DESCRIPTION");
				Image recipit = null;
				Client author = (Client)u;
				Admin resolver = null;
				String status = result.getString("REIMB_STATUS");
				String type = result.getString("REIMB_TYPE");
				Reimbursement toAdd =  new Reimbursement(
						id, ammount, timeSubmitted, timeResolved, 
						description, recipit, author, resolver, 
						status, type);
				//System.out.println(toAdd);
				toReturn.add(toAdd);
			}
			cs.close();
		} catch (SQLException e) {

		}
		//System.out.println(toReturn);
		return toReturn;
	}

	@Override
	public boolean addReimbursement(int userId, double ammount, String type, String desc) {
		String sql = "INSERT INTO ers_reimbursement VALUES (null, ?, TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'), "
				+ "null, ?, null, ?, null, 1, ?)";
		Instant time = Instant.now();
		Timestamp ts = java.sql.Timestamp.from( time );
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") .withZone(ZoneId.systemDefault());
		String datetime = formatter.format(time);
		System.out.println(datetime);
		int typeNum = 4;
		if(type.equals("Lodging")) {
			typeNum = 1;
		} else if(type.equals("Travel")) {
			typeNum = 2;
			
		} else if(type.equals("Food")) {
			typeNum = 3;
		} 
		
		try (Connection conn = orclDriver.connect()) {
			PreparedStatement cs = conn.prepareStatement(sql);
			cs.setDouble(1, ammount);
			cs.setString(2, datetime);
			cs.setString(3, desc);
			cs.setInt(4, userId);
			cs.setInt(5, typeNum);
			int result = cs.executeUpdate();
			if(result == 1) {
				return true;
			}
			
		} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
		return false;
	}

}
