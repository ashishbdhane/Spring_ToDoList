package com.seclore.todolist.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seclore.todolist.domain.TaskDetails;
import com.seclore.todolist.domain.UserDetails;

@Repository
public class TaskDetailsRepository implements TaskDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String GET_ALL_TASK_OF_USER="SELECT * from task_details where user_id=?";
	private static final String ADD_TASK="INSERT INTO task_details (user_id, title, description, status) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_TASK="update task_details set title=?,description=?,status=? where task_id=? ";
	private static final String DELETE_TASK="delete task_details where task_id=?";
	private static final String GET_TASK_BY_TASK_ID="SELECT * from task_details where task_id=?";
	
	
	
	
	@Override
	public List<TaskDetails> getAllTaskOfUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.query(GET_ALL_TASK_OF_USER, new TaskDetailsRowMapper());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public boolean addTask(TaskDetails taskDetails) {
		// TODO Auto-generated method stub
	
		Object[] args = { taskDetails.getUserDetails().getUserId() ,taskDetails.getTitle(),taskDetails.getDescription(),taskDetails.getStatus()};
		int count= jdbcTemplate.update(ADD_TASK,args );
		if(count>0) return true;
			
		return false;
	}

	@Override
	public boolean updateTask(TaskDetails taskDetails) {
		// TODO Auto-generated method stub
		Object[] args = {taskDetails.getTitle(),taskDetails.getDescription(),taskDetails.getStatus(),taskDetails.getTaskId()};
		int count= jdbcTemplate.update(UPDATE_TASK,args);
		if(count>0) return true;
		return false;
	}

	@Override
	public boolean deleteTask(TaskDetails taskDetails) {
		// TODO Auto-generated method stub
		
		int count= jdbcTemplate.update(DELETE_TASK,taskDetails.getTaskId());
		if(count>0) return true;
		return false;
		
	}

	@Override
	public TaskDetails getTaskByTaskId(int taskId) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject(GET_TASK_BY_TASK_ID, new TaskDetailsRowMapper(),taskId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}

}
