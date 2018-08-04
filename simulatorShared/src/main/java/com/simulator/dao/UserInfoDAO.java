package com.simulator.dao;

import java.util.List;

import com.simulator.model.UserConnectionInfo;
import com.simulator.model.UserInfo;

public interface UserInfoDAO {

	public List<UserInfo> getAllUser(long gameId);
	public List<UserInfo> saveUsers(List<UserInfo> useInfos);
	public void deleteUserById(long id);
	public void deleteAllUser(long gameId);
	public UserInfo saveUserInfo(UserInfo userInfo);
	public UserInfo getUserDetailsByName(String username);
	
}
