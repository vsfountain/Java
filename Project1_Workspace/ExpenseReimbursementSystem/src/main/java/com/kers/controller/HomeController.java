package com.kers.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;
import com.kers.daos.UserDAOImpl;
import com.kers.models.Reimbursement;
import com.kers.models.User;
import com.kers.services.ReimbursementService;
import com.kers.services.ReimbursementServiceImpl;
import com.kers.services.UserService;
import com.kers.services.UserServiceImpl;
import com.oreilly.servlet.MultipartRequest;

public class HomeController {

	private String filePath;
	private static ReimbursementService rService = new ReimbursementServiceImpl();
	private static UserService uService = new UserServiceImpl();
	
	final static Logger logger = Logger.getLogger(HomeController.class);

	public static String home(HttpServletRequest req) {
		return "employeehome.html";
	}

	public static String processReimbursement(HttpServletRequest req) throws IOException {
		
		System.out.println("-------------REIMBURSEMENT-------------");

		int maxFileSize = 5000 * 1024;
		int maxMemSize = 4 * 1024;
		File file;
		String filePath = req.getServletContext().getInitParameter("file-upload");

		
		Timestamp dateSubmitted = new Timestamp(System.currentTimeMillis());

		MultipartRequest m = new MultipartRequest(req, filePath);
		String type = m.getParameter("reimb-type");
		double amount = Double.parseDouble(m.getParameter("amount"));
		File receiptFile = m.getFile("receipt");

		byte[] receiptBytes = null;
		receiptBytes = FileUtils.readFileToByteArray(receiptFile);
		System.out.println("BYTES: " + receiptBytes);
		Blob receipt = null;
		
		String description = m.getParameter("description");
		
		User u = (User) req.getSession().getAttribute("user");
		String author = u.getUsername();

		Reimbursement r = new Reimbursement(amount, description, receiptBytes, author, type);
		logger.info("Processing reimbursement from user: " + author + " with reimbursement info: " + r);
		rService.addReimbursement(r);
		List<Reimbursement> temp = rService.getAllReimbursements();
		req.getSession().setAttribute("reimbursementlist", temp);
		return "employeeadd.html";
	}
}
