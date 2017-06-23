package com.helloweenvsfei.struts2.action;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results(value = { @Result(name = "input", value = "/errorInput.jsp") })
public class ErrorAction extends ActionSupport {

	private static final long serialVersionUID = 6606367670105178335L;

	public String execute() {
		return INPUT;
	}

	public String error() {

		this.addActionError("执行 error() 方法，抛出了第一个 error 消息。");
		this.addActionError("执行 error() 方法，抛出了第二个 error 消息。");
		
		return INPUT;
	}

	public String message() {

		this.addActionMessage("执行 message() 方法，抛出了第一个 message 消息。");
		this.addActionMessage("执行 message() 方法，抛出了第二个 message 消息。");

		return INPUT;
	}

	public String fieldError() {
		
		this.addFieldError("username", "请填写用户名。");
		this.addFieldError("password", "密码不能为空。");

		return INPUT;
	}

}
