package Controller;

import javax.servlet.http.HttpServletRequest;

public class HomeController {
	public static String home(HttpServletRequest req) {
		return "resources/html/Home.html";
	}

}
