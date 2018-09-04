package com.github.ssuite.slib.exception;

public class NoSuchPlayerException extends Exception {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -7952757990320707988L;
	
	private String formattedMessage;
	
	public NoSuchPlayerException(String message) {
		this(message, message);
	}
	
	public NoSuchPlayerException(String message, String formattedMessage) {
		super(message);
		this.formattedMessage = formattedMessage;
	}
	
	public String getFormattedMessage() {
		return formattedMessage;
	}
	
}
