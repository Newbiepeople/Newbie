package com.helloweenvsfei.struts2.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ServletAwareAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, SessionAware,
		ServletContextAware {

	private static final long serialVersionUID = -2489850710438755365L;

	private ServletContext application;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map session;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setSession(Map sessionValues) {
		this.session = sessionValues;
	}

	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public String execute() {

		String upload = application.getRealPath("upload");
		
		request.getRemoteAddr();
		response.getContentType();
		session.get("account");

		return Action.SUCCESS;
	}
}
