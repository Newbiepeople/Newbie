<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
body,td {
	font-size: 12px;
}
</style>
</head>

<body>

	输入无效。 <br/>
	<struts:fielderror /><br/>
	已经输入的姓名：<struts:property value="NAMES" /><br/>
	<br/>
	<a href="tokenInput.action">&lt;&lt; 重新输入</a> <a href="javascript:location=location;">重复提交数据</a>
	
</body>
</html>
