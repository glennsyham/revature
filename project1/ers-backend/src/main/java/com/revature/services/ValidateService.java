package com.revature.services;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateService {
	public boolean checkManager(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		if(session.getAttribute("userRole") == null)  {
			return false;
		}
		if(!session.getAttribute("userRole").toString().equals("manager")) {
			messageWrite(req, resp, 401); 
			return false;
		}

		return true;
	}
	
	public boolean checkUserId(HttpServletRequest req, HttpServletResponse resp, int id) {
		HttpSession session = req.getSession();
		if(((Integer) session.getAttribute("userId")).intValue() != id && !session.getAttribute("userRole").toString().equals("manager")) {
			messageWrite(req, resp, 401); 
			return false;
		}
		return true;
	}	
	
	public void messageWrite(HttpServletRequest req, HttpServletResponse resp,int no) {
		PrintWriter pw;
		try {
			pw = resp.getWriter();
			resp.setStatus(no);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
