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

import com.google.gson.JsonSyntaxException;
import com.simulator.utils.WSConstants.WSExceptionConstant;
import com.simulator.rest.ErrorResponse;
import com.simulator.rest.WSErrorResponse;
import com.simulator.util.SimErrorCodes;

@Provider
public class JsonSyntaxExceptionMapper implements ExceptionMapper<JsonSyntaxException> {

	@Override
	public Response toResponse(JsonSyntaxException ex) {

		StringWriter errorStackTrace = new StringWriter();
		ex.printStackTrace(new PrintWriter(errorStackTrace));
		ErrorResponse errorMessage = new ErrorResponse(WSExceptionConstant.INVALID_REQUEST.getValue(), "", SimErrorCodes.INVALID_REQUEST_PAYLOAD_STRUCTURE_MESSAGE, SimErrorCodes.INVALID_REQUEST_PAYLOAD_STRUCTURE_MESSAGE);

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
