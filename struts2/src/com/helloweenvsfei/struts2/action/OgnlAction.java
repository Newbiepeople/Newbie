package com.helloweenvsfei.struts2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.helloweenvsfei.struts2.bean.Magazine;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class OgnlAction extends ActionSupport implements ServletContextAware,
		ServletRequestAware, SessionAware {

	private static final long serialVersionUID = -6175904602786022346L;

	private HttpServletRequest request;
	private ServletContext application;
	private Map<String, Object> session;

	@SuppressWarnings("all")
	private List<Magazine> magazineList = new ArrayList<Magazine>() {
		{
			add(new Magazine("时代周刊", 10));
			add(new Magazine("足球之夜", 19));
			add(new Magazine("时尚", 20));
			add(new Magazine("时代影视", 50));
		}
	};

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	@SuppressWarnings("all")
	public void setSession(Map session) {
		this.session = session;
	}

	public String execute() {

		request.setAttribute("account", "account from request");
		application.setAttribute("account", "account from response");
		session.put("account", "account from session");

		return Action.SUCCESS;
	}

	public List<Magazine> getMagazineList() {
		return magazineList;
	}

	public void setMagazineList(List<Magazine> bookList) {
		this.magazineList = bookList;
	}

}
