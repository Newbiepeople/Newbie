package com.helloweenvsfei.hibernate.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestHQL {

	public static void main(String[] args) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		session.beginTransaction();

		Cat cat = new Cat();
		cat.setCreateDate(new Date());
		cat.setName("Ketty");

		Cat cc = new Cat();
		cc.setCreateDate(new Date());
		cc.setName("a");
		cc.setMother(cat);

		session.persist(cat);
		session.persist(cc);

		Query query = session.createQuery(" from Cat ");
		List<Cat> catList = query.list();

		Query q = session.createQuery(" select count(c) from Cat c ");
		Long count = (Long) q.uniqueResult();

		List<String> nameList = session.createQuery(
				" select c.name from Cat c ").list();

		int c = (Integer) session.createQuery(
				" select max(c.id) from Cat c where c.mother = null ")
				.uniqueResult();

		List list = session.createQuery(
				" select c.name, c.mother, c.createDate from Cat c ").list();

		for (Object row : list) {
			System.out.println("-------------------------");
			for (Object obj : (Object[]) row) {
				System.out.println("" + obj);
			}
		}

		List list2 = session.createQuery(
				" select new List(c.name, c.mother, c.createDate) from Cat c ")
				.list();

		for (Object row : list2) {
			System.out.println("-------------------------");
			for (Object obj : (List) row) {
				System.out.println("" + obj);
			}
		}

		List listMap = session
				.createQuery(
						" select new map(c.name as name, c.mother as mother, c.createDate as createDate) "
								+ " from Cat c ").list();

		for (Map map : (List<Map>) listMap) {
			System.out.println("Name: " + map.get("name"));
			System.out.println("Mother: " + map.get("mother"));
			System.out.println("createDate: " + map.get("createDate"));
		}

		session
				.createQuery(
						" select c from Cat c "
								+ " where c.mother.name = null and c.createDate < :createDate and size(c.events) > 0 ")
				.setParameter("createDate", new Date()).list();

		System.out.println(count);

		List<String> sList = session.createQuery(
				" select c.name || 'µÄÂèÂèÎª' || c.mother.name "
						+ " from Cat c where c.mother != null ").list();

		for (String s : sList) {
			System.out.println(s);
		}

		List<Cat> ccList = session.createQuery(" from Cat ").setFirstResult(0)
				.setMaxResults(10).list();

		for (Cat ct : ccList) {
			System.out.println(ct.getId());
		}

		List<Event> eventList = session.createQuery(
				" select e from Event e where e.cat.name = 'Ketty' ").list();

		List<Cat> bList = session.createQuery(
				" select c from Cat c left join c.events e "
						+ " where e.description like :description ")
				.setParameter("description", "%³ÔÔç·¹%").list();

		for (Cat ct : bList) {
			System.out.println(ct.getName());
		}

		for (Cat ct : (List<Cat>) session.getNamedQuery("cat by name").list()) {
			System.out.println("->" + ct.getName());
		}

		session.getTransaction().commit();
		session.close();

	}

}
