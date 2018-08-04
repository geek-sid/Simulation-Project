package com.simulator.rest;

public class ErrorResponse {

	int code;
	String link;
	protected String message;
	String developerMessage;

	public ErrorResponse(int code, String link, String message, String developerMessage) {
		super();
		this.code = code;
		this.link = link;
		this.message = message;
		this.developerMessage = developerMessage;
	}

	public ErrorResponse() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}
