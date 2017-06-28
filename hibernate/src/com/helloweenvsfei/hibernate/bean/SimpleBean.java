package com.helloweenvsfei.hibernate.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
//@Table(name = "tb_simple_bean", catalog = "hibernate1", schema = "hibernate2")
@Table(name = "tb_simple_bean")
public class SimpleBean {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@SequenceGenerator(name = "seq_cat", allocationSize = 25)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cat")
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", columnDefinition = "double", nullable = true, insertable = true, length = 255, unique = true, updatable = true, precision = 2, scale = 4)
	@Basic
	private String name;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(columnDefinition = "int")
	private Boolean bool;

	@Version
	private int version;

	@Transient
	public int getNameLength() {
		return name == null ? 0 : name.length();
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}

}
