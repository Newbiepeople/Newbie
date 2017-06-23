package com.helloweenvsfei.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.helloweenvsfei.struts2.bean.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

//@Validation()
public class BookAction extends ActionSupport {

	private static final long serialVersionUID = -38241432793476229L;

	public static List<Book> bookList = new ArrayList<Book>();

	private String title;

	private Book book;

	// 添加书籍页面
	@SkipValidation
	public String initAdd() {
		return "initAdd";
	}

	// 添加书籍
	@Validations(requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.SIMPLE, trim = true, fieldName = "book.name", message = "请输入书籍名称. *"),
			@RequiredStringValidator(type = ValidatorType.SIMPLE, trim = true, fieldName = "book.author", message = "请输入书籍作者. *") }, dateRangeFields = { @DateRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "book.publishedDate", min = "1900-01-01", max = "2200-01-01", message = "日期必须大于 ${min} 小于 ${max}, 当前值为 ${book.publishedDate}.") })
	public String add() {
		bookList.add(book);
		title = "<br/><br/>添加书籍成功<br/><br/>";
		return "success";
	}

	// 书籍列表
	@SkipValidation
	public String list() {
		return "list";
	}

	// 清空书籍列表
	@SkipValidation
	public String clear() {
		bookList.clear();
		title = "<br/><br/>清空书籍列表成功<br/><br/>";
		return "list";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
