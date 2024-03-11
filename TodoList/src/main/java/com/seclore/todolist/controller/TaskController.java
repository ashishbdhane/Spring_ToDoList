package com.seclore.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seclore.todolist.domain.TaskDetails;
import com.seclore.todolist.domain.UserDetails;
import com.seclore.todolist.service.TaskDetailsServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskDetailsServiceInterface taskService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showTodoListPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("alltasks");
		UserDetails userDetails = (UserDetails) session.getAttribute("loggedInUser");
		List<TaskDetails> allTasks = taskService.getAllTaskOfUser(userDetails);
		modelAndView.addObject("allTasks", allTasks);
			
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showAddTaskPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addtask");
		TaskDetails taskDetails = new TaskDetails();
		modelAndView.addObject("taskDetails", taskDetails);
			
		return modelAndView;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView showEditTaskPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addtask");
		TaskDetails taskDetails = taskService.getTaskById();
		modelAndView.addObject("taskDetails", taskDetails);
			
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addTask() {
		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void updateTask() {
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteTask() {
		
	}
}
