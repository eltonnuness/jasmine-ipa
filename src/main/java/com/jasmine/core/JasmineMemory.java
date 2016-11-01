package com.jasmine.core;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JasmineMemory {

	private Queue<String> queue = new PriorityQueue<>();

	@Autowired
	private JasmineMindsHandler jasmineMindsHandler;

	@PostConstruct
	public void postConstruct() {
		Timer timer = new Timer();

		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				String message = JasmineMemory.this.queue.poll();
				if (message != null) {
					JasmineMemory.this.jasmineMindsHandler.appendTextBreakLine(JasmineMemory.this.queue.poll());
				}
			}
		};
		timer.schedule(timerTask, 2000, RandomUtils.nextInt(3000, 10000));
	}

	public synchronized void add(String memory) {
		this.queue.add(memory);
	}

}
