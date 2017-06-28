package com.helloweenvsfei.hibernate.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_column_bean")
public class ColumnBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", insertable = true, updatable = false)
	private Integer Id;

	@Column(name = "name", columnDefinition = "longtext", length = 255, nullable = true, insertable = true, updatable = true)
	private String name;

	@Column(name = "salary", scale = 8, precision = 2)
	@Basic(fetch = FetchType.LAZY, optional=true)
	private double salary;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Transient
	public int getNameLength() {
		return name == null ? 0 : name.length();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
