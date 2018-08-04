package com.simulator.providers;

import java.util.Collection;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.simulator.exception.WSException;
import com.simulator.util.SimulatorConstants;
import com.simulator.utils.WSConstants.WSExceptionConstant;


@Component
@PreMatching
@Provider
public class StatelessCSRFFilter implements ContainerRequestFilter {
	private static final String X_CSRF_TOKEN = "X-CSRF-TOKEN";
	@Autowired
	private MessageSource messageSource;

	@Override
	public void filter(ContainerRequestContext request) throws WebApplicationException  {
		String api = request.getUriInfo().getPath();
		String csrfTokenValue = request.getHeaderString(X_CSRF_TOKEN);
		if (csrfTokenValue == null) {
			csrfTokenValue = "";
		}
		boolean isCookiePresent = false;
		
		java.util.Map<String, javax.ws.rs.core.Cookie> maps = request.getCookies();

		Collection<javax.ws.rs.core.Cookie> cookies = maps.values();
		for (Cookie cookie : cookies) {
			if (X_CSRF_TOKEN.equalsIgnoreCase(cookie.getName()) && csrfTokenValue.equalsIgnoreCase(cookie.getValue())) {
				isCookiePresent = true;
			}

		}
		if (!SimulatorConstants.getByPassUrls().contains(api) && !isCookiePresent) {
			throw new WebApplicationException(new WSException(WSExceptionConstant.INVALID_SESSION,
					"", messageSource));
		}
	}

}
