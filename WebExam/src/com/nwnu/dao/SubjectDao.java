package com.nwnu.dao;

import org.hibernate.Session;

import com.nwnu.model.Subject;
import com.nwnu.util.HibernateUtil;

public class SubjectDao {

	public void saveSubject(Subject suject)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(suject);
		session.getTransaction().commit();
	}
	
}
