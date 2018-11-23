package com.ey.piit.core.scheduler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTask {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private boolean interrupt = false;

	public boolean isInterrupt() {
		return interrupt;
	}

	public void setInterrupt(boolean interrupt) {
		this.interrupt = interrupt;
	}

}