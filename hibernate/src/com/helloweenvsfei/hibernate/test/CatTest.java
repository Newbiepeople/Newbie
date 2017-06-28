package com.helloweenvsfei.hibernate.test;

import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class CatTest {

	public static void main(String[] args) {

		Cat mother = new Cat();
		mother.setName("Mary White");
		mother.setDescription("The Mama cat. ");
		mother.setCreateDate(new Date());

		Cat kitty = new Cat();
		kitty.setName("Kitty");
		kitty.setDescription("Hello Kitty. ");
		kitty.setMother(mother);
		kitty.setCreateDate(new Date());

		Cat mimmy = new Cat();
		mimmy.setName("Mimmy");
		mimmy.setDescription("Kitty's little twin sister. ");
		mimmy.setMother(mother);
		mimmy.setCreateDate(new Date());

		// 开启一个 Hibernate 对话
		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		// 开启一个事务
		Transaction trans = session.beginTransaction();

		// 将三只猫的资料保存到数据库
		session.persist(mother);
		session.persist(kitty);
		session.persist(mimmy);

		// 查询数据中的所有的猫
		@SuppressWarnings("all")
		List<Cat> catList = session.createQuery(" from Cat ").list();

		StringBuffer result = new StringBuffer();
		result.append("数据库里的所有的猫：\r\n\r\n");

		// 遍历 输出猫与猫妈妈
		for (Cat cc : catList) {
			result.append("猫: " + cc.getName() + ",          ");
			result.append("猫妈妈: "
					+ (cc.getMother() == null ? "没有记录" : cc.getMother()
							.getName()));
			result.append("\r\n");
		}

		trans.commit();
		session.close();

		// 用 Swing 显示查询结果
		JOptionPane.getRootFrame().setFont(new Font("Arial", Font.BOLD, 14));
		JOptionPane.showMessageDialog(null, result.toString());
	}
}
