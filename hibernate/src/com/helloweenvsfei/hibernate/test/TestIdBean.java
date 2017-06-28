package com.helloweenvsfei.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.helloweenvsfei.hibernate.bean.IdBean;

public class TestIdBean {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().addClass(IdBean.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();

		IdBean idBean = new IdBean();
		idBean.setName("Test");

		session.persist(idBean);

		session.getTransaction().commit();

		session.close();

	}

}
