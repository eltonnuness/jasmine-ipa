package com.jasmine.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang3.StringUtils;
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

		Timer timer = new Timer();

		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				processCountWords(user);
			}
		};

		timer.schedule(timerTask, 2000, 240000); //240000 = 4 minutes.
	}

	private void processCountWords(User user) {
		String[] firstWords = { "Estão todos falando sobre: ", "Que curioso, parece que essas palavras estão em alta: ",
				"Já viu sobre o que estão falando no twitter?: ",
				"Essas palavras estão sendo muito faladas no twitter: " };
		String[] twitterWords = new String[3];

		List<ValueObjectMapReduce> countWords = new ArrayList<>(twitterService.countTweetWords(user));
		Random randomNum = new Random();
		StringBuffer stb = new StringBuffer();
		stb.append(firstWords[randomNum.nextInt(firstWords.length - 1)]);
		for (int i = 0; i <= 2; i++) {
			twitterWords[i] = countWords.get(i).getId();
		}
		stb.append(StringUtils.join(twitterWords, ","));
		stb.append(".");

		jasmineMemory.add(stb.toString());
	}

}
