package com.seclore.todolist.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.seclore.todolist.domain.TaskDetails;
import com.seclore.todolist.domain.UserDetails;
import com.seclore.todolist.service.TaskDetailsServiceInterface;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskDetailsServiceInterface taskService;

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showTodoListPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/alltasks");
//		UserDetails userDetails = (UserDetails) session.getAttribute("loggedInUser");
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		List<TaskDetails> allTasks = taskService.getAllTaskOfUser(userDetails);
		modelAndView.addObject("allTasks", allTasks);

		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showAddTaskPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/addtask");
		TaskDetails taskDetails = new TaskDetails();
		
		String[] allStatus = {"PENDING","INPROGRESS","COMPLETED"};
		modelAndView.addObject("allStatus",allStatus);
		modelAndView.addObject("taskDetails", taskDetails);

		return modelAndView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView showEditTaskPage(@RequestParam int taskId) {
		System.out.println("edit");
		ModelAndView modelAndView = new ModelAndView();
		
		TaskDetails taskDetails = taskService.getTaskByTaskId(taskId);
		String[] allStatus = { "PENDING", "IN PROGRESS", "COMPLETED" };
		modelAndView.addObject("allStatus", allStatus);
		
		modelAndView.addObject("taskDetails", taskDetails);
		modelAndView.setViewName("/updatetask");
			
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addTask(@ModelAttribute TaskDetails taskDetails,HttpServletResponse response) throws IOException {
		taskDetails.setUserDetails( new UserDetails(1, null, null, null, null));
		boolean success = taskService.addTask(taskDetails);
		if(success) {
			response.sendRedirect("/tasks");
			return;
		}
		response.sendRedirect("/error");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void updateTask(@ModelAttribute TaskDetails taskDetails,HttpServletResponse response) throws IOException {		
		boolean success = taskService.updateTask(taskDetails);
		if(success) {
			response.sendRedirect("/tasks");
			return;
		}
		response.sendRedirect("/error");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteTask(@RequestParam("taskId") int taskId, HttpServletResponse response) throws IOException {
		TaskDetails taskDetails = new TaskDetails(taskId, new UserDetails(), "", "", "");
		boolean success = taskService.deleteTask(taskDetails);
		if(success) {
			response.sendRedirect("/tasks");
			return;
		}
		response.sendRedirect("/error");
	}
}
