package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "tb_person2")
public class Person2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Email.class, cascade = {
			CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE,
			CascadeType.REFRESH })
	@JoinColumns(value = { @JoinColumn(name = "person_id", referencedColumnName = "id") })
	@OrderBy(value="email desc")
	private List<Email> emails = new ArrayList<Email>();

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
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

}
