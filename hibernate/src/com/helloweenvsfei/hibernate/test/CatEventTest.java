package com.helloweenvsfei.hibernate.test;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import junit.framework.TestCase;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.dao.BaseDAO;

public class CatEventTest extends TestCase {

	public void testOneToMany() {

		// Cat
		Cat cat = new Cat();
		cat.setName("Doraemon");
		cat.setCreateDate(new Date());

		// Event
		Event event = new Event();
		event.setCat(cat);
		event.setDescription("Doraemon 去上课了。");
		event.setCreateDate(new Date());

		// Event
		Event event2 = new Event();
		event2.setCat(cat);
		event2.setDescription("Doraemon 回家检查身体。");
		event2.setCreateDate(new Date());

		cat.getEvents().add(event);
		cat.getEvents().add(event2);

		// 利用BaseDAO保存所有的对象
		BaseDAO<Object> baseDAO = new BaseDAO<Object>();
		baseDAO.create(cat);
		baseDAO.create(event);
		baseDAO.create(event2);

		// 查询刚刚插入的Cat, 将连同该Cat的所有Event一块查出来
		int catId = cat.getId();
		Cat cc = (Cat) baseDAO.find(Cat.class, catId);

		// 输出该Cat的所有Event
		String s = cc.getName() + " 所有近况：\r\n";
		for (Event ev : cc.getEvents()) {
			s += "    - ["
					+ DateFormat.getTimeInstance()
							.format(event.getCreateDate()) + "] "
					+ ev.getDescription() + "\r\n";
		}

		JOptionPane.showMessageDialog(null, s);
	}
}
