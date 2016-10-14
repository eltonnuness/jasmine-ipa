package com.jasmine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Service;

import com.jasmine.model.User;
import com.jasmine.model.UserTwitterData;
import com.jasmine.model.ValueObjectMapReduce;
import com.jasmine.repository.UserTwitterDataRepository;

/**
 * Classe responsavel por expor os serviços disponiveis com a entidade
 * UserTwitterDataRepository
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Service
public class TwitterService {

	@Autowired
	private UserTwitterDataRepository userTdr;

	@Autowired
	private MongoOperations mongoOperations;

	public List<UserTwitterData> saveHomeTimeline(List<UserTwitterData> userTwitterData) {
		return this.userTdr.save(userTwitterData);
	}

	public Iterable<ValueObjectMapReduce> countTweetWords(User user) {

		MapReduceResults<ValueObjectMapReduce> results = this.mongoOperations.mapReduce("usertwitterdata",
				"classpath:com/jasmine/utils/mongodb/scripts/word_count_map.js",
				"classpath:com/jasmine/utils/mongodb/scripts/word_count_reduce.js", ValueObjectMapReduce.class);

		return results;
	}

}
