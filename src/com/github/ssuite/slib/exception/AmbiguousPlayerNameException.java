package com.github.ssuite.slib.exception;

public class AmbiguousPlayerNameException extends Exception {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 5296364436157747989L;
	
	private String formattedMessage;
	
	public AmbiguousPlayerNameException(String message) {
		this(message, message);
	}
	
	public AmbiguousPlayerNameException(String message, String formattedMessage) {
		super(message);
		this.formattedMessage = formattedMessage;
	}
	
	public String getFormattedMessage() {
		return formattedMessage;
	}
	
}
