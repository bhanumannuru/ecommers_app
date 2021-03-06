package com.javaexpress.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaexpress.entities.User;

@Repository
public interface UserRepo extends CrudRepository <User, Long> {
	
	User findByEmail(String emailId);
}