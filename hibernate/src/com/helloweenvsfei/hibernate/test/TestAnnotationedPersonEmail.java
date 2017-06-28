package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Email;
import com.helloweenvsfei.hibernate.bean.Person2;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedPersonEmail {

	public static void main(String[] args) throws Exception {

		Person2 person = new Person2();
		person.setName("Jane");

		Email email = new Email();
		email.setEmail("yahoo@yahoo.com.cn");
		person.getEmails().add(email);

		email = new Email();
		email.setEmail("163@163.com");
		person.getEmails().add(email);

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		// 保存 Person 对象，会自动级联保存 Email 对象
		session.persist(person);

		// 查找拥有 雅虎中文邮箱 的所有用户
		List list = session.createQuery(
				" select p from Person2 p left join fetch p.emails e "
						+ " where e.email like '%@yahoo.com.cn' ").list();

		// 输出用户及其所有的用户
		for (Person2 p : (List<Person2>) list) {
			System.out.println("Person: " + p.getName());
			for (Email e : p.getEmails()) {
				System.out.println("\tEmail: " + e.getEmail());
			}
		}

		// 删除 Person 对象，会自动级联删除属于它的 Email 数据库记录
		session.delete(person);

		session.getTransaction().commit();
		session.close();

	}
}
