package com.jasmine.integrations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.exceptions.TwitterConnectivityException;
import com.jasmine.model.User;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Classe responsavel por intermediar os acessos a api do twitter para a
 * aplicação.
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Component
public class TwitterInfo {

	@Autowired
	private TwitterConnector twitterConnector;

	public List<Status> readTimeline(User user) throws TwitterConnectivityException {

		List<Status> list;

		try {
			Twitter twitter = this.twitterConnector.access(user);
			list = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			throw new TwitterConnectivityException(e);
		}

		return list;
	}

}
