package com.simulator.providers;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;

import com.simulator.util.SimulatorConstants;

@Provider
@PreMatching
public class ContentTypeFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext request) throws WebApplicationException {
		String method = request.getMethod();
		MediaType mediaType = request.getMediaType();
		System.out.println(method);
		System.out.println(mediaType.toString());
		  
		if ((SimulatorConstants.METHOD_POST.equalsIgnoreCase(method) || SimulatorConstants.METHOD_PUT.equalsIgnoreCase(
				method)) && !mediaType.toString().equals(MediaType.APPLICATION_JSON)) {
			throw new WebApplicationException(Status.METHOD_NOT_ALLOWED);
			
		}

		
	}

}
