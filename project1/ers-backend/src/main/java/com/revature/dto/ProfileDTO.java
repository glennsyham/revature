package com.revature.dto;

import com.revature.models.Role;
import com.revature.models.User;

public class ProfileDTO {
	private int id;
	private String username;
 	private String first_name;
 	private String last_name;
 	private String email;	
	private Role role;

	public ProfileDTO(User u) {
		id = u.getId();
		username = u.getUsername();
		first_name = u.getFirst_name();
		last_name = u.getLast_name();
		email = u.getEmail();
		role = u.getRole();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
