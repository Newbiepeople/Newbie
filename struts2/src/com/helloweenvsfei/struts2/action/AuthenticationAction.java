package com.helloweenvsfei.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class AuthenticationAction extends ActionSupport {

	private static final long serialVersionUID = -6161973490186833069L;

	private String message;

	public String execute() {

		message = "ฤ๚ีýิฺทรฮส AuthenticationAction. ";

		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
