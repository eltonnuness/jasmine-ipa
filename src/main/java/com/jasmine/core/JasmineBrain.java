package com.jasmine.core;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jasmine.model.User;

/**
 * Classe principal do pacote, ele ira dar inicio a todas as tarefas que serão
 * executadas e processadas.
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Component
public class JasmineBrain {
	private boolean thinking;
	private boolean started;
	List<JasmineNeuron> neurons;

	public void start(User user) {
		//TODO Implement
	}
}
