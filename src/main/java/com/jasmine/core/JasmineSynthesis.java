package com.jasmine.core;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.model.User;

/**
 * Classe responsavel por processar as informações gerais de comunicação com o
 * usuário
 * 
 * @author Elton
 *
 */
@Component
public class JasmineSynthesis implements JasmineNeuron {

	@Autowired
	private JasmineMemory jasmineMemory;

	@Override
	public void process(User user) {
		processWelcomeMessages(user);
	}

	private void processWelcomeMessages(User user) {
		String[] frases = { "Bom dia + " + user.getLogin() + ", como vai?", "Olá, tudo bem?",
				"Bem-vindo, sou sua assistente Jasmine, veremos como está o dia hoje", "Bom dia" };

		jasmineMemory.add(frases[RandomUtils.nextInt(0, 4)]);

	}

}
