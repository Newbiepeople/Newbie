package com.helloweenvsfei.spring.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.helloweenvsfei.spring.orm.Cat;
import com.helloweenvsfei.spring.orm.ICatService;

public class CatController extends AbstractController {

	private ICatService catService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String action = request.getParameter("action");

		if ("add".equals(action)) {
			return this.add(request, response);
		}
		return this.list(request, response);
	}

	protected ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Cat> catList = catService.listCats();

		request.setAttribute("catList", catList);

		return new ModelAndView("cat/listCat");
	}

	protected ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Cat cat = new Cat();
		cat.setName(request.getParameter("name"));
		cat.setCreatedDate(new Date());

		catService.createCat(cat);

		return new ModelAndView("cat/listCat", "cat", cat);
	}

	public ICatService getCatService() {
		return catService;
	}

	public void setCatService(ICatService catService) {
		this.catService = catService;
	}
}
