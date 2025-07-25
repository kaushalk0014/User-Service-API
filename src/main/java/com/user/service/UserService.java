package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.user.dao.UserCredentialsRepositry;
import com.user.dao.UserRepositry;
import com.user.dto.UserDetailsDTO;
import com.user.entiry.AuthRequest;

@Service
public class UserService {

	@Autowired
	private UserRepositry userRepositry;
	
	@Autowired
	private UserCredentialsRepositry credentialsRepositry;
	
	public void registerUser(UserDetailsDTO user) {
		saveUserCredentials(null);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void saveUserCredentials(AuthRequest authRequest) {
		credentialsRepositry.save(authRequest);
	}

	public UserDetailsDTO getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetailsDTO getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDetailsDTO> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
