/**
 * 
 */
package com.revature.services;

import java.util.List;

import com.revature.daos.RoleDAO;
import com.revature.daos.RoleHibernate;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UserNotUpdatedException;
import com.revature.models.Role;
import com.revature.models.User;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class UserService {

	private UserDAO ud = new UserHibernate();
	private static Logger log = LogManager.getLogger(UserService.class);
	
	public User getUserById(int id) throws UserNotFoundException {
		log.info(id);
		User u = ud.getUserById(id);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}	
	
	public List<User> getByRole(String role_name) {
		RoleDAO rh = new RoleHibernate();
		Role r = rh.getByName(role_name);
 		List<User> users = ud.getByRole(r);
		return users;
	}
	
	public boolean updatetUser(User u) throws UserNotUpdatedException {
		log.info(u);
		boolean checkUpdate =ud.updatetUser(u);
		if (checkUpdate == false) {
			throw new UserNotUpdatedException();
		}
		return checkUpdate;
	}

}
