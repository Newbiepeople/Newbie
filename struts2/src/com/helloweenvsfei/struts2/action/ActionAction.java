package com.helloweenvsfei.struts2.action;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import com.opensymphony.xwork2.Action;

@Results(value = { @Result(name = "success", value = "/actionTag.jsp") })
public class ActionAction {

	public String execute() {

		return Action.SUCCESS;
	}

}
