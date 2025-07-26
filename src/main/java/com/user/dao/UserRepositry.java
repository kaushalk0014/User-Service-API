package com.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.user.entiry.UserDetails;

public interface UserRepositry extends JpaRepository<UserDetails, String>{

	@Query("select (count(username)>0) from UserDetails where username = :username")
	Optional<Boolean> isPresentUserByUsername(@Param("username") String username);

}
