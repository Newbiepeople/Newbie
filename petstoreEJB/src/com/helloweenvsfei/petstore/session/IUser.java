package com.helloweenvsfei.petstore.session;

import javax.ejb.Remote;

import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;

@Remote
public interface IUser<T extends UserEO> extends IBase<T> {

	public T createUser(T userEO) throws PetstoreException;

	public T findUser(String login, String password) throws PetstoreException;

}
