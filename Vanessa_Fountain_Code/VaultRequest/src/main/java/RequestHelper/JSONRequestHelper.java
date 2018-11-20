package RequestHelper;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.HomeController;
import Controller.ReimbursementController;

public class JSONRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException{
		System.out.println("in json disp");
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		
			case "/VaultRequest/resources/html/reqTable.json":
				System.out.println("in the switch");
				ReimbursementController.viewRequests(req,resp);
			
			default:
				HomeController.home(req);
		}
	}

}
