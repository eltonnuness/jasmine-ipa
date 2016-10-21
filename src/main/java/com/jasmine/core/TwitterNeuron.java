package com.jasmine.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.model.User;
import com.jasmine.model.ValueObjectMapReduce;
import com.jasmine.service.TwitterService;

/**
 * Implementação do neuronio criado para processamento das informações que serão
 * exibidas para o usuário
 * 
 * @author Élton Nunes - <elton_12_nunes@hotmail.com>
 * @since 14/10/2016
 */
@Component
public class TwitterNeuron implements JasmineNeuron {

	@Autowired
	private TwitterService twitterService;
	@Autowired
	private JasmineMemory jasmineMemory;

	@Override
	public void process(User user) {
		processCountWords(user);
	}

	private void processCountWords(User user) {
		String[] firstWords = { "Estão todos falando sobre: ", "Que curioso, parece que essas palavras estão em alta: ",
				"Já viu sobre o que estão falando no twitter?: ",
				"Essas palavras estão sendo muito faladas no twitter: " };
		String[] twitterWords = {};

		List<ValueObjectMapReduce> countWords = new ArrayList<>(this.twitterService.countTweetWords(user));
		Random randomNum = new Random();
		StringBuffer stb = new StringBuffer();
		stb.append(firstWords[randomNum.nextInt(firstWords.length - 1)]);
		for (int i = 0; i <= 2; i++) {
			twitterWords[i] = countWords.get(i).getId();
		}
		//stb.append(StringUtils.)
	}

}
