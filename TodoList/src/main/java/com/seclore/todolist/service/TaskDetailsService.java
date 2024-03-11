package com.seclore.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seclore.todolist.domain.TaskDetails;
import com.seclore.todolist.domain.UserDetails;
import com.seclore.todolist.repository.TaskDetailsRepositoryInterface;

@Service
public class TaskDetailsService implements TaskDetailsServiceInterface {
	
	@Autowired
	TaskDetailsRepositoryInterface taskDetailsRepository;
	@Override
	public List<TaskDetails> getAllTaskOfUser(UserDetails userDetails) {
		return taskDetailsRepository.getAllTaskOfUser(userDetails);
	}

	@Override
	public boolean addTask(TaskDetails taskDetails) {
		return taskDetailsRepository.addTask(taskDetails);
	}

	@Override
	public boolean updateTask(TaskDetails taskDetails) {
		return taskDetailsRepository.updateTask(taskDetails);
	}

	@Override
	public boolean deleteTask(TaskDetails taskDetails) {
		return taskDetailsRepository.deleteTask(taskDetails);
	}

	@Override
	public TaskDetails getTaskByTaskId(int taskId) {
		// TODO Auto-generated method stub
	
		return taskDetailsRepository.getTaskByTaskId(taskId);
	}
	
	

}
