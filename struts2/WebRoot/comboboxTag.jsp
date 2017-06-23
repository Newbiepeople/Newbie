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

<%
	List<String> favouriteList = new ArrayList<String>();

	favouriteList.add("苹果");
	favouriteList.add("橘子");
	favouriteList.add("梨");
	favouriteList.add("香蕉");

	request.setAttribute("favouriteList", favouriteList);
%>

<struts:form action="login">
	<struts:combobox list="#request.favouriteList" name="favourite" label="最喜欢的水果" />
</struts:form>

</body>
</html>
