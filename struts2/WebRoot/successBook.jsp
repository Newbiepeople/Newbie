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
		table {border-collapse: collapse; border: 1px solid #000000; margin-top: 20px; }
		th, td {border: 1px solid #000000; font-size: 12px; }
		body {font-size: 12px; }
	</style>
  </head>
  
  <body>
  
  		<a href="<struts:url action="initAddBook" />">添加书籍</a>
  		<a href="<struts:url action="listBook" />">书籍列表</a>
  		<a href="<struts:url action="clearBook" />">清空书籍列表</a>
  		 
  		 <struts:property value="title" escape="false"/>
  	
  </body>
</html>
