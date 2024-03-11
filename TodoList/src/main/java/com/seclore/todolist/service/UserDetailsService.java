package com.seclore.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.seclore.todolist.domain.UserDetails;
import com.seclore.todolist.repository.UserDetailsRepositoryInterface;

@Service
public class UserDetailsService implements UserDetailsServiceInterface {
	@Autowired
	private UserDetailsRepositoryInterface userDetailsRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails login(String email, String password) {
		UserDetails userDetails =  userDetailsRepository.getUserByEmail(email);
		String bCryptedPassword = bCryptPasswordEncoder.encode(password);
		boolean passwordIsValid = bCryptPasswordEncoder.matches(userDetails.getPassword(), bCryptedPassword);
		
		if(passwordIsValid)
			return userDetails;
		else return null;
	}

	@Override
	public boolean signup(UserDetails userDetails) {
		userDetails.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		return userDetailsRepository.addNewUser(userDetails);
	}
	
	
}
