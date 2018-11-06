package com.bank.registration.dao;

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
			String sql = "INSERT INTO registrations(registrationid, username, password, firstname, lastname, jointcustomer) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getId());
			ps.setString(2, r.getUsername());
			ps.setString(3, r.getPassword());
			ps.setString(4, r.getFirstName());
			ps.setString(5, r.getLastName());
			ps.setBoolean(6, r.isJointCustomer());

			ps.executeUpdate();

		} catch (SQLException ex) {
			// createAccountDB();
			ex.printStackTrace();
			System.out.println("ohno");
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
						rs.getString(5), new Boolean(rs.getInt(6) == 1 ? true : false));
				// System.out.println(r);
				registrationList.add(r);
			}

		} catch (SQLException ex) {
			// createAccountDB();
			ex.printStackTrace();
			System.out.println("ohno");
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
			System.out.println("A");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getId());

			return ps.executeUpdate();

		} catch (SQLException ex) {
			// createAccountDB();
			ex.printStackTrace();
			System.out.println("ohno");
		}
		return 0;
	}

	@Override
	public int createRegistrationDB() {
		try (Connection con = DriverManager.getConnection(getUrl(), getUsername(), getPassword())) {
			String sql = "CREATE TABLE Registrations(" + "RegistrationID NUMBER PRIMARY KEY,"
					+ "Username VARCHAR2(30) NOT NULL," + "Password VARCHAR2(50) NOT NULL,"
					+ "FirstName VARCHAR2(50) NOT NULL," + "LastName VARCHAR2(50)," + "JointCustomer NUMBER NOT NULL)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return 0;
	}

}
