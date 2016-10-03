package com.jasmine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jasmine.model.UserTwitterData;

@Repository
public interface UserTwitterDataRepository extends MongoRepository<UserTwitterData, String> {

}
