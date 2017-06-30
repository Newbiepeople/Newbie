package com.helloweenvsfei.spring.orm;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class OrmRun {

	public static void main(String[] args) {

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"applicationContext.xml"));

		ICatDao catDao = (ICatDao) factory.getBean("catDao");

		Cat cat = new Cat();
		cat.setName("Hello Kitty");
		cat.setCreatedDate(new Date());

		catDao.createCat(cat);

		List<Cat> catList = catDao.listCats();

		for (Cat c : catList) {
			System.out.println("Name: " + c.getName());
		}

	}

}
