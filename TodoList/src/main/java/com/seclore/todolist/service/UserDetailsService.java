package com.seclore.todolist.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.seclore.todolist.domain.UserDetails;
import com.seclore.todolist.repository.UserDetailsRepositoryInterface;

@Service
public class UserDetailsService implements UserDetailsServiceInterface {
	@Autowired
	private UserDetailsRepositoryInterface userDetailsRepository;
	
	//Get user object by email and compare with hashed password. 
	//Returns user object is valid else returns null
	@Override
	public UserDetails login(String email, String password) {
		UserDetails userDetails =  userDetailsRepository.getUserByEmail(email);
		if(userDetails==null)
			return null;
		String hashedPassword = getMd5(password);
		boolean passwordIsValid = (userDetails.getPassword().equals(hashedPassword));
		
		if(passwordIsValid)
			return userDetails;
		else return null;
	}

	//Call insert query and insert user object with hashed password
	@Override
	public boolean signup(UserDetails userDetails) {
		userDetails.setPassword(getMd5(userDetails.getPassword()));
		return userDetailsRepository.addNewUser(userDetails);
	}
	
	
	//Handles hashing of password
	private String getMd5(String password) {
        try {
			MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
		} catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
		}
	}
	
}
