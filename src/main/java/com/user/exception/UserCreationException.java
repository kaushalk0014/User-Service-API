package com.user.exception;


public class UserCreationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3848001842683275859L;

	public UserCreationException() {
		super();
	}

	public UserCreationException(String erorMessage) {
		super(erorMessage);
	}

	public UserCreationException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

	public UserCreationException(Throwable cause) {
		super(cause);
	}
}

