package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ship")
public class Ship {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "captain_id", unique = true)
	private Sailor captain;

	@OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST)
	private Set<Sailor> sailors = new HashSet<Sailor>();

	public Sailor getCaptain() {
		return captain;
	}

	public void setCaptain(Sailor captain) {
		this.captain = captain;
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

	public Set<Sailor> getSailors() {
		return sailors;
	}

	public void setSailors(Set<Sailor> sailors) {
		this.sailors = sailors;
	}

}
