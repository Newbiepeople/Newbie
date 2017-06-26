package com.helloweenvsfei.petstore.session.impl;

import java.util.List;

import javax.ejb.Stateless;

import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.session.ICategory;

@Stateless
public class CategoryImpl<T extends CategoryEO> extends BaseImpl<T> implements
		ICategory<T> {

	@SuppressWarnings("unchecked")
	public T findCategory(String name) throws PetstoreException {

		List<T> list = this.createQuery(
				" SELECT c FROM CategoryEO c WHERE c.name = :name ")
				.setParameter("name", name).getResultList();

		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public T createCategory(T categoryEO) throws PetstoreException {

		if (findCategory(categoryEO.getName()) != null) {
			throw new PetstoreException("类别已经存在：" + categoryEO.getName());
		}

		this.persist(categoryEO);

		return categoryEO;
	}

	public void deleteCategory(T categoryEO) throws PetstoreException {

		T t = findCategory(categoryEO.getName());

		if (t.getSubCategories().size() > 0) {
			throw new PetstoreException("子类别不为空，无法删除 " + categoryEO.getName()
					+ "。请先删除子类别。");
		}

		if (t.getPets().size() > 0) {
			throw new PetstoreException("宠物不为空，无法删除 " + categoryEO.getName()
					+ "。请先删除宠物。");
		}

		this.remove(t);

	}

	public T saveCategory(T catagoryEO) throws PetstoreException {

		List list = this.createQuery(
				" SELECT c FROM CategoryEO c WHERE c.name = :name AND c.id <> :id ")
				.setParameter("name", catagoryEO.getName()).setParameter("id",
						catagoryEO.getId()).getResultList();

		if (list.size() > 0) {
			throw new PetstoreException("该类别已经存在：" + catagoryEO.getName());
		}

		this.merge(catagoryEO);

		return catagoryEO;
	}

}
