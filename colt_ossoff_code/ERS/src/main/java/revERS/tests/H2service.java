package revERS.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import revERS.model.User;

public class H2service {
	
	public String login(String uname, String password) {
		User u = H2UserDAO.selectLogin(uname, password);
		try {
			String json = new ObjectMapper().writeValueAsString(u);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String byId(int id) {
		User u = H2UserDAO.selectId(id);
		try {
			String json = new ObjectMapper().writeValueAsString(u);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void h2Init() {
		H2UserDAO.h2InitDao();
	}
	public void h2Destroy() {
		H2UserDAO.H2destroyDAO();
	}
}
