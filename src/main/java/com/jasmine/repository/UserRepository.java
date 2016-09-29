package com.jasmine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jasmine.model.User;



@Repository
public interface UserRepository extends MongoRepository<User, String>{

	public User findByLoginAndPassword(String login, String password);
	
}
