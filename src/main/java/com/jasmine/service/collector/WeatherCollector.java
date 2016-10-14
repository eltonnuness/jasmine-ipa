package com.jasmine.service.collector;

import org.springframework.stereotype.Component;

import com.jasmine.model.User;

/**
 * Classe extendida da Collector que possui as operações necessarias para o
 * coletor de dados da api de clima/tempo
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
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
