package com.helloweenvsfei.struts2.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Person {

	private Integer id;

	private String account;

	private String name;

	private Date birthday;

	private Timestamp createDate = new Timestamp(System.currentTimeMillis());

	private boolean secret;

	private List<String> hobby = new ArrayList<String>();

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
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

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}

}
