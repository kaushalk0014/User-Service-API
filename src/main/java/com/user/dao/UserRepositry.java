package com.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entiry.UserDetails;

public interface UserRepositry extends JpaRepository<UserDetails, Integer>{

}
