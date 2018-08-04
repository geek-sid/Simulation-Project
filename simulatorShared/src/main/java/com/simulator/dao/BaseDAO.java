package com.simulator.dao;

import java.io.Serializable;
import java.util.Collection;

public interface BaseDAO {

	/**
	 * Persists the object as a new row in the DB.
	 * 
	 * @param obj
	 *            object to save.
	 * @return the generated identifier.
	 */
	public Object save(Object obj);

	/**
	 * Persists the object as a new row or updates an existing record in the DB.
	 * 
	 * @param obj
	 *            object to save.
	 * @return the generated identifier.
	 */
	public void saveOrUpdate(Object obj);

	/**
	 * Updates the row.
	 * 
	 * @param obj
	 */
	public void update(Object obj);

	/**
	 * Returns a List of results based on the HQL query passed. Returns an empty
	 * list if no record matches the query conditions.
	 * 
	 * @param queryString
	 *            HQL query string.
	 * @param params
	 *            parameter varargs.
	 * @return list of objects retrieved.
	 */
	/*public List findByQuery(String queryString, Object... params);*/

	/**
	 * Returns a single object based on the HQL query passed. The query may
	 * return more than one row; only the 1st record is returned from this
	 * method. Returns null if no record matches the query conditions.
	 * 
	 * @param queryString HQL query string.
	 * @param params parameter varargs.
	 * @return 1st object retrieved, or null if no record is found.
	 */
	/*public Object findObjectByQuery(String queryString, Object... params);*/

	/**
	 * Load records in batches from database  
	 * @param entityClazz class of objects to be fetched
	 * @param firstResult first result 
	 * @param maxResults maximum results
	 * @return list of objects
	 */
	/*public <T> List<T> get(Class<T> entityClazz, int firstResult, int maxResults);*/

	/**
	 * Fetches an instance from the DB by its id.
	 * 
	 * @param entityClazz
	 * @param id
	 * @return
	 */
	public <T> T getById(Class<T> entityClazz, Serializable id);

	/*
	 * Common functions used across multiple DAOs and services. In future these
	 * may get moved to a separate DAO if the number of such functions become
	 * too many.
	 */

	/**
	 * Persists the list of object as a new row for each object in list in the
	 * DB.
	 * 
	 * @param entities
	 *            Collection<T> - collection of object(s) to save.
	 */
	public <T> void saveOrUpdateAll(Collection<T> entities);

	/**
	 * Update/delete all objects according to the given query, binding a number
	 * of values to "?" parameters in the query string.
	 * 
	 * @param hql
	 *            - an update/delete query expressed in Hibernate's query
	 *            language
	 * @param params
	 *            - the values of the parameters
	 * @return the number of instances updated/deleted
	 */
	/*public int updateByHQL(String hql, Object... params);*/

	/**
	 * Load All Data from DB
	 * 
	 * @param clazz Class
	 * @return List<T> 
	 */
	/*public List loadAll(Class clazz);*/

	/**
	 * Delete the list of object in list in the DB.
	 * 
	 * @param List
	 *            of obj object to delete.
	 */

	/*public void deleteAll(List entities);*/

	/**
	 * Load an instance from the DB by its id.
	 * 
	 * @param entityClazz
	 * @param id
	 * @return
	 */
	public <T> T loadById(Class<T> entityClazz, Serializable id);

	/**
	 * Persists the list of object as a new row for each object in list in the
	 * DB.
	 * 
	 * @param entities
	 *            Collection<T> - collection of object(s) to save.
	 */
	/*public <T> void saveOrUpdateInBatch(Collection<T> entities);*/

	/**
	 * Persists the list of object as a updated objects in the
	 * DB.
	 * 
	 * @param entities
	 *            Collection<T> - collection of object(s) to save.
	 */
	/*public <T> void updateInBatch(final Collection<T> entities);	*/
	/**
	 * Persists the list of object as a new row for each object in list in the
	 * DB.
	 * 
	 * @param entities
	 *            Collection<T> - collection of object(s) to save.
	 */

	/*public <T> void saveInBatch(final Collection<T> entities);	*/


	/**
	 * Deletes the object in the DB.
	 * 
	 * @param entities
	 *           Object- object to delete.
	 */
	public void delete(Object entity);
}
