package com.seclore.todolist.repository;

import com.seclore.todolist.domain.UserDetails;

public interface UserDetailsRepositoryInterface {
	boolean addNewUser(UserDetails userDetails);
	UserDetails getUserByEmail(String email);
	
}
