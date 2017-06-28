package com.helloweenvsfei.hibernate.test;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Email;
import com.helloweenvsfei.hibernate.bean.Person2;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestLazyInitializationException {

	static int createdId = 0;

	static {// 类加载的时候保存一个Person

		Person2 person = new Person2();// 初始化一个 Person 实例
		person.setName("Jane");

		Email email = new Email();
		email.setEmail("yahoo@yahoo.com.cn");
		person.getEmails().add(email);

		Session session = HibernateSessionFactory.getSession(); // 开启会话
		session.beginTransaction(); // 开启事务

		session.persist(person);// 保存到数据库
		createdId = person.getId();// 将ID保存起来

		session.getTransaction().commit();// 提交事务
		session.close(); // 关闭会话
	}

	public static void main(String[] args) throws Exception {

		Session session = HibernateSessionFactory.getSession();// 查询不用开启事务
		Person2 p = (Person2) session.get(Person2.class, createdId);
		session.close();

		try {
			List<Email> list = p.getEmails(); // 加载数据，将会抛出异常

			System.out.println(p.getName() + " 的电子邮件: ");
			for (Email mail : list) {	// 循环输出Email
				System.out.println("\t" + mail.getEmail());
			}
		} catch (Exception e) {
			String title = e.getClass().getName();
			String msg = e.getMessage().replace(",", ",\r\n").replace(":",
					":\r\n");
			JOptionPane.showMessageDialog(null, msg, title,
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
