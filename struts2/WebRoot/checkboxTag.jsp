<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

<struts:form action="login">
	<struts:textfield name="textfield" label="文本框" required="true" tooltip="这是一个文本框" />
	<struts:password name="password" label="密码域" tooltip="这是密码域" />
	<struts:textarea name="textarea" label="文本域" tooltip="这是文本域" />
	<struts:file name="file" label="文件域" tooltip="这是文件域" />
	<struts:radio list="#{'male':'男', 'female':'女'}" name="sex" label="单选框" tooltip="这是单选框" />
	<struts:checkbox name="hobby" label="是否精通 Struts 2" value="true"  />
	<struts:submit value="   提  交   " method="logout" align="center" />
</struts:form>


</body>
</html>
