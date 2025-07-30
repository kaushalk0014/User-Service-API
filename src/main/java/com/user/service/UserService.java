package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exception.app.exception.ResourceNotFoundException;
import com.exception.app.exception.UserCreationException;
import com.user.dao.UserCredentialsRepositry;
import com.user.dao.UserRepositry;
import com.user.dto.UserDetailsDTO;
import com.user.entiry.AuthRequest;
import com.user.entiry.UserDetails;
import com.user.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserRepositry userRepositry;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserCredentialsRepositry credentialsRepositry;
	
	public void registerUser(UserDetailsDTO user) {
		
		Optional<Boolean> existUser = userRepositry.isPresentUserByUsername(user.getUsername());
		
		
				
		if(existUser.isPresent() && existUser.get()==true) {
			throw new UserCreationException("Usrename : "+user.getUsername()+ " already exist, Try with other username");
		}
		
		UserDetails userDetails= UserMapper.toEntity(user);
		userRepositry.save(userDetails);
		
		String encodedPwd = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(encodedPwd);
		saveUserCredentials(user);
	}
	
	private void saveUserCredentials(UserDetailsDTO user) {
		
		AuthRequest authRequest= new AuthRequest();
		authRequest.setUsername(user.getUsername());
		authRequest.setPassword(user.getPassword());
		
		credentialsRepositry.save(authRequest);
	}

	public UserDetailsDTO getUserById(String id) {
		
		UserDetails userDetails = userRepositry.findById(id).orElseThrow(
				()->new ResourceNotFoundException("User not found with id : "+id));
		
		return UserMapper.toDTO(userDetails);
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
