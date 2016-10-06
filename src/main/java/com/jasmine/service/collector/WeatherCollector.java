package com.jasmine.service.collector;

import org.springframework.stereotype.Component;

import com.jasmine.model.User;

@Component
public class WeatherCollector extends Collector {

	//Inject Service and Collector

	@Override
	protected void startCollectService(User user) {
		this.running = true;
	}

	@Override
	protected void stopCollectService(User user) {
		this.running = false;

	}

}
