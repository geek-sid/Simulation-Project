package com.simulator.bd.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.simulator.util.CommonUtil;
import com.simulator.util.LogManager;
import com.simulator.bd.UserBd;
import com.simulator.dao.UserConnectionInfoDAO;
import com.simulator.dao.UserInfoDAO;
import com.simulator.exception.WSException;
import com.simulator.model.UserConnectionInfo;
import com.simulator.model.UserInfo;
import com.simulator.rest.request.AuthenticateUserRequest;
import com.simulator.rest.request.FetchAllUserInfoRequest;
import com.simulator.rest.response.AuthenticateUserResponse;
import com.simulator.rest.response.FetchAllUserInfoResponse;
import com.simulator.to.UserSessionInfo;
import com.simulator.utils.WSConstants.WSExceptionConstant;


public class UserBDService implements UserBd {
	
	@Autowired
	UserInfoDAO userInfoDAO;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserConnectionInfoDAO userConnectionInfoDAO;

	@Override
	public FetchAllUserInfoResponse getAllUserInfo(FetchAllUserInfoRequest requst) {
		FetchAllUserInfoResponse response = new FetchAllUserInfoResponse();
		List<UserInfo> userInfos=userInfoDAO.getAllUser(requst.getGameId());
		response.setTotalCount(userInfos.size());
		response.setUserInfos(userInfos);
		return response;
		
	}

	@Override
	public AuthenticateUserResponse authenticateUser(AuthenticateUserRequest request) throws WSException {
		AuthenticateUserResponse response = new AuthenticateUserResponse();
		UserInfo user = userInfoDAO.getUserDetailsByName(request.getUsername());
		
		if(user == null) {
			throw new WSException(WSExceptionConstant.USER_NOT_FOUND,"" , messageSource);
		}else if(!user.getPwd().equalsIgnoreCase(request.getAuthpwd())) {
			throw new WSException(WSExceptionConstant.INVALID_PASSWORD,"" , messageSource);
		}
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
		String token = UUID.randomUUID().toString();

		UserSessionInfo userSessionInfo = new UserSessionInfo(user.getId(),user.getUsername(), token, format.format(date));

		String json = CommonUtil.toJson(userSessionInfo);
		String sessionId = CommonUtil.encrypt(json);

		LogManager.debugLog.debug(json + " " + sessionId);

		UserConnectionInfo userConnectionInfo = new UserConnectionInfo();
		userConnectionInfo.setConnectDateTime(date);
		userConnectionInfo.setSessionId(sessionId);
		userConnectionInfo.setUserInfo(user);
		userConnectionInfo.setTokenId(token);

		userConnectionInfoDAO.saveUserConnectionInfo(userConnectionInfo);
		response.setcSRFToken(token);
		response.setSessionId(sessionId);
		response.setUserId(user.getId());
		return response;
		
	}

}
