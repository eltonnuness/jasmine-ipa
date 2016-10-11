package com.jasmine.service.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jasmine.model.User;

/**
 * The Handler of collectors, this class handle all calls and execute tasks.
 * 
 * @author enunes
 * @version 1.0
 * @since 11/10/2016
 *
 */
@Component
public class CollectorServiceHandler {

	@Autowired
	private List<Collector> collectors;

	public void startAllCollectors(User user) {
		this.collectors.forEach(c -> c.startCollectService(user));
	}

	public void stopAllCollectors(User user) {
		this.collectors.forEach(c -> c.stopCollectService(user));
	}

	public void startCollector(User user, Collector collector) {
		this.collectors.stream().filter(c -> c.equals(collector)).forEach(c -> c.startCollectService(user));
	}

	public void startCollectors(User user, List<Collector> collectors) {
		this.collectors.stream().filter(c -> c.equals(collectors)).forEach(c -> c.startCollectService(user));
	}

	public void stopCollector(User user, Collector collector) {
		this.collectors.stream().filter(c -> c.equals(collector)).forEach(c -> c.stopCollectService(user));
	}

	public void stopCollectors(User user, List<Collector> collectors) {
		this.collectors.stream().filter(c -> c.equals(collectors)).forEach(c -> c.stopCollectService(user));
	}

	public String[] collectorsRunning(User user) {
		List<String> classNames = new ArrayList<>();
		this.collectors.stream().filter(c -> c.running == true).collect(Collectors.toList())
				.forEach(c -> classNames.add(c.getClass().getName()));
		return classNames.toArray(new String[classNames.size()]);
	}

	public boolean collectorStatus(User user, Collector collector) {
		return false;
	}
}
