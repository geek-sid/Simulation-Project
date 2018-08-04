package com.simulator.rest;


import com.simulator.utils.WSConstants;

/**
 * Superclass for all the REST Response classes.
 * 
 * Contains the common status methods for setting the the status of the REST call. A value of '0' designates success.
 */
public class WSResponse {

	protected int status = WSConstants.RESPONSE_OK; // default status is '0'
	protected String message;
	
	

	public WSResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WSResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public final int getStatus() {
		return status;
	}

	public final void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
