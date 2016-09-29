package com.jasmine.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@EnableMongoRepositories(basePackages = {"com.jasmine.repository"})
@Configuration
public class MongoDbConfig extends AbstractMongoConfiguration{

	@Override
	protected String getDatabaseName(){
		return "jasmine-data";
	}
	
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost:27017");
	}
	
	@Override
	protected String getMappingBasePackage() {
		return "com.jasmine";
	}
	
}
