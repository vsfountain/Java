package com.simulate.Kavanagh.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simulate.Kavanagh.bank.model.Administrator;

/**
 * 
 * @author Kristen Kavanagh
 * @version 11/4/2018
 *
 */
public class AdministratorDaoImpl implements AdministratorDao {
	private static String url = "";
	private static String username = "";
	private static String password = "";

	@Override
	public int insertAdministrator(Administrator admin) {
		return 0;
	}

	@Override
	public List<Administrator> selectAllAdminstrator() {
		List<Administrator> admins = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * From Administrator";
			PreparedStatement prepState = conn.prepareStatement(sql);
			ResultSet reultEt = prepState.executeQuery();
			while (reultEt.next()) {

				admins.add(new Administrator(reultEt.getInt("admin_id"), reultEt.getString("adminFirstName"),
						reultEt.getString("adminLastName"), reultEt.getString("adminEmail")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}

	@Override
	public Administrator selectAdministratorById(int admin_id) {
		return null;
	}

	@Override
	public Administrator selectAdministratorByAdminFirstName(String adminFirstName) {
		return null;
	}

	@Override
	public Administrator selectAdministratorByAdminLastName(String adminLastName) {
		return null;
	}

	@Override
	public Administrator selectAdministratorByAdminEmail(String adminEmail) {
		return null;
	}

	@Override
	public int updateAdministrator(Administrator admin) {
		return 0;
	}

	@Override
	public int deleteAdministrator(Administrator admin) {
		return 0;
	}

	@Override
	public List<Administrator> selectAllAdministrator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrator> getAllAdministrator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrator> selectAllAdministrator(String adminFirstName) {
		// TODO Auto-generated method stub
		return null;
	}

}
