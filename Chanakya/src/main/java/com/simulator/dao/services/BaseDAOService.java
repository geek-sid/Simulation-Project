
package com.simulator.dao.services;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.simulator.dao.BaseDAO;
import com.simulator.util.TypeCast;

public class BaseDAOService implements BaseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Get the current session object.
	 * 
	 * @return Session
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Persists the object as a new row in the DB.
	 * 
	 * @param obj
	 *            object to save.
	 * @return the generated identifier.
	 */
	public Object save(Object obj) {
		return sessionFactory.getCurrentSession().save(obj);
	}

	/**
	 * Persists the object as a new row or updates an existing record in the DB.
	 * 
	 * @param obj
	 *            object to save.
	 * @return the generated identifier.
	 */
	public void saveOrUpdate(Object obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}

	/**
	 * Update the given persistent instance
	 * 
	 * @param obj
	 *            - the persistent instance to update
	 */
	public void update(Object obj) {
		sessionFactory.getCurrentSession().update(obj);
	}

	/**
	 * Fetches an instance from the DB by its id.
	 * 
	 * @param entityClazz
	 *            Class<T>
	 * @param id
	 *            Serializable
	 * @return <T> T - a generic type
	 */
	public <T> T getById(Class<T> entityClazz, Serializable id) {
		return TypeCast.<T>cast(sessionFactory.getCurrentSession().get(entityClazz, id));
	}

	/**
	 * Persists the list of object as a new row for each object in list in the
	 * DB.
	 * 
	 * @param entities
	 *            Collection<T> - collection of object(s) to save.
	 */
	public <T> void saveOrUpdateAll(Collection<T> entities) {
		for (Iterator<T> it = entities.iterator(); it.hasNext();) {
			sessionFactory.getCurrentSession().saveOrUpdate(it.next());
		}
	}

	/**
	 * Load an instance from the DB by its id.
	 * 
	 * @param entityClazz
	 *            Class<T>
	 * @param id
	 *            Serializable
	 * @return <T> T - a generic type
	 */
	public <T> T loadById(Class<T> entityClazz, Serializable id) {
		return TypeCast.<T>cast(sessionFactory.getCurrentSession().load(entityClazz, id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.newgen.simulator.dao.BaseDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

}
