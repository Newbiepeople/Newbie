package com.helloweenvsfei.petstore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pet")
public class PetEO implements Serializable {

	private static final long serialVersionUID = -2631934326528672658L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEO category;

	private double price;

	public CategoryEO getCategory() {
		return category;
	}

	public void setCategory(CategoryEO catalog) {
		this.category = catalog;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
