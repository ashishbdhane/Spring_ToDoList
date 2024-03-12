package com.seclore.todolist.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
public class TaskController{

	// Task Details Service object
	@Autowired
	private TaskDetailsServiceInterface taskService;
	
	// Returns the todolist page with List of allTodos
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showTodoListPage(HttpSession session) {
		// Set the modelAndView view and object
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/alltasks");
		// Get the user object through session
		UserDetails userDetails = (UserDetails) session.getAttribute("loggedInUser");
		List<TaskDetails> allTasks = taskService.getAllTaskOfUser(userDetails);
		modelAndView.addObject("allTasks", allTasks);
		
		return modelAndView;
	}

	// Returns the add task page with an empty object 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showAddTaskPage() {
		// Set the modelAndView view and object
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/addtask");
		TaskDetails taskDetails = new TaskDetails();
		
		// Setting Status array for options
		String[] allStatus = {"PENDING","INPROGRESS","COMPLETED"};
		modelAndView.addObject("allStatus",allStatus);
		modelAndView.addObject("taskDetails", taskDetails);

		return modelAndView;
	}

	// Returns the edit task page with prepopulated object
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView showEditTaskPage(@RequestParam int taskId) {
		ModelAndView modelAndView = new ModelAndView();
		// Get the given taskId object	
		TaskDetails taskDetails = taskService.getTaskByTaskId(taskId);
		// Setting Status array for options
		String[] allStatus = { "PENDING", "INPROGRESS", "COMPLETED" };
		
		// Set the modelAndView view and object
		modelAndView.addObject("allStatus", allStatus);
		modelAndView.addObject("taskDetails", taskDetails);
		modelAndView.setViewName("/updatetask");
			
		return modelAndView;
	}

	// Add the new task to DB and redirect to allTodos
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addTask(@ModelAttribute TaskDetails taskDetails,HttpServletResponse response,HttpSession session) throws IOException {
		// Get user details from session
		UserDetails userDetails = (UserDetails) session.getAttribute("loggedInUser");
		// Set user in task object
		taskDetails.setUserDetails(userDetails);
		// Call the service to add task in DB
		boolean success = taskService.addTask(taskDetails);
		// If successful added a message in session and redirected to all Tasks
		if(success) {
			session.setAttribute("message", "Task Added");
			response.sendRedirect("/tasks");
			return;
		}
		// Redirect to error page if not successful
		response.sendRedirect("/error");
	}

	// Edit the given task in DB
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void updateTask(@ModelAttribute TaskDetails taskDetails,HttpServletResponse response,HttpSession session) throws IOException {		
		// Call service to edit task in DB
		boolean success = taskService.updateTask(taskDetails);
		// If successful add a message in session and then redirected to all Tasks
		if(success) {
			session.setAttribute("message", "Task Edited");
			response.sendRedirect("/tasks");
			return;
		}
		// Redirect to error page if not successful
		response.sendRedirect("/error");
	}

	// Delete the given task in DB
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteTask(@RequestParam("taskId") int taskId, HttpServletResponse response,HttpSession session) throws IOException {
		// Call the service delete method using the taskDetails object to delete the task
		TaskDetails taskDetails = new TaskDetails(taskId, new UserDetails(), "", "", "");
		boolean success = taskService.deleteTask(taskDetails);
		//  If successful added a message in session and then redirected to all Tasks
		if(success) {
			session.setAttribute("message", "Task Deleted");
			response.sendRedirect("/tasks");
			return;
		}
		// Redirect to error page if not successful
		response.sendRedirect("/error");
	}

}
