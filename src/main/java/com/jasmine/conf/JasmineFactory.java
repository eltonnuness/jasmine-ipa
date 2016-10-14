package com.jasmine.conf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jasmine.controller.HomeController;
import com.jasmine.controller.LoginController;
import com.jasmine.service.collector.Collector;

/**
 * Classe responsavel por realizar a configuração dos beans da aplicação
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Configuration
@ComponentScan(basePackages = "com.jasmine")
public class JasmineFactory {

	@Autowired
	private Collector twitterCollector;
	@Autowired
	private Collector weatherCollector;

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

	@Bean
	public List<Collector> collectors() {
		List<Collector> collectors = new ArrayList<>();
		Collections.addAll(collectors, this.twitterCollector, this.weatherCollector);
		return collectors;
	}
}
