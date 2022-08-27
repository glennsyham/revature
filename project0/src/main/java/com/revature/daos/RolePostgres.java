package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Role;
import com.revature.models.Role;
import com.revature.util.ConnectionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RolePostgres implements RoleDAO {
	private String _table  = "roles";
	private static Logger log = LogManager.getLogger(RolePostgres.class);
	
	@Override
	public List<Role> retrieveRole() {
		String sql = "select * from "+ _table +";";
		List<Role> roles = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			// no Role input taken, no need for prepared statement
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				// extract each field from rs for each record, map them to a Role object and add
				// them to the roles arrayliost
				Role u = new Role();
				u.setId(rs.getInt("id"));
				u.setRole_name(rs.getString("role_name"));

				roles.add(u);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return roles;
	}

}
