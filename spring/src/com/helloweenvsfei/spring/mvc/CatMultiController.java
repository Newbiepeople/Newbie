package com.helloweenvsfei.spring.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.helloweenvsfei.spring.orm.Cat;
import com.helloweenvsfei.spring.orm.ICatService;

public class CatMultiController extends MultiActionController {

	private ICatService catService;

	public ICatService getCatService() {
		return catService;
	}

	public void setCatService(ICatService catService) {
		this.catService = catService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) {

		Cat cat = new Cat();
		cat.setName(request.getParameter("name"));
		cat.setCreatedDate(new Date());

		catService.createCat(cat);

		return this.list(request, response);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) {

		List<Cat> catList = catService.listCats();

		request.setAttribute("catList", catList);

		return new ModelAndView("cat/listCat");
	}

}
