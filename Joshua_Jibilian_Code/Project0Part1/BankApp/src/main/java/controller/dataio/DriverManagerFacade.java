package controller.dataio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerFacade {
	public Connection getConn (String s, String y, String c) throws SQLException {
		return DriverManager.getConnection(s, y, c);
	}
}
