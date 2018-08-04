package com.simulator.dao;

import java.util.List;

import com.simulator.model.UserConnectionInfo;
import com.simulator.model.UserInfo;

public interface UserConnectionInfoDAO {

	/**
	 * @return
	 */
	public List<UserConnectionInfo> getUserConnections();

	/**
	 * @param id
	 * @return
	 */
	public UserConnectionInfo getUserConnectionInfoById(int id);

	/**
	 * @param connectionInfo
	 * @return
	 */
	public UserConnectionInfo saveUserConnectionInfo(UserConnectionInfo connectionInfo);

	/**
	 * @param connectionInfo
	 */
	public void updateUserConnectionInfo(UserConnectionInfo connectionInfo);

	/**
	 * @param id
	 */
	public void deleteUserConnectionInfo(int id);

	public void deleteUserConnectionInfoByUserId(long id);
	
	public UserConnectionInfo getUserConnectionInfoByUserIdAndTokenId(long userId, String tokenId);
	public void deleteUserConnectionInfoByUserIdAndTokenId(long id,String tokenId);
	
	
	
}
