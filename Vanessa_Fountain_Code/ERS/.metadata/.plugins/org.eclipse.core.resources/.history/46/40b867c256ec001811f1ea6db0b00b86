package Controller;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/VaultRequest/login.vault867":
			return LoginController.login(req);
		case "/VaultRequest/home.vault867":
			return HomeController.home(req);
		default: 
			return "resources/html/UnsuccessfulLogin.html";
		}
	}
}
