package VaultLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ModelLayer.VaultUser;

public class LoginImplementation implements LoginInterface{
	private static String url="jdbc:oracle:thin:@revature.cakynjhhcvux.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String user= "reimburse_admin";
	private static String pass = "MyPassword";

	public void addNewDweller(VaultUser newDweller) {
		
	}

	public int checkInfo(String username, String password) {
		//HashMap<Object, Object> map = new HashMap<>();
		int userID = 0;
		//FOR HASHMAP IMPLEMENTATION USE GET ALL SQL STATEMENT
		//SELECT * FROM ERS_USERS WHERE ERS_USERNAME = 'vsfount' and ERS_PASSWORD = 'password';
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("SELECT ERS_USERS_ID FROM ERS_USERS WHERE ERS_USERNAME = ? and ERS_PASSWORD = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				userID = rs.getInt("ERS_USERS_ID");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userID;
	}

	public void changeInfo(VaultUser VaultUsersID) {
		
	}

	public void deleteDwellerAccess(VaultUser dwellerRelease) {
		
	}



}
