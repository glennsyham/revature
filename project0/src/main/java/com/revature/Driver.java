package com.revature;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controller.UserController;
import com.revature.exceptions.LoginException;
import com.revature.services.AuthService;
import com.revature.services.OfferServices;

public class Driver {
	static OfferServices os;
	private static Logger log = LogManager.getLogger(Driver.class);
	static AuthService as;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		UserController u = new UserController();
		u.UserStartMenu();		
	}

}
