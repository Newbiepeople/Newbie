package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Person3;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXmlPersonEmail3 {

	public static void main(String[] args) throws Exception {

		Person3 person = new Person3();
		person.setName("Jane");

		person.getEmails().add("yahoo@yahoo.com.cn");
		person.getEmails().add("163@163.com");

		Session session = HibernateXMLUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// 保存 Person 对象，会自动级联保存 Email 对象
		session.persist(person);

		// 查找拥有 雅虎中文邮箱 的所有用户
		List list = session.createQuery(
				" select p from Person3 p left join fetch p.emails e "
						+ " where e like '%@yahoo.com.cn' ").list();

		// 输出用户及其所有的用户
		for (Person3 p : (List<Person3>) list) {
			System.out.println("Person: " + p.getName());
			for (String e : p.getEmails()) {
				System.out.println("\tEmail: " + e);
			}
		}

		// 删除 Person 对象，会自动级联删除属于它的 Email 数据库记录
		session.delete(person);

		session.getTransaction().commit();
		session.close();

	}
}
