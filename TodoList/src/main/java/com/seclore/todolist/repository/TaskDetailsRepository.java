package com.seclore.todolist.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seclore.todolist.domain.TaskDetails;
import com.seclore.todolist.domain.UserDetails;

@Repository
public class TaskDetailsRepository implements TaskDetailsRepositoryInterface {

    // Injecting JdbcTemplate for database interaction
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // SQL queries for CRUD operations
    private static final String GET_ALL_TASK_OF_USER = "SELECT * FROM task_details WHERE user_id=?";
    private static final String ADD_TASK = "INSERT INTO task_details (user_id, title, description, status) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_TASK = "UPDATE task_details SET title=?, description=?, status=? WHERE task_id=?";
    private static final String DELETE_TASK = "DELETE FROM task_details WHERE task_id=?";
    private static final String GET_TASK_BY_TASK_ID = "SELECT * FROM task_details WHERE task_id=?";
    
    // Method to retrieve all tasks of a user
    @Override
    public List<TaskDetails> getAllTaskOfUser(UserDetails userDetails) {
        try {
            // Execute the SQL query using JdbcTemplate and return the result
            return jdbcTemplate.query(GET_ALL_TASK_OF_USER, new TaskDetailsRowMapper(), userDetails.getUserId());
        } catch (Exception e) {
            // Handle exceptions and print error messages
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Method to add a new task
    @Override
    public boolean addTask(TaskDetails taskDetails) {
        // Prepare the arguments for the SQL query
        Object[] args = {taskDetails.getUserDetails().getUserId(), taskDetails.getTitle(), taskDetails.getDescription(), taskDetails.getStatus()};
        // Execute the SQL query using JdbcTemplate and check the result
        int count = jdbcTemplate.update(ADD_TASK, args);
        return count > 0;
    }

    // Method to update an existing task
    @Override
    public boolean updateTask(TaskDetails taskDetails) {
        // Prepare the arguments for the SQL query
        Object[] args = {taskDetails.getTitle(), taskDetails.getDescription(), taskDetails.getStatus(), taskDetails.getTaskId()};
        // Execute the SQL query using JdbcTemplate and check the result
        int count = jdbcTemplate.update(UPDATE_TASK, args);
        return count > 0;
    }

    // Method to delete a task
    @Override
    public boolean deleteTask(TaskDetails taskDetails) {
        // Execute the SQL query using JdbcTemplate and check the result
        int count = jdbcTemplate.update(DELETE_TASK, taskDetails.getTaskId());
        return count > 0;
    }

    // Method to retrieve a task by its ID
    @Override
    public TaskDetails getTaskByTaskId(int taskId) {
        try {
            // Execute the SQL query using JdbcTemplate and return the result
            return jdbcTemplate.queryForObject(GET_TASK_BY_TASK_ID, new TaskDetailsRowMapper(), taskId);
        } catch (Exception e) {
            // Handle exceptions and print error messages
            System.out.println(e.getMessage());
            return null;
        }
    }
}
