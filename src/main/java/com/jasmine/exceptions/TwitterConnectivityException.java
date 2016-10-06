package com.jasmine.exceptions;

public class TwitterConnectivityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6842384730824942123L;

	public TwitterConnectivityException() {
		super();
	}

	public TwitterConnectivityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TwitterConnectivityException(String message, Throwable cause) {
		super(message, cause);
	}

	public TwitterConnectivityException(String message) {
		super(message);
	}

	public TwitterConnectivityException(Throwable cause) {
		super(cause);
	}

}
