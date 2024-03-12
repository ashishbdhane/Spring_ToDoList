package com.seclore.todolist.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.seclore.todolist.domain.TaskDetails;
import com.seclore.todolist.domain.UserDetails;
//RowMapper of TaskDetails
public class TaskDetailsRowMapper implements RowMapper<TaskDetails> {
	
	@Override
	public TaskDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		TaskDetails taskDetails = null;
		UserDetails userDetails=new UserDetails();  //creating userDetails object
		try {
			
			int taskId= rs.getInt("task_id"); 	//Retrieving task_id from ResultSet
			int userId=rs.getInt("user_id"); 	//Retrieving user_id from ResultSet
			String title=rs.getString("title");	//Retrieving title from ResultSet
			String description=rs.getString("description"); //Retrieving description from ResultSet
			String status=rs.getString("status"); //Retrieving status from ResultSet
			
			userDetails.setUserId(userId); //setting userId in userDetails
			taskDetails=new TaskDetails(taskId, userDetails, title, description, status); //creating TaskDetails object
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return taskDetails;	//Returning the taskDetails object Returning null if any case of exception  
	}

}
