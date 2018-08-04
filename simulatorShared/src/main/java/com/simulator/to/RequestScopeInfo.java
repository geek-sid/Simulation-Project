package com.simulator.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestScopeInfo {
	
	private UserSessionInfo userSessionInfo;
	private String sessionId;
	public UserSessionInfo getUserSessionInfo() {
		return userSessionInfo;
	}
	public void setUserSessionInfo(UserSessionInfo userSessionInfo) {
		this.userSessionInfo = userSessionInfo;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	

}
