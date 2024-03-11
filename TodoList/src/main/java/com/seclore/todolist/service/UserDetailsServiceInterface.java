package com.seclore.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.seclore.todolist.domain.UserDetails;

public interface UserDetailsServiceInterface {

	UserDetails login(String email,String password);
	boolean signup(UserDetails userDetails);
}
