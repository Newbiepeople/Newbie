package com.nwnu.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nwnu.model.Exam;
import com.nwnu.model.PageBean;
import com.nwnu.model.Student;
import com.nwnu.util.HibernateUtil;
import com.nwnu.util.StringUtil;

public class ExamDao {

	public void saveExam(Exam exam)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(exam);
		session.getTransaction().commit();
	}
	/**
	 * 根据条件获取考试信息
	 * @param s_exam
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<Exam> getExams(Exam s_exam,PageBean pageBean)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		StringBuffer hql=new StringBuffer("from Exam exam");
		if(s_exam.getStudent()!=null&&StringUtil.isNotEmpty(s_exam.getStudent().getId())){
			hql.append(" and exam.student.id='"+s_exam.getStudent().getId()+"'");
		}
		if(s_exam.getStudent()!=null&&StringUtil.isNotEmpty(s_exam.getStudent().getName())){
			hql.append(" and exam.student.name like '%"+s_exam.getStudent().getName()+"%'");
		}
		Query query=session.createQuery(hql.toString().replaceFirst("and", "where"));
		if(pageBean!=null){
			query.setFirstResult(pageBean.getStart());
			query.setMaxResults(pageBean.getPageSize());
		}
		@SuppressWarnings("unchecked")
		List<Exam> examList=query.list();
		session.getTransaction().commit();
		return examList;
	}
	
	public int examCount(Exam s_exam)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		StringBuffer sql=new StringBuffer("select count(*) from t_exam t1,t_student t2 where t1.studentId=t2.id ");
		if(s_exam.getStudent()!=null&&StringUtil.isNotEmpty(s_exam.getStudent().getId())){
			sql.append(" and t2.id='"+s_exam.getStudent().getId()+"'");
		}
		if(s_exam.getStudent()!=null&&StringUtil.isNotEmpty(s_exam.getStudent().getName())){
			sql.append(" and t2.name like '%"+s_exam.getStudent().getName()+"%'");
		}
		Query query=session.createSQLQuery(sql.toString());
		int count=((BigInteger)query.uniqueResult()).intValue();
		session.getTransaction().commit();
		return count;
	}
}
