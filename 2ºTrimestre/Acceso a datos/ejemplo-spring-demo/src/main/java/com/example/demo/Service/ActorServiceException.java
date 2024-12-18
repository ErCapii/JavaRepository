package com.example.demo.Service;

public class ActorServiceException extends Exception {

	public ActorServiceException() {
	}

	public ActorServiceException(String message) {
		super(message);
	}

	public ActorServiceException(Throwable cause) {
		super(cause);
	}

	public ActorServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActorServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
