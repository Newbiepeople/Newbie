<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		body, th, td {font-size: 12px; }
	</style>
	<struts:head theme="ajax" />
  </head>
  
  <body>
  		
  		<a href="<struts:url action="initAddBook" />">添加书籍</a>
  		<a href="<struts:url action="listBook" />">书籍列表</a>
  		<a href="<struts:url action="clearBook" />">清空书籍列表</a>
  		
  		<struts:form action="addBook" validate="true">
  			<struts:label value="添加书籍"></struts:label>
  			<struts:textfield name="book.name" label="书名"></struts:textfield>
  			<struts:textfield name="book.author" label="作者"></struts:textfield>
  			<struts:textfield name="book.publishedDate" label="出版日期"></struts:textfield>
  			<struts:submit value="添加"></struts:submit>
  		</struts:form>
  
  </body>
</html>
