package com.seclore.todolist.interceptor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.servlet.HandlerInterceptor;

import com.seclore.todolist.domain.UserDetails;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class todoListInterceptor implements HandlerInterceptor {

	//Interceptor 
	//Intercept every request. Logged out user gets redirected to login page
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		
		if(uri.equals("/") || uri.equals("login") || uri.equals("/userlogin") || uri.contains("login") || uri.contains("signup") || uri.contains("js") || uri.contains(".css") || uri.contains(".png")) {
			
			return true;
		}
		if (session.getAttribute("loggedInUser") != null ) {
				return true;
		}
		response.sendRedirect("/login");
		return false;
	}
}
