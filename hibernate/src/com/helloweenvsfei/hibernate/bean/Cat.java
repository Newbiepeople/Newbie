package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@NamedQuery(name = "all cat", query = " select c from Cat c ")
//@NamedNativeQuery(name = "all cat", query = "select * from tb_cat")
@NamedQueries(value = {
		@NamedQuery(name = "all cat", query = " select c from Cat c "),
		@NamedQuery(name = "cat by name", query = " select c from Cat c where c.name = :name ", hints = { @QueryHint(name = "org.hibernate.callable", value = "true") }),
		@NamedQuery(name = "cat by mother", query = " select c from Cat c ") })
//@NamedNativeQueries(value = {
//		@NamedNativeQuery(name = "all cat", query = "select * from tb_cat"),
//		@NamedNativeQuery(name = "all cat", query = "select * from tb_cat"),
//		@NamedNativeQuery(name = "all cat", query = "select * from tb_cat") })
@Entity
// 注解Entity表示该类能被Hibernate持久化
@Table(name = "tb_cat")
// 指定该Entity对应的数据表名
public class Cat {

	@Id
	@Column(name = "id")
	// 指定该列为主键
	@GeneratedValue(strategy = GenerationType.AUTO)
	// 主键类型, auto为数据库自增长类型
	private Integer id;

	@Column(name = "name")
	// 指定属性对应的数据库表的列为“name”
	private String name;

	@Column(name = "description")
	// 同上。@Column与name均可省略
	private String description;

	@ManyToOne
	// 指定POJO之间的关系，本例为多对一关系
	@JoinColumn(name = "mother_id")
	// 该属性对应的列
	private Cat mother;

	@Temporal(TemporalType.TIMESTAMP)
	// 日期类型（DATE, TIME还是TIMESTEMP）
	@Column(name = "createDate")
	private Date createDate;

	@OneToMany(mappedBy = "cat")
	// @JoinColumns(value = { @JoinColumn(name = "cat_id", referencedColumnName
	// = "id") })
	private List<Event> events = new ArrayList<Event>();

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

	public Cat getMother() {
		return mother;
	}

	public void setMother(Cat mother) {
		this.mother = mother;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
