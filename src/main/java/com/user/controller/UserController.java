package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserDetailsDTO;
import com.user.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDetailsDTO user){
		userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.OK)
				.body("Registetion done successfully");
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDetailsDTO> getUserById(@PathVariable(name = "id") String id) {
		UserDetailsDTO user = userService.getUserById(id);
		return new ResponseEntity<UserDetailsDTO>(user, HttpStatus.OK);
	}

	@GetMapping("/{name}")
	public ResponseEntity<UserDetailsDTO> getUserByName(@RequestParam(name="name") String name) {
		UserDetailsDTO user = userService.getUserByName(name);
		return new ResponseEntity<UserDetailsDTO>(user, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDetailsDTO>> getAllUser(){
		List<UserDetailsDTO> list = userService.getAllUser();
		return new ResponseEntity<List<UserDetailsDTO>>(list, HttpStatus.OK);
	}
}
