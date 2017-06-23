package com.helloweenvsfei.struts2.action;

import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/test")
@Results( {
		@Result(name = "success", value = "/namespace1/success.jsp"),
		@Result(name = "redirect", value = "/namespace1/redirect.jsp", type = ServletRedirectResult.class),
		@Result(name = "login", value = "/namespace1/login.jsp") })
public class AnnotatedAction extends ActionSupport {

	private static final long serialVersionUID = 1583296508971581540L;

	public String execute() {
		return "login";
	}

	public String add() {
		return "success";
	}

	public String login() {
		return "login";
	}

}
