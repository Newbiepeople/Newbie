package com.helloweenvsfei.struts2.bean;

public class Magazine {

	private String name;

	private double price;

	public Magazine() {

	}

	public Magazine(String name, double price) {
		this.name = name;
		this.price = price;
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
