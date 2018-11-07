package com.bank.registration.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.connection.DAOConnection;
import com.bank.registration.model.Registration;

public class RegistrationDAOImpl extends DAOConnection implements RegistrationDAO {

	@Override
	public int insertRegistration(Registration r) {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "{ call insert_registration_null_id(?, ?, ?, ?, ?) }";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, r.getUsername());
			cs.setString(2, r.getPassword());
			cs.setString(3, r.getFirstName());
			cs.setString(4, r.getLastName());
			cs.setInt(5, r.getJointPartner());

			return cs.executeUpdate();
		} catch (SQLException ex) {
			//ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Registration> selectAllRegistration() {
		ArrayList<Registration> registrationList = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "SELECT * FROM registrations";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Registration r = new Registration(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
				registrationList.add(r);
			}

		} catch (SQLException ex) {
			// createAccountDB();
			//ex.printStackTrace();
		}
		// System.out.println(registrationList);
		return registrationList;
	}

	@Override
	public Registration selectRegistrationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateRegistration(Registration r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRegistation(Registration r) {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "DELETE FROM Registrations WHERE registrationid = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getId());

			return ps.executeUpdate();

		} catch (SQLException ex) {	
			//ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int createRegistrationDB() {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "CREATE TABLE Registrations(" + "RegistrationID NUMBER PRIMARY KEY,"
					+ "Username VARCHAR2(30) NOT NULL," + "Password VARCHAR2(50) NOT NULL,"
					+ "FirstName VARCHAR2(50) NOT NULL," + "LastName VARCHAR2(50)," + "JointPartner NUMBER)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return 0;
	}

}
