package com.simulator.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserSessionInfo {

	private long userId;
	private String username;
	private String csrfToken;
	private String expiryDate;

	public UserSessionInfo() {
		super();
	}

	public UserSessionInfo(long userId, String username, String csrfToken,
			String expiryDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.csrfToken = csrfToken;
		this.expiryDate = expiryDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCsrfToken() {
		return csrfToken;
	}

	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "UserSessionInfo [ userId=" + userId + ", username=" + username + ", csrfToken=" + csrfToken + ", expiryDate=" + expiryDate + "]";
	}

}