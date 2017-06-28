package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestSQL {

	public static void main(String[] args) {

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		SQLQuery sqlQuery = session.createSQLQuery(" select * from tb_cat ");
		List<Object[]> list = sqlQuery.list();
		for (Object[] obj : list) {
			System.out.println(obj[0] + ", " + obj[1] + ", " + obj[3]);
		}

		sqlQuery.addEntity(Cat.class);
		List<Cat> catList = sqlQuery.list();

		for (Cat c : catList) {
			System.out.println(c.getName());
		}

		session.getTransaction().commit();
		session.close();

	}

}
