package com.seclore.todolist.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.seclore.todolist.domain.TaskDetails;
import com.seclore.todolist.domain.UserDetails;

public class TaskDetailsRowMapper implements RowMapper<TaskDetails> {

	@Override
	public TaskDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		try {
			TaskDetails taskDetails;
			UserDetails userDetails=new UserDetails();
			int taskId= rs.getInt("task_id");
			int userId=rs.getInt("user_id");
			String title=rs.getString("title");
			String description=rs.getString("description");
			String status=rs.getString("status");
			
			userDetails.setUserId(userId);
			taskDetails=new TaskDetails(taskId, userDetails, title, description, status);
			return taskDetails;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
