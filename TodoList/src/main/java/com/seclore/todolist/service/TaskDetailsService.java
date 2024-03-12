package com.seclore.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seclore.todolist.domain.TaskDetails;
import com.seclore.todolist.domain.UserDetails;
import com.seclore.todolist.repository.TaskDetailsRepositoryInterface;

@Service
public class TaskDetailsService implements TaskDetailsServiceInterface {
	
	// Injecting taskDetailsRepository class which is implements TaskDetailsRepositoryInterface
	@Autowired
	TaskDetailsRepositoryInterface taskDetailsRepository;
	
	 // Method to retrieve all tasks of a user
	@Override
	public List<TaskDetails> getAllTaskOfUser(UserDetails userDetails) {
		return taskDetailsRepository.getAllTaskOfUser(userDetails);
	}

	// Method to add a new task
	@Override
	public boolean addTask(TaskDetails taskDetails) {
		return taskDetailsRepository.addTask(taskDetails);
	}

	// Method to update an existing task
	@Override
	public boolean updateTask(TaskDetails taskDetails) {
		return taskDetailsRepository.updateTask(taskDetails);
	}

	
	// Method to delete a task
	@Override
	public boolean deleteTask(TaskDetails taskDetails) {
		return taskDetailsRepository.deleteTask(taskDetails);
	}

	 // Method to retrieve a task by its ID
	@Override
	public TaskDetails getTaskByTaskId(int taskId) {
		// TODO Auto-generated method stub
	
		return taskDetailsRepository.getTaskByTaskId(taskId);
	}
	
	

}
