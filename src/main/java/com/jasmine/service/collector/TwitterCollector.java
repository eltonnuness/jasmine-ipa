package com.jasmine.service.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.exceptions.TwitterConnectivityException;
import com.jasmine.integrations.TwitterInfo;
import com.jasmine.model.User;
import com.jasmine.model.UserTwitterData;
import com.jasmine.service.TwitterService;

@Component
public class TwitterCollector extends Collector {

	@Autowired
	private TwitterInfo twitterInfo;
	@Autowired
	private TwitterService twitterService;
	private Timer timerTwitter = new Timer();

	@Override
	protected void startCollectService(User user) {
		this.running = true;

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					List<UserTwitterData> listUtd = new ArrayList<>();
					TwitterCollector.this.twitterInfo.readTimeline(user)
							.forEach(s -> listUtd.add(new UserTwitterData(user, s)));
					TwitterCollector.this.twitterService.saveHomeTimeline(listUtd);
				} catch (TwitterConnectivityException e) {
					e.printStackTrace();
				}
			}
		};
		this.timerTwitter.schedule(task, 2000, 90000);
	}

	@Override
	protected void stopCollectService(User user) {
		this.running = false;
		this.timerTwitter.cancel();
	}

}
