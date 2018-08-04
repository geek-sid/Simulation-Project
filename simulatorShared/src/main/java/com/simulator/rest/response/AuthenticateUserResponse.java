package com.simulator.rest.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.simulator.model.UserInfo;
import com.simulator.rest.WSResponse;

@XmlRootElement
public class AuthenticateUserResponse  extends WSResponse{
	
	private long userId;
	private String sessionId;
	private String cSRFToken;
	
	public AuthenticateUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticateUserResponse(int status, String message) {
		super(status, message);
		// TODO Auto-generated constructor stub
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getcSRFToken() {
		return cSRFToken;
	}

	public void setcSRFToken(String cSRFToken) {
		this.cSRFToken = cSRFToken;
	}

	@Override
	public String toString() {
		return "AuthenticateUserResponse [userId=" + userId + ", sessionId=" + sessionId + ", cSRFToken=" + cSRFToken
				+ "]";
	}	
	
	
	
	

}
