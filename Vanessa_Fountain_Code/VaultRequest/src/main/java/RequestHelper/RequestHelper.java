package RequestHelper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import Controller.DwellerController;
import Controller.HomeController;
import Controller.LoginController;
import Controller.ReimbursementController;

public class RequestHelper {
	public static String process(HttpServletRequest req) throws JsonProcessingException, IOException {
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/VaultRequest/login.vault867":
			return LoginController.login(req);
		case "/VaultRequest/home.vault867":
			return HomeController.home(req);
		case "/VaultRequest/dweller.vault867":
			return DwellerController.request(req);
		case "/VaultRequest/newReq.vault867":
			return ReimbursementController.insertRequest(req);
		
		default: 
			return "resources/html/UnsuccessfulLogin.html";
		}
	}
}
