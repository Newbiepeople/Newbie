package com.helloweenvsfei.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import com.opensymphony.xwork2.Action;

@Results(value = { @Result(name = "success", value = "/checkboxlistTag.jsp") })
@SuppressWarnings("all")
public class CheckboxlistAction {

	private List<String> favourite = new ArrayList<String>() {
		{
			add("Æ»¹û");
			add("Àæ");
		}
	};

	public String execute() {
		return Action.SUCCESS;
	}

	public List<String> getFavourite() {
		return favourite;
	}

	public void setFavourite(List<String> favourite) {
		this.favourite = favourite;
	}

}
