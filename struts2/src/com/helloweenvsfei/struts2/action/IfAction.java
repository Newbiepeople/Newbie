package com.helloweenvsfei.struts2.action;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import com.opensymphony.xwork2.Action;

@Results(value = { @Result(name = "success", value = "/ifTag.jsp") })
public class IfAction {

	private String name;

	public String execute() {
		return Action.SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
