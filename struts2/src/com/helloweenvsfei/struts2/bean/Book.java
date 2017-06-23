package com.helloweenvsfei.struts2.bean;

import java.sql.Date;

public class Book {

	private String name;

	private String author;
	
	private Date publishedDate;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishDate) {
		this.publishedDate = publishDate;
	}

}
