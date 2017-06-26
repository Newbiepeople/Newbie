package com.helloweenvsfei.petstore.session.impl;

import java.util.List;

import javax.ejb.Stateless;

import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.session.IUser;

@Stateless
public class UserImpl<T extends UserEO> extends BaseImpl<T> implements IUser<T> {

	@SuppressWarnings("unchecked")
	public T findUser(String login, String password) throws PetstoreException {

		List list = this.createQuery(
				" SELECT u FROM UserEO u WHERE u.login = :login "
						+ " and u.password = :password ").setParameter("login",
				login.toLowerCase().trim()).setParameter("password", password)
				.getResultList();

		if (list.size() > 0) {
			return (T) list.get(0);
		}

		return null;
	}

	public T createUser(T userEO) throws PetstoreException {

		List userList = this.createQuery(
				" SELECT u FROM UserEO u WHERE u.login = :login ")
				.setParameter("login", userEO.getLogin().toLowerCase().trim())
				.getResultList();

		if (userList.size() > 0) {
			throw new PetstoreException("用户名已经存在：" + userEO.getLogin());
		}

		return persist(userEO);

	}

}
