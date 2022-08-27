package com.revature.daos;

import java.sql.ResultSet;
import java.util.List;

import com.revature.models.User;

public interface UserDAO {
	User createUser(User u);
	User retrieveUserById(int id);
	List<User> retrieveUsers();
	User retrieveUserByUsername(String username);
	boolean updateUser(User u);
	boolean deleteUserById(int id);
	User returnData(ResultSet rs,User user);
	boolean updateUserStatus(int uid, int status );
	List<User> retrieveUsersByRoleid(int rid);

}
