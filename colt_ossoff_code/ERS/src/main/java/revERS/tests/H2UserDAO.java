package revERS.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import revERS.DAO.UserDAO;
import revERS.model.User;

public class H2UserDAO {
	private static String url = "jdbc:h2:./test/h2db/theData";
	private static String username = "sa";
	private static String password = "s";
	public static Logger logger = Logger.getLogger(UserDAO.class);
	public static User selectLogin(String uname, String pwd) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			logger .info("In UserDAO.selectLogin()");
			String sql = "SELECT u.ers_users_id, u.ers_username, u.USER_FIRST_NAME, u.USER_LAST_NAME, u.user_email, r.user_role " + 
					"FROM ers_users u LEFT OUTER JOIN ers_user_roles r ON u.USER_ROLE_ID = r.ers_user_role_id " + 
					"WHERE u.ers_username = ? AND u.ers_password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new User (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static User selectId(int id) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			logger.info("In UserDAO.selectId()");
			String sql = "SELECT u.ers_users_id, u.ers_username, u.USER_FIRST_NAME, u.USER_LAST_NAME, u.user_email, r.user_role " + 
					"FROM ers_users u LEFT OUTER JOIN ers_user_roles r ON u.USER_ROLE_ID = r.ers_user_role_id " + 
					"WHERE u.ers_users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new User (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void h2InitDao() {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql1 = "CREATE TABLE ERS_USER_ROLES " + 
					"( " + 
					"ERS_USER_ROLE_ID NUMBER NOT NULL, " + 
					"USER_ROLE VARCHAR2(10), " + 
					"CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY (ERS_USER_ROLE_ID)" + 
					" )";
			String sql2 = "CREATE TABLE ERS_USERS " + 
					"(" + 
					"ERS_USERS_ID NUMBER NOT NULL, " + 
					"ERS_USERNAME VARCHAR2(50) UNIQUE NOT NULL, " + 
					"ERS_PASSWORD VARCHAR2(50) NOT NULL, " + 
					"USER_FIRST_NAME VARCHAR2(100) NOT NULL, " + 
					"USER_LAST_NAME VARCHAR2(100) NOT NULL, " + 
					"USER_EMAIL VARCHAR2(100) UNIQUE NOT NULL, " + 
					"USER_ROLE_ID NUMBER NOT NULL, " + 
					"CONSTRAINT ERS_USERS_PK PRIMARY KEY (ERS_USERS_ID), " + 
					"CONSTRAINT USER_ROLES_FK FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID) )";
					
			
			String sql3 = 
					"INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID,USER_ROLE) VALUES(1,'Employee'); " + 
					"INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID,USER_ROLE) VALUES(2,'Admin'); ";
			String sql4 = 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(1,'coltossoff','12345','Colt','Ossoff','coltossoff@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(2,'seandoyle','12345','Sean','Doyle','SCDoyle316@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(3,'phillippride','12345','Phillip','Pride','phillipjpride@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(4,'kristenkavanagh','12345','Kristen','Kavanagh','Kristen.kavanagh.wright@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(5,'alexandriawise','12345','Alexandria','Wise','alexandriarwise@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(6,'michaeljung','12345','Michael','Jung','michael.jungrevature@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(7,'bronwenhughes','12345','Bronwen','Hughes','bronwen@hughesnet.org',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(8,'ryanwilliams','12345','Ryan','Williams','rrwilliams1600@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(9,'vanessafountain','12345','Vanessa','Fountain','vanessa.s.fountain@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(10,'louispipkin','12345','Louis','Pipkin','ldpipkin@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(11,'joshuajibilian','12345','Joshua','Jibilian','jwjibilian@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(12,'johnjosephsavath','12345','John','Savath','Johnsavath@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(13,'michaelgrammens','12345','Michael','Grammens','MLGrammens@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(14,'clementdikoko','12345','Clement','Dikoko','clementdikoko94@gmail.com',1);" + 
					"INSERT INTO ERS_USERS (ERS_USERS_ID,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(15,'trevinchester','help','Trevin','Chester','Trevin.Chester@revature.com',2);";
			Statement state = conn.createStatement();
			state.execute(sql1);
			state.execute(sql2);
			state.execute(sql3);
			state.execute(sql4);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void H2destroyDAO() {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			String sql = "DROP TABLE ERS_USER_ROLES;" +
						 "DROP TABLE ERS_USERS;";
			Statement state = conn.createStatement();
			state.execute(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
