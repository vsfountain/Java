package revERS.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import revERS.DAO.ReImbDAO;
import revERS.DAO.UserDAO;
import revERS.model.Reimbursement;
import revERS.model.User;

public class UserService {
	public static Logger logger = Logger.getLogger(UserService.class);
	public static User login(String username, String password) {
		logger.info("In UserService.login()");
		return UserDAO.selectLogin(username, password);
	}
	public static User getById(int i) {
		logger.info("In UserService.getById()");
		return UserDAO.selectId(i);
	}
	public static int approve(int rid, int uid) {
		logger.info("In UserService.approve()");
		return ReImbDAO.updateStatus(rid, uid, "Approved");
	}
	public static int deny(int rid, int uid) {
		logger.info("In UserService.deny()");
		return ReImbDAO.updateStatus(rid, uid, "Denied");
	}
	public static int newReimbursement(double amt, String descr, int auth, String type) {
		logger.info("In UserService.newReimbursement()");
		return ReImbDAO.insert(amt, descr, auth, type);
	}
	public static String getReimbursements(){
		logger.info("In UserService.getReimbursements()");
		ArrayList<Reimbursement> reimb = ReImbDAO.selectAll();
		String json = null;
		try {
			json = new ObjectMapper().writeValueAsString(reimb);
			logger.info(json);
		} catch (JsonProcessingException e) {
			logger.error("JsonProcessingException in getReimbursements()", e);
		}
		return json;
	}
	public static String getUserReimbursements(int id){
		logger.info("In UserService.getUserReimbursements()");
		ArrayList<Reimbursement> reimb = ReImbDAO.selectByUser(id);
		String json = null;
		try {
			json = new ObjectMapper().writeValueAsString(reimb);
			logger.info(json);
		} catch (JsonProcessingException e) {
			logger.error("JsonProcessingException in getReimbursements()", e);
		}
		return json;
	}
}
