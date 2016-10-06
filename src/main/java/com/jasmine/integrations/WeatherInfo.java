package com.jasmine.integrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.model.User;

@Component
public class WeatherInfo {

	@Autowired
	private WeatherConnector weatherConnector;

	public void readCityTemperature(User user) {
		//Change return to Temperature(class)
	}

}
