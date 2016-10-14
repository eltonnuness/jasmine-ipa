package com.jasmine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jasmine.model.UserTwitterData;

/**
 * Repositório criado para armazenar as operações que serão feitas no mongoDB
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Repository
public interface UserTwitterDataRepository extends MongoRepository<UserTwitterData, String> {

}
