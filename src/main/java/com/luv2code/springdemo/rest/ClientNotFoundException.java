package com.luv2code.springdemo.rest;

public class ClientNotFoundException extends RuntimeException {

	public ClientNotFoundException() {
	}

	public ClientNotFoundException(String message) {
		super(message);
	}

	public ClientNotFoundException(Throwable cause) {
		super(cause);
	}

	public ClientNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
