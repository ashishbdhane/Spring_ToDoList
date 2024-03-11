package com.seclore.todolist.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seclore.todolist.domain.UserDetails;

import com.seclore.todolist.service.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserDetailsServiceInterface userDetailsService;

	@RequestMapping("/")
	public String showDefaultPage() {
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		UserDetails userDetails = new UserDetails();
		modelAndView.setViewName("login");

		modelAndView.addObject("userDetails",userDetails);
		modelAndView.addObject("userDetails",userDetails);

		return modelAndView;

	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showSignupPage() {
		ModelAndView modelAndView = new ModelAndView();
		UserDetails userDetails = new UserDetails();
		modelAndView.setViewName("signup");
		modelAndView.addObject("userDetails",userDetails);		
		return modelAndView;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute UserDetails userDetails, HttpSession session) {
		if (userDetailsService.signup(userDetails))
			session.setAttribute("message", "Successfully added user");
		else
			session.setAttribute("message", "failed to add new User");
		return "redirect:/login";

	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute UserDetails userDetails, HttpSession session) {
		UserDetails loggedUser = userDetailsService.login(userDetails.getEmail(), userDetails.getPassword());
		String message, nextPage;
		
		if (loggedUser == null) {
			message = " INVALID USER_ID OR PASSWORD ";
			session.setAttribute("message", message);
			nextPage = "login";
		} else {
			session.setAttribute("loggedInUser", loggedUser);
			nextPage = "redirect:/tasks/";
		}
		return nextPage;
	}

	@RequestMapping("logout")
	public void logOut(HttpSession session, HttpServletResponse response) {
		try {
			session.invalidate();
			response.sendRedirect("login");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
