package com.helloweenvsfei.hibernate.test;

import javax.swing.JOptionPane;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.dao.BaseDAO;
import com.helloweenvsfei.hibernate.dao.EventDAO;

public class EventTest {

	public static void main(String[] args) {

		Cat cat = new Cat();
		cat.setName("¼Ó·ÆÃ¨");

		Event event = new Event();
		event.setCat(cat);

		BaseDAO<Object> baseDAO = new BaseDAO<Object>();

		baseDAO.create(cat);
		baseDAO.create(event);

		// BaseDAO<Event> eventDAO = new BaseDAO<Event>();
		BaseDAO<Event> eventDAO = new EventDAO<Event>();

		try {
			Event ev = eventDAO.find(Event.class, event.getId());

			JOptionPane.showMessageDialog(null, "ev.getCat().getName(): \r\n"
					+ ev.getCat().getName());
		} catch (Throwable e) {

			e.printStackTrace();

			JOptionPane.showMessageDialog(null, e.getClass().getName()
					+ ": \r\n" + e.getMessage(), e.getClass().getName(),
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
