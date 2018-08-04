package com.simulator.dao.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simulator.dao.UserInfoDAO;
import com.simulator.model.UserInfo;
@Repository
public class USerInfoDAOService extends BaseDAOService implements UserInfoDAO {

	@Override
	@Transactional
	public List<UserInfo> getAllUser(long gameId) {
		Criteria criteria = getCurrentSession().createCriteria(UserInfo.class);
		criteria.add(Restrictions.eq("gameId", gameId));
		return  criteria.list();
	}

	@Override
	public List<UserInfo> saveUsers(List<UserInfo> useInfos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllUser(long gameId) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserInfo saveUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public UserInfo getUserDetailsByName(String username) {
		Criteria criteria = getCurrentSession().createCriteria(UserInfo.class);
		criteria.add(Restrictions.eq("username", username));
		return  (UserInfo) criteria.uniqueResult();
	}

}
