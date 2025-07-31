package com.user.mapper;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.user.dto.RolesDTO;
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

	public static UserDetailsDTO toDTO(UserDetails userDetails) {
		
		UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
		
		userDetailsDTO.setGender(userDetails.getGender());
		userDetailsDTO.setIsActice(userDetails.getIsActice());
		userDetailsDTO.setMobileNo(userDetails.getMobileNo());
		userDetailsDTO.setCreatedDate(userDetails.getCreatedDate());
		userDetailsDTO.setUpdatedDate(userDetails.getUpdatedDate());
		userDetailsDTO.setUserId(userDetails.getUserId());
		userDetailsDTO.setUsername(userDetails.getUsername());
		 
		userDetailsDTO.setRoles(userDetails.getRoles().stream().map(role->{
			 RolesDTO roles = new RolesDTO();
			 
			 roles.setRoleName(role.getRoleName());
			 //roles.setUser(userDetailsDTO);
			 
			 return roles;
		 }).collect(Collectors.toList()));
		 
		 return userDetailsDTO;
	}

	public static List<UserDetailsDTO> toDTO(List<UserDetails> list) {
		return list.stream().map(UserMapper::toDTO).collect(Collectors.toList());
	}
}
