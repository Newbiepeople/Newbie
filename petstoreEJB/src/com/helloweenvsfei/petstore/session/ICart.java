package com.helloweenvsfei.petstore.session;

import javax.ejb.Remote;

import com.helloweenvsfei.petstore.entity.CartEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;

@Remote
public interface ICart<T extends CartEO> extends IBase<T> {

	public T findCart(String login) throws PetstoreException;

	public T addItem(String login, String catagoryName, String petName,
			double price, int count) throws PetstoreException;

	public T setItem(String login, String catagoryName, String petName,
			double price, int count) throws PetstoreException;

	public T payCart(T cartEO) throws PetstoreException;

}
