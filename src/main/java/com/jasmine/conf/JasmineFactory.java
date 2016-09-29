package com.jasmine.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jasmine.controller.HomeController;
import com.jasmine.controller.LoginController;
import com.jasmine.integrations.TwitterConnector;
import com.jasmine.model.User;

@ComponentScan(basePackages = "com.jasmine")
@Configuration
public class JasmineFactory {

	@Bean
	public User user() {
		User u = new User();
		return u;
	}

	@Bean
	public LoginController loginController() {
		LoginController lc = new LoginController();
		return lc;
	}

	@Bean
	public HomeController homeController() {
		HomeController hc = new HomeController();
		return hc;
	}

	@Bean(name = "twitterConnector")
	public TwitterConnector twitterConnector() {
		return new TwitterConnector();
	}

}
