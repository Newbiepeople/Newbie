package com.helloweenvsfei.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class TimerAction extends ActionSupport {

	private static final long serialVersionUID = 8540078262105209335L;

	public String execute() throws Exception {

		Thread.sleep(1000);

		return SUCCESS;
	}

}
