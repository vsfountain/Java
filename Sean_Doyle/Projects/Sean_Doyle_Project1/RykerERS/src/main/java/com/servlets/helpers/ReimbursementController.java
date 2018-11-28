package com.servlets.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.classes.Reimbursement;
import com.classes.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servicelayer.ERSService;
import com.servicelayer.ERSServiceImplementation;

public class ReimbursementController {
	private static ERSService eserv = new ERSServiceImplementation();
	final static Logger logger = Logger.getLogger(ReimbursementController.class);

	// Part of Action
	public static String add(HttpServletRequest req, HttpServletResponse resp) {
		String description="";
		String type="";
		String amountS="";
		String filePath = "";
		boolean fileUploaded = false;
		try {
		        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
		        for (FileItem item : items) {
		        	System.out.println(item.toString());
		            if (item.isFormField()) {
		                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
		                String fieldName = item.getFieldName();
		                String fieldValue = item.getString();
		                if (fieldName.equals("description")) {
		                	description = fieldValue;
		                } else if (fieldName.equals("type")) {
		                	type = fieldValue;
		                } else if (fieldName.equals("amount")) {
		                	amountS = fieldValue;
		                }
		                System.out.println(description + "  " + type + " "+ amountS);
		            } else {
		                // Process form file field (input type="file").
		                String fieldName = item.getFieldName();
		                String fileName = FilenameUtils.getName(item.getName());
		                InputStream fileContent = item.getInputStream();
		                System.out.println("Garbage");
		                
		                fileUploaded = true;
		                
                        String root = req.getServletContext().getRealPath("/");
                        File path = new File(root + "/uploads");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);
                        filePath=path + "/" + fileName;
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
		            }
		        }
		    } catch (FileUploadException e) {
		        e.printStackTrace();
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		System.out.println("wesndfij csdjc sdkcvds v");
		double amount = Double.parseDouble(amountS);
		String username = (String) req.getSession().getAttribute("username");
		boolean completed = false;
		if (fileUploaded) {
			completed = eserv.addReimbursementReceipt(amount, description, username, type, filePath);
		} else {
			completed = eserv.addReimbursement(amount, description, username, type);
		}
		
		if (completed) {
			logger.info("@add		Success: User " + username + " has added a new reimbursement for " + type
					+ " in amount of " + amount);
			return "Add Successful";
		} else {
			logger.info("@add		FAIL: User " + username + " did not add a new reimbursement for " + type
					+ " in amount of " + amount);
			return "Add NOT Successful";
		}
	}
	
	// Part of JSON
	public static String getByName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = (String) req.getSession().getAttribute("username");
		String myJSON = "[ ]";
		ArrayList<Reimbursement> loggysReimbs = eserv.getAllUserReimbs(username);
		if (loggysReimbs.size() >= 1) {
			logger.info("@getByName		Success: User " + username + " has received their reimbursement history");
			myJSON = new ObjectMapper().writeValueAsString(loggysReimbs);
		} else {
			logger.info(
					"@getByName		FAIL: User " + username + " does not have reimbursement history or bad username");
		}
		return myJSON;
	}


	// Part of JSON
	public static String getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = (String) req.getSession().getAttribute("username");
		User nowUser = (User) req.getSession().getAttribute("nowUser");
		String reimbJSON = "[ ]";
		if (nowUser == null) {
			logger.info("@getAll		FAIL: User " + username + " IS NOT VALID");
		} else if (nowUser.getRole().toLowerCase().equals("admin")) {
			ArrayList<Reimbursement> loggysReimbs = eserv.getAllReimbs();
			if (loggysReimbs.size() >= 1) {
				logger.info("@getAll		Success: Admin " + username + " has received ALL reimbursement history");
				reimbJSON = (String) new ObjectMapper().writeValueAsString(loggysReimbs);
			} else {
				logger.info("@getAll		FAIL: Admin " + username
						+ " did not receive reimbursement history or no history exists");
			}
		} else {
			logger.info("@getAll		FAIL: User " + username + " IS NOT AN ADMIN");		
		}
		return reimbJSON;
	}
	
	public static String getAllBlob(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = (String) req.getSession().getAttribute("username");
		User nowUser = (User) req.getSession().getAttribute("nowUser");
		String reimbJSON = "[ ]";
		if (nowUser == null) {
			logger.info("@getAll		FAIL: User " + username + " IS NOT VALID");
		} else if (nowUser.getRole().toLowerCase().equals("admin")) {
			ArrayList<Reimbursement> loggysReimbs = eserv.getAllReimbs();
			if (loggysReimbs.size() >= 1) {
				logger.info("@getAll		Success: Admin " + username + " has received ALL reimbursement history");
				reimbJSON = (String) new ObjectMapper().writeValueAsString(loggysReimbs);
			} else {
				logger.info("@getAll		FAIL: Admin " + username
						+ " did not receive reimbursement history or no history exists");
			}
		} else {
			logger.info("@getAll		FAIL: User " + username + " IS NOT AN ADMIN");		
		}
		return reimbJSON;
	}
	
	
	// Part of Action
	public static String updateById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User nowUser = (User) req.getSession().getAttribute("nowUser");
		int reimb_id = Integer.parseInt(req.getParameter("reimbid"));
		String decision = req.getParameter("decision");
		if (eserv.updateReimbursement(nowUser, reimb_id, decision)) {
			logger.info("@updateById		Success: Admin " + nowUser.getUsername() + " has updated reimbursement " + decision);
			return decision +" Successful";
		} else {
			logger.info("@updateById		FAIL: Admin " + nowUser.getUsername() + " DID NOT update reimbursement " + decision);
			return decision +" NOT Successful";
		}
	}
}
/*
 * System.out.println(loggysReimbs); String myJSON = "[ "; boolean firstGo =
 * true; for (Reimbursement r: loggysReimbs) { // System.out.println(r); if
 * (!firstGo) { myJSON += ", "; } myJSON += (String) new
 * ObjectMapper().writeValueAsString(r); firstGo = false; //
 * System.out.println(myJSON); } myJSON += " ]";
 */