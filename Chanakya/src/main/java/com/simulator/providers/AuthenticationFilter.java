package com.simulator.providers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.simulator.dao.UserConnectionInfoDAO;
import com.simulator.exception.WSException;
import com.simulator.model.UserConnectionInfo;
import com.simulator.to.RequestScopeInfo;
import com.simulator.to.UserSessionInfo;
import com.simulator.util.CommonUtil;
import com.simulator.util.LogManager;
import com.simulator.util.SimulatorConstants;
import com.simulator.utils.WSConstants.WSExceptionConstant;


@Provider
@PreMatching
public class AuthenticationFilter implements ContainerRequestFilter {
	public static final String AUTHENTICATION_HEADER = "Authorization";
	@Context
	private HttpServletRequest httpServletRequest;
	@Autowired
	private MessageSource messageSource;
	@Autowired 
	private UserConnectionInfoDAO userConnectionInfoDAO;
	private RequestScopeInfo requestScopeInfo;
	private String sessionId = null;

	@Override
	public void filter(ContainerRequestContext request) throws WebApplicationException {
		if (request.getHeaders().containsKey(AUTHENTICATION_HEADER)) {
			sessionId = request.getHeaderString(AUTHENTICATION_HEADER);
			if ("null".equalsIgnoreCase(sessionId)) {
				sessionId = null;
			}
		}
		requestScopeInfo = new RequestScopeInfo();
		populateUserSessionInfoDetails();
		
		 
		
		httpServletRequest.setAttribute("RequestScopeInfo", requestScopeInfo);
		String api = request.getUriInfo().getPath();
		if (!SimulatorConstants.getByPassUrls().contains(api)) {
			try {
				validateSessionId();
			} catch (WSException e) {
				throw new WebApplicationException(e);
			}
		}
	}

		public void populateUserSessionInfoDetails() {
		UserSessionInfo sessionInfo = new UserSessionInfo();

		if (sessionId != null && sessionId.length() > 0) {
			sessionInfo = CommonUtil.<UserSessionInfo>fromJson(CommonUtil.decrypt(sessionId), UserSessionInfo.class);
		}

		LogManager.debugLog.debug("sessionInfo:" + sessionInfo.toString());

		requestScopeInfo.setUserSessionInfo(sessionInfo);
		requestScopeInfo.setSessionId(sessionId);
	}

	public void validateSessionId() throws WSException {
		UserSessionInfo sessionInfo = requestScopeInfo.getUserSessionInfo();
		UserConnectionInfo userConnectionInfo = userConnectionInfoDAO.getUserConnectionInfoByUserIdAndTokenId(
				sessionInfo.getUserId(), sessionInfo.getCsrfToken());
		if (userConnectionInfo != null && sessionId.equals(userConnectionInfo.getSessionId())) {
			// success
		} else {
			throw new WSException(WSExceptionConstant.INVALID_SESSION, "", messageSource);
		}

	}

}