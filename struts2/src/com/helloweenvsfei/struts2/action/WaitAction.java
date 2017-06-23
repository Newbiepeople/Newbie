package com.helloweenvsfei.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class WaitAction extends ActionSupport {

	private static final long serialVersionUID = 4336459186175248309L;

	public String execute() throws Exception {

		// 10 seconds
		Thread.sleep(10000);

		return SUCCESS;
	}

}
