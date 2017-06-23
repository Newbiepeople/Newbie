package com.helloweenvsfei.struts2.action;

import java.sql.Date;
import java.sql.Time;

import com.opensymphony.xwork2.ActionSupport;

public class ConvertorAction extends ActionSupport {

	private static final long serialVersionUID = -122055988813768554L;

	private Date sqlDate;
	private Time sqlTime;
	private java.util.Date utilDate;

	public String execute() {
		return INPUT;
	}
	
	public String convert(){
		return SUCCESS;
	}

	public Date getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(Date sqlDate) {
		this.sqlDate = sqlDate;
	}

	public Time getSqlTime() {
		return sqlTime;
	}

	public void setSqlTime(Time sqlTime) {
		this.sqlTime = sqlTime;
	}

	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

}
