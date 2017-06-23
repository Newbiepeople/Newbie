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
	List<String> provinceList = new ArrayList<String>();
	provinceList.add("北京");
	provinceList.add("上海");
	provinceList.add("天津");
	provinceList.add("重庆");
	provinceList.add("河北");
	provinceList.add("河南");
	provinceList.add("山东");
	provinceList.add("山西");
	provinceList.add("江苏");
	provinceList.add("浙江");
	
	request.setAttribute("provinceList", provinceList);
%>

<struts:form action="login">
	<struts:select name="province" label="请选择省份" list="%{#request.provinceList}" />
	<struts:autocompleter name="province" label="请选择省份" list="%{#request.provinceList}" />
</struts:form>




</body>
</html>
