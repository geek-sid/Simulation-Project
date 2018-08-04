package com.simulator.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simulator.bd.UserBd;
import com.simulator.rest.request.AuthenticateUserRequest;
import com.simulator.rest.request.FetchAllUserInfoRequest;
import com.simulator.rest.response.AuthenticateUserResponse;
import com.simulator.rest.response.FetchAllUserInfoResponse;
import com.simulator.util.LogManager;

@Component
@Path("/user")
public class UserService {
	
	@Autowired
	UserBd userBD;
	
	@POST
	@Path("/getALL")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public FetchAllUserInfoResponse fetchALLUsersInfo(FetchAllUserInfoRequest request) throws Exception {
		
		LogManager.debugLog.debug("Enter into User Service fetchALLUsersInfo() API");
		FetchAllUserInfoResponse response=userBD.getAllUserInfo(request);
		LogManager.debugLog.debug("Exit from User Service fetchALLUsersInfo() API");
		return response;
		
	}
	
	
	@POST
	@Path("/authenticateUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AuthenticateUserResponse authenticateUser(AuthenticateUserRequest request) throws Exception {
		
		LogManager.debugLog.debug("Enter into User Service authenticateUser() API");
		AuthenticateUserResponse response=userBD.authenticateUser(request);
		LogManager.debugLog.debug("Exit from User Service authenticateUser() API");
		return response;
		
	}

}
