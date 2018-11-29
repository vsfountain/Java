package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.ErsReimbursement;

public class H2ErsReimbursementDaoImpl implements H2ErsReimbursementDao {

	private static String url=
					"jdbc:h2:./folder1/folder2/theData";
	private static String username="sa";
	private static String password="sa";
	
	public H2ErsReimbursementDaoImpl(String _url, String _username, String _password) {
		url= _url;
		username = _username;
		password = _password;
	}
	@Override
	public List<ErsReimbursement> selectAllErsReimbursements() {
		// TODO Auto-generated method stub
		List<ErsReimbursement> ersReimbursements = new ArrayList<>();
		try(Connection conn =
						DriverManager.getConnection(url, username, password))
		{
				String sql= "SELECT * FROM ers_reimbursement";
				
				PreparedStatement ps= conn.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				
				while(rs.next())
				{
					ersReimbursements.add(new ErsReimbursement(rs.getInt("reimb_id"),
																rs.getInt("reimb_amount"),
																null,
																null,
																null,
																null,
																rs.getInt("reimb_author"),
																rs.getInt("reimb_status_id"),
																rs.getInt("reimb_type_id"),
																rs.getInt("reimb_resolver")));
				}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ersReimbursements;
		
	}

	@Override
	public int insertReimbursement(ErsReimbursement ersReimbursement) {
		// TODO Auto-generated method stub
int status = 0;
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			/*String sql = "{ call insert_reimbursement(?,?,?,?) }";*/
			String sql = "insert into ers_reimbursement values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement cs = conn.prepareCall(sql);
			cs.setInt(1, ersReimbursement.getReimbursementId());
			cs.setDouble(2, ersReimbursement.getReimbursementAmount());
			cs.setDate(3, (java.sql.Date)ersReimbursement.getReimbursementSubmittedDate());
			cs.setDate(4, (java.sql.Date)ersReimbursement.getReimbursementResolvedDate());
			cs.setString(5, ersReimbursement.getReimbursementDescription());
			cs.setString(6, ersReimbursement.getReimbursementReceipt());
			cs.setInt(7, ersReimbursement.getReimbursementErsUserId());
			cs.setInt(8, ersReimbursement.getReimbursementStatusId());
			cs.setInt(9, ersReimbursement.getReimbursementTypeId());
			cs.setInt(10, ersReimbursement.getReimbursementResolverId());
			
			status = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public void h2InitDao() {
		// TODO Auto-generated method stub

		try(Connection conn=
						DriverManager.getConnection(url,username, password))
		{
				String sql= ""+
				"CREATE TABLE ers_reimbursement( " +
						"reimb_id INTEGER, " +
						"reimb_amount INTEGER, " +
						"reimb_submitted TIMESTAMP, " +
						"reimb_resolved TIMESTAMP, " +
						"reimb_description VARCHAR2(250), " +
						"reimb_receipt BLOB, " +
						"reimb_author INTEGER, " +
						"reimb_status_id INTEGER, " +
						"reimb_type_id INTEGER, " +
						"reimb_resolver INTEGER " +
						"); "+
						"INSERT INTO ers_reimbursement VALUES(1, 4, null, null, null, null, 2, 3, 2, null); "+
						"INSERT INTO ers_reimbursement VALUES(2, 5, null, null, null, null, 2, 1, 1, null); "+
						"INSERT INTO ers_reimbursement VALUES(3, 6, null, null, null, null, 2, 2, 3, null); ";
				
				Statement state = conn.createStatement();
				state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void h2DestroyDao() {
		// TODO Auto-generated method stub

		try(Connection conn=
						DriverManager.getConnection(url, username, password))
		{
				String sql= ""+
				"DROP TABLE ers_reimbursement; ";
				
				Statement state = conn.createStatement();
				state.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
