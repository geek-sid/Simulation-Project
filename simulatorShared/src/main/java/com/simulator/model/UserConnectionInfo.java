package com.simulator.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UserConnectionInfo")
public class UserConnectionInfo {
	private Long id;
	private UserInfo userInfo;
	private String sessionId;
	private String tokenId;
	private Date connectDateTime;

	public UserConnectionInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserConnectionInfo(Long id, UserInfo userInfo, String sessionId, String tokenId, Date connectDateTime) {
		super();
		this.id = id;
		this.userInfo = userInfo;
		this.sessionId = sessionId;
		this.tokenId = tokenId;
		this.connectDateTime = connectDateTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Column(name = "SessionId")
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "TokenId")
	public String getTokenId() {
		return this.tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ConnectDateTime", length = 23)
	public Date getConnectDateTime() {
		return this.connectDateTime;
	}

	public void setConnectDateTime(Date connectDateTime) {
		this.connectDateTime = connectDateTime;
	}

}
