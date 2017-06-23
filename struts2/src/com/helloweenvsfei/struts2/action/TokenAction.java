package com.helloweenvsfei.struts2.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class TokenAction extends ActionSupport {

	private static final long serialVersionUID = 1735769520495671098L;

	public static final List<String> NAMES = new ArrayList<String>();

	private String name;

	public String execute() {

		NAMES.add(name);

		return Action.SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<String> getNAMES() {
		return NAMES;
	}

}
