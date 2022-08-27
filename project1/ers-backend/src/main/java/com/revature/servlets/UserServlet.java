/**
 * 
 */
package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ProfileDTO;
import com.revature.dto.ReimbursementDTO;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UserNotUpdatedException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import com.revature.services.ValidateService;
import com.revature.util.CorsFix;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 */
public class UserServlet extends HttpServlet {
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

	}

	private UserService us = new UserService();
	private ObjectMapper om = new ObjectMapper();
	private ReimbursementService rs = new ReimbursementService();
	private AuthService as = new AuthService();
	private ValidateService vs = new ValidateService();
	private static Logger log = LogManager.getLogger(UserServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

		String pathInfo = req.getPathInfo();
		HttpSession session = req.getSession();

		if (pathInfo == null) {
			if(vs.checkManager(req, resp)) {
				List<User> users = us.getByRole("employee");
				List<ProfileDTO> profileDTO = new ArrayList<>();
				users.forEach(u -> profileDTO.add(new ProfileDTO(u)));
				PrintWriter pw = resp.getWriter();
				pw.write(om.writeValueAsString(profileDTO));
				pw.close();
			}

		} else {
			String regex = "[0-9]/[\breim]";

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(pathInfo);
			if (matcher.find()) {
				String[] pathParts = pathInfo.split("/");

				int id = Integer.parseInt(pathParts[1]);
				
				if(vs.checkUserId(req, resp, id)) {
					try (PrintWriter pw = resp.getWriter()) {
						log.info("Reimbursement by Author");
						User u = us.getUserById(id);
						List<Reimbursement> reimburse = rs.getByAuthor(u);
						List<ReimbursementDTO> reimDTO = new ArrayList<>();
						reimburse.forEach(r -> reimDTO.add(new ReimbursementDTO(r)));
						pw.write(om.writeValueAsString(reimDTO));
						pw.close();
						resp.setStatus(200);

					} catch (ReimbursementNotFoundException | UserNotFoundException e) {
						// TODO: handle exception
						log.info("User Not found");
 						vs.messageWrite(req, resp, 404);
						e.printStackTrace();
					}			
				}


			} else {
				int id = Integer.parseInt(pathInfo.substring(1));
				try (PrintWriter pw = resp.getWriter()) {
					log.info("User Profile");
					User u = us.getUserById(id);
					
					ProfileDTO profileDTO = new ProfileDTO(u);
					resp.setStatus(200);

					pw.write(om.writeValueAsString(profileDTO));
					pw.close();
				} catch (UserNotFoundException e) {
					// TODO: handle exception
					log.info("User Not found");
					vs.messageWrite(req, resp, 404);
					e.printStackTrace();
				}
				
			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPut(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

		InputStream reqBody = req.getInputStream();

		String pathInfo = req.getPathInfo();
//
		int id = Integer.parseInt(pathInfo.substring(1));

		User u = om.readValue(reqBody, User.class);
		u.setId(id);

		HttpSession session = req.getSession();
		if(vs.checkUserId(req, resp, id)) {
			try {
				log.info("Update User");
				boolean bool = us.updatetUser(u);
				try (PrintWriter pw = resp.getWriter()) {
					pw.write(om.writeValueAsString(u));
					resp.setStatus(200);
					pw.close();
				}
			} catch (UserNotUpdatedException e) {
				// TODO Auto-generated catch block
				log.info("User Update Failed");
				vs.messageWrite(req, resp, 404);
				e.printStackTrace();
			}			
		}


	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doDelete(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
	}

}
