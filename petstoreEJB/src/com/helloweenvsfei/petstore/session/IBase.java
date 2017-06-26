package com.helloweenvsfei.petstore.session;

import java.util.List;

import javax.persistence.Query;

public interface IBase<T> {

	/**
	 * 查询对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T find(Class<? extends T> clazz, int id);

	/**
	 * 添加对象
	 * 
	 * @param t
	 * @return
	 */
	public T persist(T t);

	/**
	 * 保存对象
	 * 
	 * @param t
	 * @return
	 */
	public T merge(T t);

	/**
	 * 删除对象
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T remove(Class<? extends T> clazz, int id);

	/**
	 * 删除对象
	 * 
	 * @param t
	 * @return
	 */
	public T remove(T t);

	/**
	 * 列出所有对象
	 * 
	 * @param clazz
	 * @return
	 */
	public List<T> listAll(Class<? extends T> clazz);

	public List<T> list(String jpql);

	/**
	 * 查询所有对象个数
	 * 
	 * @param clazz
	 * @return
	 */
	public int getTotalCount(Class<? extends T> clazz);

	/**
	 * 列出从 firstResult 开始的 maxResult 个对象
	 * 
	 * @param clazz
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<T> list(Class<? extends T> clazz, int firstResult, int maxResult);

	/**
	 * 查询符合 hql 的对象个数
	 * 
	 * @param jpql
	 * @return
	 */
	public int getTotalCount(String jpql);

	/**
	 * 列出从 firstResult 开始的 maxResult 个对象
	 * 
	 * @param jpql
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<T> list(String jpql, int firstResult, int maxResult);

	/**
	 * 创建 Query 对象
	 * 
	 * @param jpql
	 * @return
	 */
	public Query createQuery(String jpql);

}
