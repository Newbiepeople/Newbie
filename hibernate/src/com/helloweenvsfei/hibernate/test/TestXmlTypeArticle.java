package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Article;
import com.helloweenvsfei.hibernate.bean.Type;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXmlTypeArticle {

	public static void main(String[] args) throws Exception {

		Type type = new Type();
		type.setName("学术论文");

		Article article = new Article();
		article.setType(type);
		article.setName("明清时代古典小说研究");
		article.setContent("  明清时代是中国古典小说的高峰时期，涌现了一批经典的小说。四大名著便是产于这个时期。");

		Session session = HibernateXMLUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.persist(article);

		List<Article> list = session.createQuery(
				" select a from Article a where a.name like '%明清%'  ").list();

		for (Article a : list) {
			System.out.println("类别：" + a.getType().getName());
			System.out.println("标题：" + a.getName());
			System.out.println("概要：" + substring(a.getContent(), 50));
			System.out.println("----------------------");
		}

		session.getTransaction().commit();
		session.close();

	}

	private static String substring(String content, int i) {
		return content == null ? "" : content.length() < i + 1 ? content
				: content.substring(0, i);
	}
}
