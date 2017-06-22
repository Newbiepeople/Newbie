package com.nwnu.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.nwnu.dao.ExamDao;
import com.nwnu.dao.QuestionDao;
import com.nwnu.dao.SubjectDao;
import com.nwnu.model.Exam;
import com.nwnu.model.PageBean;
import com.nwnu.model.Question;
import com.nwnu.model.Student;
import com.nwnu.model.Subject;
import com.nwnu.util.PageUtil;
import com.nwnu.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ExamAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ExamDao examDao=new ExamDao();
	private QuestionDao questionDao=new QuestionDao();
	private SubjectDao subjectDao = new SubjectDao();
	
	private HttpServletRequest request;
	
	private Exam exam;
	private Exam s_exam;
	private String mainPage;
	
	
	private List<Exam> examList;
	
	private String page;
	private int total;
	private String pageCode;
	
	public List<Exam> getExamList() {
		return examList;
	}


	public void setExamList(List<Exam> examList) {
		this.examList = examList;
	}




	public Exam getExam() {
		return exam;
	}

	


	public Exam getS_exam() {
		return s_exam;
	}




	public void setS_exam(Exam s_exam) {
		this.s_exam = s_exam;
	}




	public void setExam(Exam exam) {
		this.exam = exam;
	}




	public String getMainPage() {
		return mainPage;
	}




	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	
	

	public String getPage() {
		return page;
	}




	public void setPage(String page) {
		this.page = page;
	}




	public int getTotal() {
		return total;
	}




	public void setTotal(int total) {
		this.total = total;
	}




	public String getPageCode() {
		return pageCode;
	}




	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}



	public String add()throws Exception{
		List<Subject> list = new ArrayList<Subject>();
		Map<String,String[]> keyMap=request.getParameterMap();
		
		Set<String> keys = keyMap.keySet();
		Iterator<String> its  = keys.iterator();
		while (its.hasNext()) {
			String[] strs = keyMap.get(its.next());
			for (int i = 0; i < strs.length; i++) {
				System.out.print(strs[i]);
			}
			System.out.println("\n\t\n\n\n\n\n\n");
		}
		
		
		Iterator<Entry<String,String[]>> it2=keyMap.entrySet().iterator();
		int totalScore=0;
		int singleScore=0;
		int moreScore=0;
		while(it2.hasNext()){
			Entry<String,String[]> entry=it2.next();
			String keyStr=entry.getKey();
			String values[]=entry.getValue();
			String key;
			String value="";
			if(keyStr.equals("exam.student.id")||keyStr.equals("exam.paper.id")){
				continue;
			}
			if("answer".equals(keyStr.split("-")[1])){
				list.add(new Subject(exam,values[0]));
			}else if("r".equals(keyStr.split("-")[1])){ // 单选题目
				key=keyStr.split("-")[2];
				value=values[0];
				singleScore+=this.calScore(key, value, "1");
			}else if("c".equals(keyStr.split("-")[1])){  // 多选
				key=keyStr.split("-")[2];
				for(String s:values){
					value+=s+",";
				}
				value=value.substring(0, value.length()-1);
				moreScore+=this.calScore(key, value, "2");
			}
		}
		totalScore=singleScore+moreScore;
		exam.setSingleScore(singleScore);
		exam.setMoreScore(moreScore);
		exam.setScore(totalScore);
		exam.setExamDate(new Date());
		exam.setSubjects(list);
		examDao.saveExam(exam);
		
		System.out.println(exam.toString());
		mainPage="exam/examResult.jsp";
		return SUCCESS;
	}

	
	private int calScore(String questionId,String userAnswer,String type)throws Exception{
		Question question=questionDao.getQuestion(questionId);
		if(userAnswer.equals(question.getAnswer())){
			if("1".equals(type)){
				return 1;
			}else if("2".equals(type)){
				return 2;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	
	public String getExams()throws Exception{
		examList=examDao.getExams(s_exam,null);
		mainPage="exam/myExam.jsp";
		return SUCCESS;
	}
	
	public String list()throws Exception{
		HttpSession session=request.getSession();
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		if(s_exam==null){
			Object o=session.getAttribute("s_exam");
			if(o!=null){
				s_exam=(Exam)o;
			}else{
				s_exam=new Exam();				
			}
		}else{
			session.setAttribute("s_exam", s_exam);
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),3);
		examList=examDao.getExams(s_exam,pageBean);
		total=examDao.examCount(s_exam);
		pageCode=PageUtil.genPagination(request.getContextPath()+"/exam!list", total, Integer.parseInt(page), 3);
		mainPage="exam/examList.jsp";
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

}
