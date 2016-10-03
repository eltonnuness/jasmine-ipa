package com.jasmine.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jasmine.controller.HomeController;
import com.jasmine.controller.LoginController;

@Configuration
@ComponentScan(basePackages = "com.jasmine")
public class JasmineFactory {

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
}
