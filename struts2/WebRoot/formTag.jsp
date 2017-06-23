<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
body,td {
	font-size: 12px;
}
table {border-collapse: collapse; border: 1px solid #000000; }
th, td {border: 1px solid #000000; }
</style>
</head>

<body>

<struts:form action="addBook" validate="true">
	<struts:label value="form 标签"></struts:label>
	<struts:textfield name="name" label="书名"></struts:textfield>
	<struts:textfield name="author" label="作者"></struts:textfield>
	<struts:submit value=" 提 交 " align="center"></struts:submit>
</struts:form>

</body>
</html>
