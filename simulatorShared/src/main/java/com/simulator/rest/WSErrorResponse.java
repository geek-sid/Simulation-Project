package com.simulator.rest;

import java.util.List;

import com.simulator.utils.WSConstants;

public class WSErrorResponse {

	protected int status = WSConstants.RESPONSE_ERROR;
	List<ErrorResponse> error;

	public WSErrorResponse() {
		super();
	}

	public WSErrorResponse(int status, List<ErrorResponse> error) {
		super();
		this.status = status;
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<ErrorResponse> getError() {
		return error;
	}

	public void setError(List<ErrorResponse> error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "WSErrorResponse [status=" + status + ", error=" + error + "]";
	}

}
