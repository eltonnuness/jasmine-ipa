package com.jasmine.service.collector;

import com.jasmine.model.User;

public abstract class Collector {
	protected boolean running;

	protected abstract void startCollectService(User user);

	protected abstract void stopCollectService(User user);
}
