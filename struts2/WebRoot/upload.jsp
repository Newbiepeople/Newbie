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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<struts:head theme="ajax" />
	<style type="text/css">
	body, td {font-size: 12px; }
	</style>
  </head>
  
  <body>
  
  		<struts:actionerror/>
  
  		<struts:form action="upload" enctype="multipart/form-data" method="post" validate="true">
  			<struts:label value="上传文件"></struts:label>
  			<struts:file name="picture" label="文件一"></struts:file>
  			<struts:submit value=" 开始上传 " method="upload"></struts:submit>
  		</struts:form>
  
  </body>
</html>
