package com.simulator.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import com.simulator.utils.WSConstants.WSExceptionConstant;
import com.simulator.rest.ErrorResponse;
import com.simulator.rest.WSErrorResponse;

public class WSException extends Exception {

	private final MessageSource messageSource;

	private static final long serialVersionUID = -8999932578270387947L;
	private static final int STATUS = 200;
	private final WSExceptionConstant code;
	private final String developerMessage;

	public WSException(WSExceptionConstant code, String developerMessage, MessageSource messageSource) {
		super();
		this.code = code;
		this.developerMessage = developerMessage;
		this.messageSource = messageSource;
	}

	public WSErrorResponse errorMessage() {
		String message = "";
		try {
			message = messageSource.getMessage(code.name(), null, Locale.US);
		} catch (NoSuchMessageException ignore) {
			message = "";
			Logger.getLogger("context").log(Level.ALL, "hello", ignore);
		}
		WSErrorResponse response = new WSErrorResponse();
		List<ErrorResponse> errors = new ArrayList<ErrorResponse>();
		ErrorResponse errorMessage = new ErrorResponse(code.getValue(), message, "", developerMessage);
		errors.add(errorMessage);
		response.setError(errors);
		return response;
	}

	public int getStatus() {
		return STATUS;
	}

	public WSExceptionConstant getCode() {
		return code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

}
