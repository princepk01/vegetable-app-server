package com.app.vegetable.exception;

public class CommonException extends Exception {

	private static final long serialVersionUID = 1163126945525771305L;

	private String message;

	public CommonException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CommonException [message=" + message + "]";
	}
	
	

}
