package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Post;
import com.helloweenvsfei.hibernate.bean.Tag;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXmlTagPost {

	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		Tag tag = new Tag();
		tag.setName("幽默");

		Tag tag2 = new Tag();
		tag2.setName("浪漫");

		Post post = new Post();
		post.setTitle("推荐一个好玩的广告，很有浪漫气息哦");
		post.setContent("见视频。自己看吧");
		post.getTags().add(tag);
		post.getTags().add(tag2);

		Session session = HibernateXMLUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// 保存进数据库
		session.persist(post);

		List<Post> list = session.createQuery(
				" select p from Post p left join fetch p.tags t "
						+ " where t.name = :name ").setParameter("name", "幽默")
				.list();

		System.out.println("与标签“幽默”相关的帖子，");
		for (Post p : list) {
			// session.refresh(p);
			System.out.println("标题：" + p.getTitle());
			System.out.print("所属标签：");
			for (Tag t : p.getTags()) {
				System.out.print(t.getName() + ", ");
			}
			System.out.println();
		}

		session.refresh(tag);

		System.out.println("标签”" + tag.getName() + "“下的相关帖子：");
		for (Post p : tag.getPosts()) {
			System.out.println("标题：" + p.getTitle());
			System.out.print("所属标签：");
			for (Tag t : p.getTags()) {
				System.out.print(t.getName() + ", ");
			}
			System.out.println();
		}

		session.getTransaction().commit();
		session.close();

	}

}
