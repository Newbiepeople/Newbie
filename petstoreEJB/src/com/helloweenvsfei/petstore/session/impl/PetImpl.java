package com.helloweenvsfei.petstore.session.impl;

import java.util.List;

import javax.ejb.Stateless;

import com.helloweenvsfei.petstore.entity.PetEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.session.IPet;

@Stateless
public class PetImpl<T extends PetEO> extends BaseImpl<T> implements IPet<T> {

	public T createPet(T petEO) throws PetstoreException {

		List list = this
				.createQuery(
						" SELECT p FROM PetEO p WHERE p.name = :name AND p.category.id = :categoryId ")
				.setParameter("name", petEO.getName()).setParameter(
						"categoryId", petEO.getCategory().getId())
				.getResultList();

		if (list.size() > 0) {
			throw new PetstoreException("类别 " + petEO.getCategory().getName()
					+ " 下已经存在宠物：" + petEO.getName());
		}

		return this.persist(petEO);

	}

	public void deletePet(T petEO) throws PetstoreException {

		this.remove(petEO);

	}

	public T savePet(T petEO) throws PetstoreException {

		List list = this
				.createQuery(
						" SELECT p FROM PetEO p "
						+ " WHERE p.name = :name AND p.category.id = :categoryId AND p.id <> :id ")
				.setParameter("name", petEO.getName()).setParameter(
						"categoryId", petEO.getCategory().getId())
				.setParameter("id", petEO.getId()).getResultList();

		if (list.size() > 0) {
			throw new PetstoreException("类别 " + petEO.getCategory().getName()
					+ " 下已经存在宠物：" + petEO.getName());
		}

		return this.merge(petEO);

	}

	@SuppressWarnings("unchecked")
	public List<T> listCategoryPet(String categoryName)
			throws PetstoreException {

		return this.createQuery(
				" SELECT p FROM PetEO p WHERE p.category.name = :name ")
				.setParameter("name", categoryName).getResultList();
	}

}
