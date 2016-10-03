package com.jasmine.service.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jasmine.exceptions.DataSourceException;
import com.jasmine.model.User;
import com.jasmine.model.UserTwitterData;
import com.jasmine.service.TwitterService;

import twitter4j.Status;

@Component
public class InfoCollector {

	@Autowired
	private TwitterService twitterService;
	@Autowired
	@Qualifier("twitterinfo")
	private DataSource<Status> dataSource;

	public void startTwitterCollectService(User user) {
		this.dataSource = new TwitterInfo();

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					List<UserTwitterData> listUtd = new ArrayList<>();
					InfoCollector.this.dataSource.readTimeline(user)
							.forEach(s -> listUtd.add(new UserTwitterData(user, s)));
					InfoCollector.this.twitterService.saveHomeTimeline(listUtd);
				} catch (DataSourceException e) {
					e.printStackTrace();
				}
			}
		};

		Timer timerTwitter = new Timer();
		timerTwitter.schedule(task, 2000, 60000);

	}

}
