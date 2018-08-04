package com.simulator.dao.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simulator.dao.UserConnectionInfoDAO;
import com.simulator.dao.UserInfoDAO;
import com.simulator.model.UserConnectionInfo;
import com.simulator.model.UserInfo;
@Repository
public class UserConnectionInfoDAOService extends BaseDAOService implements UserConnectionInfoDAO {

	@Override
	public List<UserConnectionInfo> getUserConnections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserConnectionInfo getUserConnectionInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public UserConnectionInfo saveUserConnectionInfo(UserConnectionInfo connectionInfo) {
		getCurrentSession().save(connectionInfo);
		return connectionInfo;
		
	}

	@Override
	public void updateUserConnectionInfo(UserConnectionInfo connectionInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserConnectionInfo(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserConnectionInfoByUserId(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public UserConnectionInfo getUserConnectionInfoByUserIdAndTokenId(long userId, String tokenId) {
		/*Criteria criteria = getCurrentSession().createCriteria(UserConnectionInfo.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("tokenId", tokenId));
		return  (UserConnectionInfo) criteria.uniqueResult();*/
		
		Query query = getCurrentSession().createQuery(
				"from UserConnectionInfo where UserId = :userId and TokenId= :tokenId");
		query.setParameter("userId", userId);
		query.setParameter("tokenId", tokenId);
		UserConnectionInfo userConnectionInfo = (UserConnectionInfo) query.uniqueResult();
		return userConnectionInfo;
	}

	@Override
	public void deleteUserConnectionInfoByUserIdAndTokenId(long id, String tokenId) {
		// TODO Auto-generated method stub
		
	}

	

}
