package com.helloweenvsfei.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results(value = { @Result(name = "input", value = "/divNews.jsp") })
public class DivNewsAction extends ActionSupport {

	private static final long serialVersionUID = 6560408661223488775L;

	private static String[] ALL_NEWS = { "中国将举办2008年奥运会, 开幕式日期 2008年8月8日",
			"继水立方后, 又一奥运建筑鸟巢体育馆日前竣工", "嫦娥探月卫星成功发射升空", "神舟六号号宇宙飞船胜利返航",
			"中国A股股市超跌反弹", };

	private String key;

	private List<String> news = new ArrayList<String>();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String execute() {

		if (key == null)
			key = "";

		for (String n : ALL_NEWS) {
			if (n.contains(key)) {
				news.add(n);
			}
		}

		return INPUT;
	}

	public List<String> getNews() {
		return news;
	}

	public void setNews(List<String> news) {
		this.news = news;
	}

}
