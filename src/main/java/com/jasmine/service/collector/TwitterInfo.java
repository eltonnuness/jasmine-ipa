package com.jasmine.service.collector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.exceptions.DataSourceException;
import com.jasmine.integrations.TwitterConnector;
import com.jasmine.model.User;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Component("twitterinfo")
public class TwitterInfo implements DataSource<Status> {

	@Autowired
	private TwitterConnector twitterConnector;

	@Override
	public List<Status> readTimeline(User user) throws DataSourceException {

		List<Status> list;

		try {
			Twitter twitter = this.twitterConnector.access(user);
			list = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			throw new DataSourceException(e);
		}

		return list;
	}

}
