package com.simulator.exception.handler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.simulator.exception.ValidationException;
import com.simulator.exception.WSException;
import com.simulator.rest.ErrorResponse;
import com.simulator.rest.WSErrorResponse;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {

		if (ex.getCause() != null && ex.getCause() instanceof ValidationException) {
			ValidationException exception = (ValidationException) ex.getCause();
			return Response.status(200).entity(exception.errorMessage()).type(
					MediaType.APPLICATION_JSON).build();
		}
		if (ex.getCause() != null && ex.getCause() instanceof WSException) {
			WSException exception = (WSException) ex.getCause();
			return Response.status(200).entity(exception.errorMessage()).type(
					MediaType.APPLICATION_JSON).build();
		}
		StringWriter errorStackTrace = new StringWriter();
		ex.printStackTrace(new PrintWriter(errorStackTrace));
		ErrorResponse errorMessage = new ErrorResponse(5001, "", ex.getMessage(), errorStackTrace.toString());

		WSErrorResponse response = new WSErrorResponse();
		List<ErrorResponse> errors = new ArrayList<ErrorResponse>();
		errors.add(errorMessage);
		response.setError(errors);

		return Response.status(getHttpStatus(ex)).entity(response).type(MediaType.APPLICATION_JSON).build();
	}

	private int getHttpStatus(Throwable ex) {
		if (ex instanceof WebApplicationException) {
			// NICE way to combine both of methods, say it in the blog
			return ((WebApplicationException) ex).getResponse().getStatus();
		} else {
			// defaults to internal server error 500
			return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
	}

}
