package com.petshop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class MapperUser implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();		
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFullName(rs.getString("fullname"));
		user.setGender(rs.getString("gender"));
		user.setDateOfBirth(rs.getDate("dateofbirth"));		
		user.setPhoneNumber(rs.getString("phonenumber"));
		user.setEmail(rs.getString("email"));
	//	user.setRoleId(rs.getInt("roleid"));
		user.setStatus(rs.getInt("status"));
		try {
			Role role = new Role();
			role.setCode(rs.getString("code"));
			role.setName(rs.getString("name"));
			user.setRole(role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
