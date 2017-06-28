package com.helloweenvsfei.hibernate.bean;

import java.util.Date;

public class Person {

	private Integer id;

	private String name;

	private boolean expertInHibernate;

	private Date createDate;

	public boolean isExpertInHibernate() {
		return expertInHibernate;
	}

	public void setExpertInHibernate(boolean expertInHibernate) {
		this.expertInHibernate = expertInHibernate;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
