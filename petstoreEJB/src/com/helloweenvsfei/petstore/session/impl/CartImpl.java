package com.helloweenvsfei.petstore.session.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.helloweenvsfei.petstore.entity.CartEO;
import com.helloweenvsfei.petstore.entity.CartItemEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.session.ICart;

@Stateless
public class CartImpl<T extends CartEO> extends BaseImpl<T> implements ICart<T> {

	/**
	 * 往购物车中 添加宠物
	 */
	public T addItem(String login, String categoryName, String petName,
			double price, int count) throws PetstoreException {

		T cartEO = findCart(login);

		boolean contains = false;

		for (CartItemEO cartItemEO : cartEO.getCartItems()) {

			if (cartItemEO.getPetCategoryName().equals(categoryName)
					&& cartItemEO.getPetName().equals(petName)) {

				cartItemEO.setCount(count + cartItemEO.getCount());
				cartItemEO.setDate(new Date());
				contains = true;
				break;
			}
		}

		if (!contains) {

			CartItemEO cartItemEO = new CartItemEO();
			cartItemEO.setCart(cartEO);
			cartItemEO.setCount(count);
			cartItemEO.setDate(new Date());
			cartItemEO.setPetCategoryName(categoryName);
			cartItemEO.setPetName(petName);
			cartItemEO.setPrice(price);

			cartEO.getCartItems().add(cartItemEO);
		}

		return merge(cartEO);
	}

	public T setItem(String login, String categoryName, String petName,
			double price, int count) throws PetstoreException {

		T cartEO = findCart(login);

		boolean contains = false;

		for (CartItemEO cartItemEO : cartEO.getCartItems()) {

			if (cartItemEO.getPetCategoryName().equals(categoryName)
					&& cartItemEO.getPetCategoryName().equals(categoryName)) {

				cartItemEO.setCount(count);
				cartItemEO.setDate(new Date());
				contains = true;
				break;
			}
		}

		if (!contains) {

			CartItemEO cartItemEO = new CartItemEO();
			cartItemEO.setCount(count);
			cartItemEO.setDate(new Date());
			cartItemEO.setPetCategoryName(categoryName);
			cartItemEO.setPetName(petName);
			cartItemEO.setPrice(price);

			cartEO.getCartItems().add(cartItemEO);
		}

		return merge(cartEO);
	}

	/**
	 * 查找用户 login 的未付款的购物车
	 */
	@SuppressWarnings("unchecked")
	public T findCart(String login) throws PetstoreException {

		List<T> cartList = createQuery(
				" SELECT c FROM CartEO c where c.name = :name and c.payed = false ")
				.setParameter("name", login).getResultList();

		if (cartList.size() > 0) {
			return cartList.get(0);
		}

		CartEO cartEO = new CartEO();
		cartEO.setDate(new Date());
		cartEO.setName(login);
		cartEO.setPayed(false);
		cartEO.setUser(null);

		return persist((T) cartEO);
	}

	public T payCart(T cartEO) throws PetstoreException {

		cartEO.setPayed(true);

		return merge(cartEO);
	}

}
