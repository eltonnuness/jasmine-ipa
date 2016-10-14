package com.jasmine.core;

/**
 * Implementação do neuronio criado para processamento das informações que serão
 * exibidas para o usuário
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
public class WeatherNeuron implements JasmineNeuron {

	@Override
	public String process() {
		processTodayTemperature();
		return null;
	}

	private void processTodayTemperature() {
		// Implement
	}

}
