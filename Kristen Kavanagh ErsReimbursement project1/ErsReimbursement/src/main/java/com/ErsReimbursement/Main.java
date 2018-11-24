package com.ErsReimbursement;

public class Main {

		
public static void main(String[] args) {
	//UserService userService = UserServiceImpl.Login();
	//UserDao logUser =  UserDaoImpl.selectUserByLoginInfo(UserName, PassWord);

		System.out.println("done");
		
		// connects with db
			//System.out.println("Hey this is the jamiej's userid:" + UserService.getCurrUserName("Jamiej"));
		}

	}
//		
//		public static void callableStatementExample(String p_name,
//												String p_type)
//		{
//			try(Connection conn=
//					DriverManager.getConnection(url, username, password))
//			{
//				String sql= "{ call insert_pokemon_null_id(?,?) }";
//				
//				CallableStatement cs= conn.prepareCall(sql);
//				cs.setString(1, p_name); //notice how we start at 1
//				cs.setString(2, p_type);
//				
//				int status = cs.executeUpdate();
//				System.out.println("CallableStatement returns: "+status);
//			}catch(SQLException  e) {
//				e.printStackTrace();
//			}
//		}
//		
//		public static void preparedStatementExample(String p_name,
//												String p_type)
//		{
//			try(Connection conn=
//					DriverManager.getConnection(url, username, password))
//			{
//				String sql= "INSERT INTO pokemon(pokemon_name, pokemon_type) "+
//							"VALUES(?,?)";
//				
//				PreparedStatement ps= conn.prepareStatement(sql);
//				ps.setString(1, p_name);
//				ps.setString(2, p_type);
//				
//				ps.executeUpdate();
//				
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//
//		
//	}
//		
		