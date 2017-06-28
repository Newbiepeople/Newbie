package com.helloweenvsfei.hibernate.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sailor")
public class Sailor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ship_id")
	private Ship ship;

	@OneToOne(mappedBy = "captain")
	private Ship captainedShip;

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

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Ship getCaptainedShip() {
		return captainedShip;
	}

	public void setCaptainedShip(Ship catainedShip) {
		this.captainedShip = catainedShip;
	}

}
