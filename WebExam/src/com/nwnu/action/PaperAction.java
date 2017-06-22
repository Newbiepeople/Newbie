package com.nwnu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.nwnu.dao.PaperDao;
import com.nwnu.dao.QuestionDao;
import com.nwnu.model.Paper;
import com.nwnu.model.Question;
import com.nwnu.util.ExcelReader;
import com.nwnu.util.ResponseUtil;
import com.nwnu.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class PaperAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PaperDao paperDao = new PaperDao();
	private QuestionDao questionDao = new QuestionDao();

	private String mainPage;

	private String file;

	private String fileFileName;
	private ExcelReader excelReader;

	private List<Paper> paperList = new ArrayList<Paper>();

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	private String paperId;
	private Paper paper;

	private List<Question> squestionList = new ArrayList<Question>();
	private List<Question> mquestionList = new ArrayList<Question>();
	private List<Question> tquestionList = new ArrayList<Question>();

	private String title;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public List<Question> getSquestionList() {
		return squestionList;
	}

	public void setSquestionList(List<Question> squestionList) {
		this.squestionList = squestionList;
	}

	public List<Question> getMquestionList() {
		return mquestionList;
	}

	public void setMquestionList(List<Question> mquestionList) {
		this.mquestionList = mquestionList;
	}

	public List<Question> getTquestionList() {
		return tquestionList;
	}

	public void setTquestionList(List<Question> tquestionList) {
		this.tquestionList = tquestionList;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public List<Paper> getPaperList() {
		return paperList;
	}

	public void setPaperList(List<Paper> paperList) {
		this.paperList = paperList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String list() throws Exception {
		paperList = paperDao.getPapers();
		mainPage = "exam/selectPaper.jsp";
		return SUCCESS;
	}

	public String paperList() throws Exception {
		paperList = paperDao.getPapers();
		mainPage = "paper/paperList.jsp";
		return SUCCESS;
	}

	public String deletePaper() throws Exception {
		paper = paperDao.getPaper(paperId);
		JSONObject resultJson = new JSONObject();
		if (questionDao.existQuestionByPaperId(paperId)) {
			resultJson.put("error", "试卷下有题目不能删除！");
		} else {
			paperDao.paperDelete(paper);
			resultJson.put("success", true);
		}
		ResponseUtil.write(resultJson, ServletActionContext.getResponse());
		return null;
	}

	public String getDetailPaper() throws Exception {
		paper = paperDao.getPaper(paperId);
		Set<Question> questionList = paper.getQuestions();
		Iterator<Question> it = questionList.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			if ("1".equals(q.getType())) {
				squestionList.add(q);
			} else if ("2".equals(q.getType())) {
				mquestionList.add(q);
			} else {
				tquestionList.add(q);
			}
		}
		squestionList = this.getRandowQuestion(squestionList, 3);
		mquestionList = this.getRandowQuestion(mquestionList, 2);
		tquestionList = this.getRandowQuestion(tquestionList, 1);
		mainPage = "exam/paper.jsp";
		return SUCCESS;
	}

	private List<Question> getRandowQuestion(List<Question> questionList, int num) {
		List<Question> resultList = new ArrayList<Question>();
		Random random = new Random();
		if (num > 0) {
			for (int i = 1; i <= num; i++) {
				int n = random.nextInt(questionList.size());
				Question q = questionList.get(n);
				if (resultList.contains(q)) {
					i--;
				} else {
					resultList.add(q);
				}
			}
		}
		return resultList;
	}

	public String preSave() throws Exception {
		if (StringUtil.isNotEmpty(paperId)) {
			paper = paperDao.getPaper(paperId);
			title = "修改试卷";
		} else {
			title = "添加试卷";
		}
		mainPage = "paper/paperSave.jsp";
		return SUCCESS;
	}

	public String preAddExcel() throws Exception {
		if (StringUtil.isNotEmpty(paperId)) {
			paper = paperDao.getPaper(paperId);
			title = "修改试卷和试题";
		} else {
			title = "添加试卷和试题";
		}
		mainPage = "paper/preAddExcel.jsp";
		return SUCCESS;
	}
	
	//下载考题模版(动态生成)
			public void getModel() throws IOException{
				List<Object> bookList = new ArrayList<Object>();//拼装生成文件用的信息
				List<Object> sheetList = new ArrayList<Object>();
				sheetList.add("考试试题");	//添加工作表名称 - 位置0
				List<String> list = new ArrayList<String>();
				list.add("type");list.add("subject");list.add("optionA");list.add("optionB");list.add("optionC");list.add("optionD");
				list.add("answer");
				sheetList.add(list);	//添加工作表表头(和导入模版一致) - 位置1
				bookList.add(sheetList);

				//设置response属性, 向页面传送文件输出流
				getServletResponse().setContentType("application/vnd.ms-excel"); 
				getServletResponse().addHeader("Content-Disposition","attachment;filename=\"papermodel.xls\"");
				OutputStream os = getServletResponse().getOutputStream(); 
				excelReader.writeExcel(os, bookList);//生成xls文件
			}
	
	public String savePaper() throws Exception {
		if (StringUtil.isNotEmpty(paperId)) {
			paper.setId(Integer.parseInt(paperId));
		} else {
			paper.setJoinDate(new Date());
		}
		if (StringUtil.isNotEmpty(file)) {
			Set<Question> questions = ExcelReader.getAllByExcel(upload(),paper);
			paper.setQuestions(questions);
		}
		paperDao.savePaper(paper);
		return "save";
	}

	public File upload() throws Exception {

		String path = ServletActionContext.getRequest().getRealPath("/upload/");
		OutputStream bw = new FileOutputStream(new File(path.trim(), fileFileName));
		InputStream br = new FileInputStream(new File(file));
		byte[] buf = new byte[1024];
		int n = 0;
		// 读取操作
		while ((n = br.read(buf)) != -1) {
			// 写操作
			bw.write(buf, 0, n);
		}
		// 关闭操作
		if (br != null) {
			br.close();
		}
		if (bw != null) {
			bw.close();
		}

		return new File(path +"/"+ fileFileName.trim());
	}

}
