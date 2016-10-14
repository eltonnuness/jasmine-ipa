package com.jasmine.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Classe responsavel por realizar a configuração do mongo db
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 *
 */
@EnableMongoRepositories(basePackages = { "com.jasmine.repository" })
@Configuration
@EnableTransactionManagement
public class MongoDbConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
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
