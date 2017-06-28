package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Sailor;
import com.helloweenvsfei.hibernate.bean.Ship;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXmlShipSailor {

	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		Ship ship = new Ship();
		ship.setName("泰坦尼克");

		Sailor captain = new Sailor();
		captain.setName("史密斯");
		captain.setShip(ship);

		Sailor sailor = new Sailor();
		sailor.setName("杰克");
		sailor.setShip(ship);

		ship.setCaptain(captain);
		ship.getSailors().add(captain);
		ship.getSailors().add(sailor);

		Session session = HibernateXMLUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.persist(ship);

		List<Sailor> list = session.createQuery(
				" select s from Sailor s where s.ship.name = :name ")
				.setParameter("name", "泰坦尼克").list();

		for (Sailor s : list) {
			System.out.println("水手：" + s.getName());
			System.out.println("舰船：" + s.getShip().getName());
			System.out.println("船长：" + s.getShip().getCaptain().getName());
			System.out.println("-----------------");
		}

		session.getTransaction().commit();
		session.close();

	}

}
