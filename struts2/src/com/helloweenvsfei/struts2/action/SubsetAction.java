package com.helloweenvsfei.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.util.SubsetIteratorFilter;

import com.opensymphony.xwork2.Action;

@Results(value = { @Result(name = "success", value = "/subsetTag.jsp") })
@SuppressWarnings("all")
public class SubsetAction {

	private List<String> maleList = new ArrayList<String>() {
		{
			add("Machael");
			add("Scorfield");
			add("Other");
		}
	};

	private SubsetIteratorFilter.Decider decider = new SubsetIteratorFilter.Decider() {

		public boolean decide(Object obj) throws Exception {

			if (obj instanceof String) {
				if (obj.equals("Other"))
					return false;
				else
					return true;
			}

			return false;
		}
	};

	public String execute() {

		return Action.SUCCESS;
	}

	public List<String> getMaleList() {
		return maleList;
	}

	public void setMaleList(List<String> maleList) {
		this.maleList = maleList;
	}

	public SubsetIteratorFilter.Decider getDecider() {
		return decider;
	}

	public void setDecider(SubsetIteratorFilter.Decider decider) {
		this.decider = decider;
	}

}
