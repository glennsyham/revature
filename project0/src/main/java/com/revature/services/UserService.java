package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.UserDAO;
import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class UserService {

	private UserDAO ud = new UserPostgres();
	private static Logger log = LogManager.getLogger(UserService.class);

	public List<User> getUsers() {
		return ud.retrieveUsers();
	}

	public User createUser(User u) {
		// logic to validate u
		// if ok
//		u = ud.createUser(u);
		return ud.createUser(u);
	}
	
	public User retrieveUserById(int id) {
		return ud.retrieveUserById(id);
	}	
	
	public User retrieveUserByUsername(String username) {
		return ud.retrieveUserByUsername(username);
	}	
 
	public boolean deleteUserById(int id) {
		return ud.deleteUserById(id);
	}		
	
	public boolean updateUserStatus(int uid, int status) {
		return ud.updateUserStatus(uid,status);
	}
	
	public List<User> retrieveUsersByRoleid(int rid) {
		return ud.retrieveUsersByRoleid(rid);
	}
}
