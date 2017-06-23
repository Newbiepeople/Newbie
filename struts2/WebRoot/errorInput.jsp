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
<style type="text/css">
body, td, div, li {font-size: 12px; }
table {width: 350px; }
</style>
</head>

<body>

FieldErrors:
<div style="color: red; font-weight: bold;">
	<struts:fielderror />
</div>

ActionErrors:
<div style="color: red; font-weight: bold;">
	<struts:actionerror />
</div>


ActionMessages:
<div style="color: green; font-weight: bold;">
<struts:actionmessage />
</div>

<hr />

<struts:form action="error" method="get">
	<struts:label label="Error、Message、FieldError 演示" />
	<struts:submit value="执行 execute()" />
	<struts:submit value="执行 fieldError()" method="fieldError" />
	<struts:submit value="执行 error()" method="error" />
	<struts:submit value="执行 message()" method="message" />
</struts:form>

</body>
</html>
