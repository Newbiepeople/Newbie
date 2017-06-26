package com.helloweenvsfei.petstore.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_cart_item")
public class CartItemEO implements Serializable {

	private static final long serialVersionUID = 2589148402766708517L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private CartEO cart;

	@Column(name = "pet_category_name")
	private String petCategoryName;

	@Column(name = "pet_name")
	private String petName;

	private int count;

	private double price;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPetCategoryName() {
		return petCategoryName;
	}

	public void setPetCategoryName(String petCategoryName) {
		this.petCategoryName = petCategoryName;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CartEO getCart() {
		return cart;
	}

	public void setCart(CartEO cart) {
		this.cart = cart;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
