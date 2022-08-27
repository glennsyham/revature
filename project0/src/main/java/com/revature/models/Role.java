package com.revature.models;

import java.util.Objects;

public class Role {
	private int id;
	private String role_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, role_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return id == other.id && Objects.equals(role_name, other.role_name);
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role_name=" + role_name + "]";
	}

}
