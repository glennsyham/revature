package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import com.revature.models.User;
import com.revature.services.UserService;

public class UserServiceTest {
	private static UserService uservice;
	private static User currentuser;
	private static int userid;

	@BeforeAll
	public static void setUp() {
		uservice = new UserService();
 		userid = 0;
	}

	// createUser, retrieveUserById, deleteUserById
	@Test
	public void add() {
		User cu = new User();
		cu.setUsername("test");
		cu.setPassword("test");
		cu.setRole_id(2);
		User actual = uservice.createUser(cu);
 		assertNotNull(actual);
		uservice.deleteUserById(actual.getId());
	}

	@Test
	public void retrieveById() {		
		User actual =  uservice.retrieveUserById(100);
		assertNotNull(actual);
 	}	
 
	@Test
	public void deleteById() {
		Boolean actual =  uservice.deleteUserById(0);
		assertFalse(actual);
 	}	
}
