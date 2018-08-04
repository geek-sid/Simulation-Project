package com.simulator.exception.handler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.simulator.exception.WSException;

@Provider
public class WSExceptionMapper implements ExceptionMapper<WSException> {

	@Override
	public Response toResponse(WSException ex) {
		return Response.status(ex.getStatus()).entity(ex.errorMessage()).type(MediaType.APPLICATION_JSON).build();
	}

}
