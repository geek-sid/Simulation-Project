package com.simulator.rest.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.simulator.rest.ValidationResult;
import com.simulator.rest.WSRequest;

@XmlRootElement
public class FetchAllUserInfoRequest implements WSRequest {
	
	long gameId;
	
	public FetchAllUserInfoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationResult validate() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	
	

}
