package com.jasmine.core;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.model.User;

/**
 * Implementação do neuronio criado para processamento das informações que serão
 * exibidas para o usuário
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Component
public class WeatherNeuron implements JasmineNeuron {

	@Autowired
	private JasmineMemory jasmineMemory;

	@Override
	public void process(User user) {
		Timer timer = new Timer();

		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				processTodayTemperature();
			}
		};
		timer.schedule(timerTask, 2000, 240000); //240000 = 4 minutes.
	}

	private void processTodayTemperature() {
		// Implement
	}

}
