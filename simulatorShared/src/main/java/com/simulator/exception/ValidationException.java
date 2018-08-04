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

public class ValidationException extends Exception {

	private final MessageSource messageSource;

	private static final long serialVersionUID = -8999932578270387947L;
	private static final int STATUS = 200;
	private final List<WSExceptionConstant> codes;
	private final String developerMessage;

	public ValidationException(List<WSExceptionConstant> codes, String developerMessage, MessageSource messageSource) {
		super();
		this.codes = codes;
		this.developerMessage = developerMessage;
		this.messageSource = messageSource;
	}

	public WSErrorResponse errorMessage() {
		List<ErrorResponse> list = new ArrayList<ErrorResponse>();
		for (WSExceptionConstant code : codes) {

			String message;
			try {
				message = messageSource.getMessage(code.name(), null, Locale.US);
			} catch (NoSuchMessageException ignore) {
				Logger.getLogger("context").log(Level.ALL, "hello", ignore);
				message = "";
			}
			list.add(new ErrorResponse(code.getValue(), message, "", developerMessage));
		}
		WSErrorResponse response = new WSErrorResponse();
		response.setError(list);

		return response;
	}

	public int getStatus() {
		return STATUS;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

}
