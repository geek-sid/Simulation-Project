package com.simulator.rest.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.simulator.model.UserInfo;
import com.simulator.rest.WSResponse;

@XmlRootElement
public class FetchAllUserInfoResponse  extends WSResponse{

	public List<UserInfo> userInfos;
	public int totalCount;
	
	public FetchAllUserInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FetchAllUserInfoResponse(int status, String message) {
		super(status, message);
		// TODO Auto-generated constructor stub
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
