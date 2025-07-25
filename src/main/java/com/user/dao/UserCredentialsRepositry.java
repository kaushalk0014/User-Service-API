package com.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entiry.AuthRequest;

@Repository
public interface UserCredentialsRepositry extends JpaRepository<AuthRequest, String>{

}
