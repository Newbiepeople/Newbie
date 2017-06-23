package com.helloweenvsfei.struts2.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results(value = { @Result(name = "input", value = "divLogin.jsp"),
		@Result(name = "script", value = "divLoginScript.jsp") })
public class DivLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1158998175459669867L;

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {

		return "input";
	}

	public String login() {

		if ("helloween".equals(username) && "1234".equals(password)) {

			ServletActionContext.getRequest().getSession(true).setAttribute(
					"username", username);

			ServletActionContext.getRequest().setAttribute("status", "success");

		} else {

			ServletActionContext.getRequest().setAttribute("status", "failed");

		}

		return "script";
	}

	public String logout() {

		ServletActionContext.getRequest().getSession(true).removeAttribute(
				"username");

		ServletActionContext.getRequest().setAttribute("status", "logout");

		return "script";
	}

}
