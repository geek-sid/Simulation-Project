package com.simulator.bd;

import com.simulator.exception.WSException;
import com.simulator.rest.request.AuthenticateUserRequest;
import com.simulator.rest.request.FetchAllUserInfoRequest;
import com.simulator.rest.response.AuthenticateUserResponse;
import com.simulator.rest.response.FetchAllUserInfoResponse;

public interface UserBd {
	
	public FetchAllUserInfoResponse getAllUserInfo(FetchAllUserInfoRequest requst);
	
	public AuthenticateUserResponse authenticateUser(AuthenticateUserRequest request) throws WSException;

}
