package com.seclore.todolist.repository;

import java.util.List;

import com.seclore.todolist.domain.TaskDetails;
import com.seclore.todolist.domain.UserDetails;

public interface TaskDetailsRepositoryInterface {
	public List<TaskDetails> getAllTaskOfUser(UserDetails userDetails);
	public boolean addTask(TaskDetails taskDetails);
	public boolean updateTask(TaskDetails taskDetails);
	public boolean deleteTask(TaskDetails taskDetails);
	public TaskDetails getTaskByTaskId(TaskDetails taskDetails);
}
