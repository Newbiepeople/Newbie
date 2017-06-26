package com.helloweenvsfei.petstore.session;

import javax.ejb.Remote;

import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;

@Remote
public interface ICategory<T extends CategoryEO> extends IBase<T> {

	public T findCategory(String name) throws PetstoreException;

	public T createCategory(T categoryEO) throws PetstoreException;

	public T saveCategory(T categoryEO) throws PetstoreException;

	public void deleteCategory(T categoryEO) throws PetstoreException;

}
