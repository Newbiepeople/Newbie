package com.helloweenvsfei.struts2.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 7912892052170751803L;

	// 帐号
	private String account;

	// 密码
	private String password;

	// 主方法 如果用户名密码匹配 则返回成功页面 否则返回登录页面
	public String execute() {

		if ("helloween".equalsIgnoreCase(account) && "1234".equals(password)) {
			return SUCCESS;
		}

		return LOGIN;
	}

	public String login() {

		// 获取 request、response
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		// 将帐号放到 session 中
		HttpSession session = request.getSession(true);
		session.setAttribute("account", account);

		// 获取web应用根目录下 /upload 文件夹
		ServletContext context = ServletActionContext.getServletContext();
		File uploadFile = new File(context.getRealPath("upload"));

		return execute();
	}

	public String logout() {
		// 注销代码
		return "logout";
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
