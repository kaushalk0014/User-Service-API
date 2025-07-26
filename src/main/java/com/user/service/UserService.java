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
import com.user.entiry.UserDetails;
import com.user.exception.UserCreationException;
import com.user.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserRepositry userRepositry;
	
	@Autowired
	private UserCredentialsRepositry credentialsRepositry;
	
	public void registerUser(UserDetailsDTO user) {
		
		if(userRepositry.isPresentUserByUsername(user.getUsername()).isPresent()) {
			throw new UserCreationException("Usrename : "+user.getUsername()+ " already exist, Try with other username");
		}
		
		UserDetails userDetails= UserMapper.toEntity(user);
		userRepositry.save(userDetails);
		
		saveUserCredentials(user);
	}
	
	private void saveUserCredentials(UserDetailsDTO user) {
		
		AuthRequest authRequest= new AuthRequest();
		authRequest.setUsername(user.getUsername());
		authRequest.setPassword(user.getPassword());
		
		
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
