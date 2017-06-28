package com.helloweenvsfei.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.helloweenvsfei.hibernate.bean.VersionBean;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class VersionTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		// Transaction insert
		session.beginTransaction();
		VersionBean versionBean = new VersionBean();
		versionBean.setName("Test");
		session.persist(versionBean);
		session.getTransaction().commit();

		System.out.println("version: " + versionBean.getVersion());

		// Transaction update
		session.beginTransaction();
		versionBean.setName("Test 2");
		session.save(versionBean);
		session.getTransaction().commit();

		System.out.println("version: " + versionBean.getVersion());

		// Transaction update
		session.beginTransaction();
		versionBean.setName("Test 3");
		session.save(versionBean);
		session.getTransaction().commit();

		System.out.println("version: " + versionBean.getVersion());

		session.close();
	}

}
