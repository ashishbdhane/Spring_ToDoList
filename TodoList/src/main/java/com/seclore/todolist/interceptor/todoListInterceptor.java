package com.seclore.todolist.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.seclore.todolist.domain.UserDetails;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class todoListInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();

		if(uri.equals("/") || uri.equals("login") || uri.equals("/userlogin") || uri.contains("login")) {
			return true;
		}
		if (session.getAttribute("loggedInUser") != null) {
			return true;
		}
		response.sendRedirect("/login");
		return false;

	}
}
