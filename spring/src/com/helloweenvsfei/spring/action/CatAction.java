package com.helloweenvsfei.spring.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.util.Assert;
import org.springframework.web.struts.ActionSupport;

import com.helloweenvsfei.spring.form.CatForm;
import com.helloweenvsfei.spring.orm.Cat;
import com.helloweenvsfei.spring.orm.ICatService;

public class CatAction extends ActionSupport {

	public ICatService getCatService() {
		return (ICatService) getWebApplicationContext().getBean("catService");
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		CatForm catForm = (CatForm) form;

		if ("add".equals(catForm.getAction()))
			return this.add(mapping, form, request, response);

		return this.list(mapping, form, request, response);
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		CatForm catForm = (CatForm) form;

		Assert.hasLength(catForm.getName(), "名字不能为 null");

		Cat cat = new Cat();
		cat.setName(catForm.getName());
		cat.setCreatedDate(new Date());

		ICatService catService = getCatService();
		catService.createCat(cat);
		
		return this.list(mapping, form, request, response);
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ICatService catService = getCatService();

		List<Cat> catList = catService.listCats();

		request.setAttribute("catList", catList);

		return mapping.findForward("list");
	}
}