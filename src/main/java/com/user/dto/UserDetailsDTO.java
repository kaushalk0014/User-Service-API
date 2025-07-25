package com.user.dto;

import java.util.Date;
import java.util.List;

public class UserDetailsDTO {

	private Integer userId;
	private String username;
	private String gender;
	private String password;
	private String mobileNo;
	private String isActice;
	private Date createdDate;
	private Date updatedDate;
	private List<RolesDTO> roles;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getIsActice() {
		return isActice;
	}

	public void setIsActice(String isActice) {
		this.isActice = isActice;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<RolesDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RolesDTO> roles) {
		this.roles = roles;
	}
	
	

}
