package com.dikokosolutions.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dikokosolutions.model.User;

public class UserDao implements MasterDao {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Returns a user arrayList that contains each attribute of the user table in my
	// database
	// I then pass those variables into a new user, by setting the attributes to the
	// member variables in my user class
	// I then store that user into my arrayList which I use in my userServiceImlpl
	// class
	public ArrayList<User> getUserInformation() {
		ArrayList<User> userArrayList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String selectUser = "Select * from ERS_USERS";
			PreparedStatement select = conn.prepareStatement(selectUser);
			ResultSet rs = select.executeQuery();

			while (rs.next()) {
				User u = new User(rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"),
						rs.getInt("user_role_id"));
				userArrayList.add(u);
				// System.out.println(userArrayList);

			}

		} catch (SQLException e) {

		}
		return userArrayList;

	}

}
