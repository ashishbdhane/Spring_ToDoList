package com.seclore.todolist.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.seclore.todolist.domain.UserDetails;

//Row mapper of UserDetails
public class UserDetailsRowMapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(rs.getInt("user_id"));
		userDetails.setName(rs.getString("name"));
		userDetails.setMobileNo(rs.getString("mobile_no"));
		userDetails.setEmail(rs.getString("email"));
		userDetails.setPassword(rs.getString("password"));
		return userDetails;
	}
	
}
