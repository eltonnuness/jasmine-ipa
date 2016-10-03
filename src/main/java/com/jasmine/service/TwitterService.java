package com.jasmine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasmine.model.UserTwitterData;
import com.jasmine.repository.UserTwitterDataRepository;

@Service
public class TwitterService {

	@Autowired
	private UserTwitterDataRepository userTdr;

	public List<UserTwitterData> saveHomeTimeline(List<UserTwitterData> userTwitterData) {
		return userTdr.save(userTwitterData);
	}

}
