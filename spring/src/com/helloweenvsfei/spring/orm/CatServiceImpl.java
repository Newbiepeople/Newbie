package com.helloweenvsfei.spring.orm;

import java.util.List;

public class CatServiceImpl implements ICatService {

	private ICatDao catDao;

	public ICatDao getCatDao() {
		return catDao;
	}

	public void setCatDao(ICatDao catDao) {
		this.catDao = catDao;
	}

	public void createCat(Cat cat) {

		if (catDao.findCatByName(cat.getName()) != null)
			throw new RuntimeException("Ã¨" + cat.getName() + "ÒÑ¾­´æÔÚ¡£" );

		catDao.createCat(cat);
	}

	public int getCatsCount() {
		return catDao.getCatsCount();
	}

	public List<Cat> listCats() {
		return catDao.listCats();
	}

}
