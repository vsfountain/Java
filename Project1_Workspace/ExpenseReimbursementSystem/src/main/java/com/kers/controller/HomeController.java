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

import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;
import com.kers.models.Reimbursement;
import com.kers.models.User;
import com.oreilly.servlet.MultipartRequest;

public class HomeController {

	private String filePath;

	public static String home(HttpServletRequest req) {
		return "home.html";
	}

	public static String processReimbursement(HttpServletRequest req) throws IOException {
		System.out.println("-------------REIMBURSEMENT-------------");

		int maxFileSize = 5000 * 1024;
		int maxMemSize = 4 * 1024;
		File file;
		String filePath = req.getServletContext().getInitParameter("file-upload");

		/*
		 * String type = req.getParameter("reimb-type"); System.out.println("Type is: "
		 * + type); double amount = Double.parseDouble(req.getParameter("amount")); Blob
		 * receipt = null; // req.getParameter("receipt-file"); String description =
		 * req.getParameter("description");
		 */
		/*
		 * User u = (User)req.getSession().getAttribute("user"); String username =
		 * u.getUsername();
		 */
		// LocalDateTime dateSubmitted = LocalDateTime.now();
		Timestamp dateSubmitted = new Timestamp(System.currentTimeMillis());

		/* upload file */
		/*
		 * boolean isMultipart; isMultipart = ServletFileUpload.isMultipartContent(req);
		 * 
		 * DiskFileItemFactory factory = new DiskFileItemFactory();
		 * factory.setSizeThreshold(maxMemSize); factory.setRepository(new
		 * File("c:\\temp")); ServletFileUpload upload = new ServletFileUpload(factory);
		 * upload.setSizeMax(maxFileSize);
		 */
		MultipartRequest m = new MultipartRequest(req, filePath);
		String type = m.getParameter("reimb-type");
		double amount = Double.parseDouble(m.getParameter("amount"));
		File receiptFile = m.getFile("receipt");

		byte[] receiptBytes = null;
		receiptBytes = FileUtils.readFileToByteArray(receiptFile);
		System.out.println("BYTES: " + receiptBytes);
		Blob receipt = null;
		
		String description = m.getParameter("description");
		/*
		 * try { List fileItems = upload.parseRequest(req); Iterator i =
		 * fileItems.iterator();
		 * 
		 * while (i.hasNext()) { FileItem fi = (FileItem) i.next(); if
		 * (!fi.isFormField()) { String fieldName = fi.getFieldName(); String fileName =
		 * fi.getName(); String contentType = fi.getContentType(); boolean isInMemory =
		 * fi.isInMemory(); long sizeInBytes = fi.getSize();
		 * 
		 * if (fileName.lastIndexOf("\\") >= 0) { file = new File(filePath +
		 * fileName.substring(fileName.lastIndexOf("\\"))); } else { file = new
		 * File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1)); }
		 * fi.write(file); System.out.println("Uploaded filename: " + fileName);
		 * 
		 * } } } catch (Exception ex) { System.out.println(ex); } end upload file
		 * 
		 */

		User u = (User) req.getSession().getAttribute("user");
		String author = u.getUsername();
		System.out.println(type + " " + amount + " " + receiptBytes + " " + description + " " + dateSubmitted);

		Reimbursement r = new Reimbursement(amount, description, receiptBytes, author, type);
		System.out.println("reimb: " + r);
		ReimbursementDAO rdao = new ReimbursementDAOImpl();
		rdao.insertReimbursement(r);
		List<Reimbursement> temp = rdao.selectAllReimbursements();
		System.out.println("process reimbursements: " + temp);
		req.getSession().setAttribute("reimbursementlist", temp);
		return "home.html";
	}
}
