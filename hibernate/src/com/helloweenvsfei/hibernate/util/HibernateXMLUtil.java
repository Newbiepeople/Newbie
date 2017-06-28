package com.helloweenvsfei.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;

public class HibernateXMLUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// ¥” hibernate_xml.cfg.xml ÷–º”‘ÿ≈‰÷√
			sessionFactory = new Configuration().configure(
					"hibernate_xml.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {

		Cat cat = new Cat();
		cat.setName("º”∑∆√®");

		Event event = new Event();
		event.setDescription("≥‘‘Á∑π");
		event.setCat(cat);

		Session session = getSessionFactory().openSession();
		session.beginTransaction();

		session.persist(cat);
		session.persist(event);
		
		session.flush();
		session.getTransaction().commit();
		session.close();

		session = getSessionFactory().openSession();
		session.beginTransaction();
		Cat cc = (Cat)session.get(Cat.class, cat.getId());
		System.out.println(cc.getEvents().size());
		session.getTransaction().commit();
		session.close();

	}

}