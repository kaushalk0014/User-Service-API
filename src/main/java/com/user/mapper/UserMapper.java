package com.user.mapper;

import java.util.Date;
import java.util.stream.Collectors;

import com.user.dto.UserDetailsDTO;
import com.user.entiry.Roles;
import com.user.entiry.UserDetails;

public class UserMapper {

	 public static UserDetails toEntity(UserDetailsDTO dto) {
		 UserDetails details = new UserDetails();
		 
		 details.setGender(dto.getGender());
		 details.setIsActice(dto.getIsActice());
		 details.setMobileNo(dto.getMobileNo());
		 details.setCreatedDate(new Date());
		 details.setUpdatedDate(new Date());
		 details.setUserId(null);
		 details.setUsername(dto.getUsername());
		 
		 details.setRoles(dto.getRoles().stream().map(role->{
			 Roles roles = new Roles();
			 
			 roles.setRoleName(role.getRoleName());
			 roles.setUser(details);
			 
			 return roles;
		 }).collect(Collectors.toList()));
		 
		 return details;
	 }
}
