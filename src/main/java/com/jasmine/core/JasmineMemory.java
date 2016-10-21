package com.jasmine.core;

import java.util.Queue;

import org.springframework.stereotype.Component;

@Component
public class JasmineMemory {

	private Queue<String> queue;

	public synchronized void add(String memory) {
		this.queue.add(memory);
	}

}
