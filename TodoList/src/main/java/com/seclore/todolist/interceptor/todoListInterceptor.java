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
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		UserDetails user = (UserDetails) session.getAttribute("loggedInUser");
		if (uri.equals("/") || uri.equals("/login") || uri.equals("/userlogin")) {
			return true;
		}
		else if (user == null) {
			response.sendRedirect("/login");
			return false;
		}
		else {
			return true;
		}

	}
}
