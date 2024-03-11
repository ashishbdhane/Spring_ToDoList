package com.seclore.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showTodoListPage() {
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showAddTaskPage() {
		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView showEditTaskPage() {
		
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
