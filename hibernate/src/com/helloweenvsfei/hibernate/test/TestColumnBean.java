package com.helloweenvsfei.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.helloweenvsfei.hibernate.bean.ColumnBean;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class TestColumnBean {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();

		ColumnBean columnBean = new ColumnBean();
		columnBean.setName("Test");

		session.persist(columnBean);

		session.getTransaction().commit();

		session.close();

	}
}
