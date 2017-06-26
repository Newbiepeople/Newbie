package com.helloweenvsfei.petstore.session;

import java.util.List;

import javax.ejb.Remote;

import com.helloweenvsfei.petstore.entity.PetEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;

@Remote
public interface IPet<T extends PetEO> extends IBase<T> {

	public T createPet(T petEO) throws PetstoreException;

	public T savePet(T petEO) throws PetstoreException;

	public void deletePet(T petEO) throws PetstoreException;

	public List<T> listCategoryPet(String categoryName)
			throws PetstoreException;

}
