/**
 * 
 */
package com.revature.daos;

import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
 
public interface UserDAO {
	User insertUser(User u);
	User getUserById(int id);
	User getUserByUsername(String username);
	boolean updatetUser(User u);
	List<User> getByRole(Role role);
}
